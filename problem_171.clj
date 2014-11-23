(fn [xs]
  (let [sorted-xs (sort xs)
        xs+1 (cons 0 (drop-last sorted-xs))
        diff (map - sorted-xs xs+1)
        bundle (fn bundle [[y & ys :as yall] [d & ds]]
                 (if (empty? yall)
                   '()
                   (let [tmp (bundle ys ds)]
                     (if (< d 2)
                       (cons (cons y (first tmp)) (drop 1 tmp))
                       (cons (list y) tmp)))))]
    (->> (bundle (reverse sorted-xs) (reverse diff))
         (map (fn [coll] [(apply min coll) (apply max coll)]))
         reverse)))
