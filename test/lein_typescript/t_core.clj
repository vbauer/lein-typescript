(ns ^{:author "Vladislav Bauer"}
  lein-typescript.t-core
  (:require [clojure.test :as t]
            [lein-typescript.core]
            [me.raynes.fs :as fs]))


; TODO: write unit tests

(t/deftest testing
 (t/is (= 4 (+ 2 2)))
 (t/is (= 7 (+ 3 4))))
