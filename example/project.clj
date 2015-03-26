(defproject example "0.1.0-SNAPSHOT"
  :description "Simple example of using lein-typescript"
  :url "https://github.com/vbauer/lein-typescript"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}


  ; List of plugins
  :plugins [[lein-typescript "0.1.0-SNAPSHOT"]]

  ; List of hooks
  ; It's used for running lein-typescript during compile phase
  :hooks [lein-typescript.plugin]

  ; lein-typescript configuration
  :typescript {:sources ["resources\\*.ts"]
               :excludes ["123"]
               ;:out "app.js"
               :out-dir "target"
               :declaration true
               :remove-comments true
               :preserve-const-enums true})
