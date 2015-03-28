(ns ^{:author "Vladislav Bauer"}
  lein-typescript.t-core
  (:require [clojure.test :as t]
            [lein-typescript.core :as tsc]
            [me.raynes.fs :as fs]))


(def ^:private DEF_CONFIG
  {:typescript
   {:sources "example/resources/*.ts"}})


(t/deftest testing
 (t/is (nil? (tsc/typescript DEF_CONFIG))))
