(defproject lein-typescript "0.1.1-SNAPSHOT"
  :description "A Leiningen plugin for running TypeScript compiler"
  :url "https://github.com/vbauer/lein-typescript"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[lein-npm "0.5.0" :exclusions [org.clojure/clojure]]
                 [me.raynes/fs "1.4.6" :exclusions [org.clojure/clojure]]]

  :profiles {
    :dev {}
    :prod {:plugins [[lein-release "1.0.6" :exclusions [org.clojure/clojure]]]
           :scm {:name "git"
                 :url "https://github.com/vbauer/lein-typescript"}
           :lein-release {:deploy-via :clojars
                          :scm :git}}
  }

  :pedantic? :abort
  :eval-in-leiningen true
  :local-repo-classpath true)
