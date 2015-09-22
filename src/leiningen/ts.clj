(ns ^{:author "Vladislav Bauer"}
  leiningen.ts
  (:require [leiningen.typescript :as typescript]))


; External API: Task

(defn ts
  "Alias for \"typescript\" task."
  [project & args]
  (typescript/typescript project args))
