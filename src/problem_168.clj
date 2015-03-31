(fn infmat
  ([f]
   (let [range- (constantly (cons 0 (reductions + (repeatedly (constantly 1)))))]
     (map (fn [i] (map (fn [j] (f i j)) (range-))) (range-))))
  ([f m n]
   (let [drop- (fn [n coll] ((apply comp (repeatedly n (constantly rest))) coll))
         mat (infmat f)]
     (lazy-seq (drop- m (map #(drop- n %) mat)))))
  ([f m n s t]
   (let [mat (infmat f m n)]
     (lazy-seq (take s (map #(take t %) mat))))))
