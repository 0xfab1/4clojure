(fn __ [coll1 coll2]
  (let [leven (memoize
               (fn [self [x & xs :as xall] [y & ys :as yall]]
                 (cond
                  (empty? xall) (count yall)
                  (empty? yall) (count xall)
                  :else (min
                         (+ (if (= x y) 0 1) (self self xs ys))
                         (inc (self self xs yall))
                         (inc (self self xall ys))))))]
    (leven leven coll1 coll2)))
