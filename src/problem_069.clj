(fn __ [f & dicts]
 (let [allkeys (set (mapcat keys dicts))]
  (apply hash-map
         (mapcat (fn [k]
                  (let [vals (->> dicts
                                  (map #(get % k :nil))
                                  (filter #(not= % :nil)))]
                   [k (if (= 1 (count vals)) (first vals) (apply f vals))]))
                 allkeys))))