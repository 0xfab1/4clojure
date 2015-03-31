(fn [n a b]
  (let [S (fn [x d] (let [x' (quot x d)] (/ (*' d x' (inc x')) 2)))
        n' (dec n)]
    (-' (+' (S n' a) (S n' b)) (S n' (*' a b)))))
