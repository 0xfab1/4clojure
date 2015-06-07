(ns problem-053)
(defn __ [coll]
  (letfn [(pick-longer [coll1 coll2]
                       (if (> (count coll2)
                              (count coll1)) coll2 coll1))  ; favor coll1
          (aux [max-so-far [x & _ :as max-curr] [y & ys :as input]]
               (cond
                 (empty? input) (pick-longer max-so-far max-curr)
                 (< x y) (aux max-so-far (cons y max-curr) ys)
                 :else (aux (pick-longer max-so-far max-curr) [y] ys)))]
    (let [result (aux [] [(first coll)] (rest coll))]
      (if (< (count result) 2) [] (reverse result)))))

(assert (= (__ [1 0 1 2 3 0 4 5]) [0 1 2]))
(assert (= (__ [5 6 1 3 2 7]) [5 6]))
(assert (= (__ [2 3 3 4 5]) [3 4 5]))
(assert (= (__ [7 6 5 4]) []))

