(fn commonsum? [& colls]
 (let [pow2 (fn [n] (bit-shift-left 1 n))
       bitnote (fn bitnote
                ([x] (bitnote x 0))
                ([x i]
                 (if (< x (pow2 i))
                  []
                  (if (pos? (bit-and x (pow2 i)))
                   (cons i (bitnote x (inc i)))
                   (bitnote x (inc i))))))
       subsets (fn [coll]
                (let [coll' (vec coll)
                      fetch (fn [x]
                             (let [x' (bitnote x)]
                              (map (partial get coll') x')))]
                 (map fetch (range 1 (pow2 (count coll'))))))
       subsetsums (fn [subs]
                   (set (map (partial apply +) (subsets subs))))]
  (if (not-empty (apply clojure.set/intersection (map subsetsums colls))) true false)))