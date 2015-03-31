(fn __ [n pred coll]
  (->> (reduce (fn [[ls c] x]
                 (cond
                   (<= n c) [ls c]
                   (pred x) [(conj ls x) (inc c)]
                   :else [(conj ls x) c])
                 ) [[] 0] coll)
       first
       butlast))
