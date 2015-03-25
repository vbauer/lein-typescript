(ns ^{:author "Vladislav Bauer"}
  lein-typescript.core
  (:import [java.io File])
  (:require [leiningen.npm :as npm]
            [leiningen.npm.process :as process]
            [leiningen.core.main :as main]
            [me.raynes.fs :as fs]
            [clojure.java.io :as io]
            [clojure.string :as string]))


; Internal API: Common

(defn- error [ex]
  (println
   (string/join
    "\r\n"
    [(str "An error has occurred: " (.getMessage ex))
     "Something is wrong:"
     " - installation: npm install typescript -g"
     " - configuration: https://github.com/vbauer/lein-typescript"])))

(defn- to-coll [e] (if (nil? e) [] (if (sequential? e) e [e])))
(defn- scan-files [patterns] (set (mapcat fs/glob patterns)))
(defn- file-path [& parts] (string/join File/separator parts))
(defn- abs-path [f] (.getAbsolutePath f))


; Internal API: Configuration

(def ^:public DEF_TYPESCRIPT_CMD "tsc")
(def ^:private DEF_TYPESCRIPT_DIR
  (file-path "node_modules" "typescript" "bin"))


(defn- configs [project] (to-coll (get project :typescript)))
(defn- config-files [conf k]
  (scan-files (to-coll (get conf k))))

(defn- conf-sources [conf] (config-files conf :sources))
(defn- conf-excludes [conf] (config-files conf :excludes))
(defn- conf-out [conf] (get conf :out))
(defn- conf-out-dir [conf] (get conf :out-dir))
(defn- conf-debug [conf] (get conf :debug false))
(defn- conf-remove-comments [conf] (get conf :remove-comments false))


; Internal API: Runner configuration

(defn- source-list [conf]
  (let [src (conf-sources conf)
        ex (conf-excludes conf)
        sources (remove (fn [s] (some #(.compareTo % s) ex)) src)]
    (if (empty? sources)
      (throw (RuntimeException.
              "Source list is empty. Check parameters :sources & :excludes"))
      (map abs-path sources))))

(defn- param-out [conf] (if-let [out (conf-out conf)] ["--out" out]))
(defn- param-out-dir [conf] (if-let [out-dir (conf-out-dir conf)] ["--outDir" out-dir]))
(defn- param-remove-comments [conf] (if (conf-remove-comments conf) ["--removeComments"]))


; Internal API: Runner

(defn- typescript-cmd []
  (let [local (file-path DEF_TYPESCRIPT_DIR DEF_TYPESCRIPT_CMD)]
    (if (.exists (io/file local)) local DEF_TYPESCRIPT_CMD)))

(defn- typescript-params [conf]
  (concat
   (param-out conf)
   (param-out-dir conf)
   (param-remove-comments conf)
   (source-list conf)))

(defn- compile-typescript [project conf]
  (let [root (:root project)
        cmd (typescript-cmd)
        params (typescript-params conf)
        args (concat [cmd] params)]
    (if (conf-debug conf)
      (println (string/join " " args)))
    (process/exec root args)))

(defn- process-config [project conf]
  (try
    (do
      (npm/environmental-consistency project)
      (compile-typescript project conf))
    (catch Throwable t
      (if (conf-debug conf)
        (.printStackTrace t))
      (error t)
      (main/abort))))


; External API: Runner

(defn typescript [project & args]
  (let [confs (configs project)]
    (doseq [conf confs]
      (process-config project conf))))
