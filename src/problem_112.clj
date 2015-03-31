(defn __ [n [x & xs :as coll]]
  (if
    (empty? coll) [0 coll]
    (let [[tot xs'] (__ n xs)]
      (if (number? x)
        [(+ x tot) (cons x xs')]
        (let [[tot' xs''] (__ n x)] [(+ tot' tot) (cons xs'' xs')])))))

(__ 10 [1 2 [3 [4 5] 6] 7])

(__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
