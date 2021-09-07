(ns com.widdindustries.js
  (:require [clojure.walk :as walk]))

(defn read-js [form]
  (walk/postwalk
    (fn [form]
      (cond 
        (map-entry? form) form
        (keyword? form) (name form)
        (vector? form) `(.of js/Array ~@form)
        (map? form)  `(.fromEntries js/Object (.of js/Array
                                                ~@(map (fn [[k v]]
                                                         (list '.of 'js/Array k v)) form)))
        :else form))
    form))

(comment 
  (read-js {:a [:a]})
  (read-js [:a {:b [:c]}])
  )