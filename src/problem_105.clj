(fn [coll]
 (second
  (reduce (fn [[kw dict] x]
           (if (keyword? x)
            [x (assoc dict x [])]
            [kw (assoc dict kw (conj (dict kw) x))]))
          [nil, {}] coll)))