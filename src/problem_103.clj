(fn __ [n coll]
  (let [occ (fn occ [x] (if (zero? x) 0 (+ (bit-and x 1) (occ (quot x 2)))))
        fetch (fn [coll n]
                (first
                  (reduce (fn [[acc n'] el]
                            (cond
                              (zero? n') [acc n']
                              (zero? (bit-and n' 1)) [acc (quot n' 2)]
                              :else [(conj acc el) (quot n' 2)])
                            ) [#{} n] coll)))]
    (->> (range (bit-shift-left 1 (count coll)))
         (map #(if (= n (occ %)) (fetch coll %) nil))
         (filter (complement nil?))
         set)))
