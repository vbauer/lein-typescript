(ns ^{:author "Vladislav Bauer"}
  lein-typescript.plugin
  (:require [leiningen.compile]
            [lein-npm.plugin :as npm]
            [robert.hooke :as hooke]
            [lein-typescript.core :as core]))


; Internal API: Configuration

(def ^:private DEF_TYPESCRIPT_DEP "typescript")
(def ^:private DEF_TYPESCRIPT_VER ">=1.8.10")


; Internal API: Middlewares

(defn- typescript? [dep]
  (= (str (first dep)) DEF_TYPESCRIPT_DEP))

(defn- find-typescript-deps [deps]
  (keep-indexed #(when (typescript? %2) %1) deps))

(defn- ensure-typescript [deps version]
  (let [typescript-matches (find-typescript-deps deps)
        new-dep [DEF_TYPESCRIPT_DEP (or version DEF_TYPESCRIPT_VER)]]
    (if (empty? typescript-matches)
      (conj deps new-dep) deps)))


; External API: Middlewares

(defn middleware [project]
  (let [version (get-in project [:typescript :version])]
    (update-in project [:node-dependencies]
               #(vec (ensure-typescript % version)))))


; External API: Hooks

(defn compile-hook [task project & args]
  (let [res (apply task project args)]
    (core/typescript project args)
    res))

(defn activate []
  (npm/hooks)
  (hooke/add-hook #'leiningen.compile/compile #'compile-hook))
