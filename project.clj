(defproject lein-typescript "0.1.3"
  :description "A Leiningen plugin for running TypeScript compiler"
  :url "https://github.com/vbauer/lein-typescript"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[lein-npm "0.6.2" :exclusions [org.clojure/clojure]]
                 [me.raynes/fs "1.4.6" :exclusions [org.clojure/clojure]]]

  :pedantic? :abort
  :eval-in-leiningen true
  :local-repo-classpath true)
