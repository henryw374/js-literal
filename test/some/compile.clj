(ns compile
  (:require [cljs.build.api :as cljs]
            [com.widdindustries.js]))


(def debug-opts 
  {:pseudo-names true
   :pretty-print true})

(defn build []
  (cljs/build
    (->
      {:optimizations :advanced
       :infer-externs true
       :main          'some.test
       :process-shim  false
       :output-dir    "target"
       :output-to     "target/main.js"}
      ;(merge debug-opts)
      )))

(comment
  (do
    (clojure.java.shell/sh "rm" "./target/some/test.js")
    (build))
  )
