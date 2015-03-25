(ns ^{:author "Vladislav Bauer"}
  leiningen.typescript
  (:require [leiningen.help :as help]
            [lein-typescript.core :as core]))


; External API: Task

(defn typescript
  "Invoke the TypeScript compiler.

  Configure :typescript configuration parameter in the file project.clj using following options:
    :sources     - List of glob patterns to define input sources.
    :excludes    - List of glob patterns to prevent processing of some files.

  Usage:
    lein typescript"

  [project & args]
  (if (= args ["help"])
    (println (help/help-for core/DEF_TYPESCRIPT_CMD))
    (core/typescript project args)))
