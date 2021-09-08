(ns com.widdindustries.js
  (:require [clojure.walk :as walk]))

(defn read-js [form]
  (walk/postwalk
    (fn [form]
      (cond 
        (map-entry? form) form
        (keyword? form) (name form)
        (vector? form) `(js/Array.of ~@form)
        (map? form)  `(js/Object.fromEntries (js/Array.of
                                                ~@(map (fn [[k v]]
                                                         (list 'js/Array.of k v)) form)))
        :else form))
    form))

(comment 
  (read-js {:a [:a]})
  (read-js [:a {:b [:c]}])
  )