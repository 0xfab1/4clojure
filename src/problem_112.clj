(defn __ [limit coll]
  (let [aux (fn aux [limit coll]
              (if (empty? coll)
                [limit coll]                                ; #1: empty case
                (let [[x & xs] coll]
                  (if (coll? x)                             ; is sequence
                    (let [[limit2 x'] (aux limit x)
                          [limit3 xs'] (aux limit2 xs)]
                      [limit3 (cons x' xs')])               ; #2
                    (if (> x limit)                         ; is number, and bigger than the limit
                      [0 []]                                ; #3: don't go beyond this
                      (let [limit2 (- limit x)
                            [limit3 xs'] (aux limit2 xs)]
                        [limit3 (cons x xs')]))))))]
    (second (aux limit coll))))

(assert (= (__ 10 [1 2 [3 [4 5] 6] 7])
           '(1 2 (3 (4)))))

(assert (= (__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
           '(1 2 (3 (4 (5 (6 (7))))))))

(assert (= (__ 9 (range))
           '(0 1 2 3)))

(assert (= (__ 1 [[[[[1]]]]])
           '(((((1)))))))

(assert (= (__ 0 [1 2 [3 [4 5] 6] 7])
           '()))

(assert (= (__ 0 [0 0 [0 [0]]])
           '(0 0 (0 (0)))))


(assert (= (__ 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
           '(-10 (1 (2 3 (4))))))