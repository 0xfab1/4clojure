(fn [x]
  (let [prime? (fn [x] (and (or (= x 2) (odd? x)) (every? #(< 0 (mod x %)) (range 3 (+ 1 (Math/sqrt x)) 2))))]
    (if (or (= x 2) (not (prime? x))) false
      (let [p (->> (iterate dec (dec x)) (filter prime?) first)
            q (->> (iterate inc (inc x)) (filter prime?) first)]
        (= (/ (+ p q) 2) x)))))
