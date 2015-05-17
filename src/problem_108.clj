(fn __ [& args]
 (let [eins (map first args)
       ok (apply = eins)
       minval (->> eins
                   (filter (complement nil?))
                   (apply min))]
  (if ok minval (apply __ (map (fn [xs] (drop-while #(<= % minval) xs)) args)))))