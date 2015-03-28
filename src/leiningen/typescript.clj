(ns ^{:author "Vladislav Bauer"}
  leiningen.typescript
  (:require [leiningen.help :as help]
            [lein-typescript.core :as core]))


; Constants
(def ^:private DEF_TYPESCRIPT_TASK "typescript")


; External API: Task

(defn typescript
  "Invoke the TypeScript compiler.

  Configure :typescript configuration parameter in the file project.clj using following options:
    :sources
      - List of glob patterns to define input sources.
    :excludes
      - List of glob patterns to prevent processing of some files.
    :out
      - Concatenate and emit output to single file.
    :out-dir
      - Redirect output structure to the directory.
    :declaration
      - Generates corresponding '.d.ts' file.
    :module
      - Specify module code generation: :commonjs or :amd
    :remove-comments
      - Do not emit comments to output.
    :preserve-const-enums
      - Do not erase const enum declarations in generated code.
    :suppress-implicit-any-index-errors
      - Suppress noImplicitAny errors for indexing objects lacking index signatures.

  Usage:
    lein typescript"

  [project & args]
  (if (= args ["help"])
    (println (help/help-for DEF_TYPESCRIPT_TASK))
    (core/typescript project args)))
