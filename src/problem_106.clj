(ns problem-106)

(defn __ [source target]
  (let [halve (fn [x] (/ x 2))
        add-2 (fn [x] (+ x 2))
        twice (fn [x] (* x 2))
        enque (fn [q x d]
                (let [q' (->> q
                              (cons [(add-2 x) d])
                              (cons [(twice x) d]))]
                  (if (odd? x) q' (cons [(halve x) d] q'))))]
    (loop [q (enque (list [source 1]) source 2)]
      (let [[x d] (last q)
            q' (butlast q)]
        (if (= x target)
          d
          (recur (enque q' x (inc d))))))))
