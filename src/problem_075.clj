(fn totient [x]
 (let [gcd (memoize (fn gcd [a b]
                     (cond
                      (< a b) (gcd a (- b a))
                      (> a b) (gcd (- a b) b)
                      :else a)))
       coprime? (fn [p q] (= 1 (gcd p q)))]
  (if (= x 1) 1 (apply + (map #(if (coprime? % x) 1 0) (range 1 x))))))