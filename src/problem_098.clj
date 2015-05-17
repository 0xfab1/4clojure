(fn [f xs]
 (->> xs
      (map (fn [x] (->> xs (filter #(= (f %) (f x))) set)))
      set))