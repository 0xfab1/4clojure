(fn [p v [x & xs :as X]]
  (if (empty? X) [] (apply concat (reductions #(if (p (last %1) %2) [v %2] [%2]) [x] xs))))
