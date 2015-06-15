(ns problem-094)

(defn __ [matrix]
  (let [nrow (count matrix)
        ncol (count (first matrix))
        nbor (fn [x y dx dy]
               (let [x' (+ x dx)
                     y' (+ y dy)]
                 (if (and (< -1 x' ncol)
                          (< -1 y' nrow))
                   (cond
                     (= dx dy 0) 0
                     (= \# (get-in matrix [y' x'])) 1
                     :else 0)
                   0)))
        nbors (fn [x y]
                (apply + (for [dx [-1 0 1]
                               dy [-1 0 1]]
                           (nbor x y dx dy))))
        next-state (fn [state nb-count]
                     (cond
                       (= nb-count 3) true                  ; rule #4
                       (< nb-count 2) false                 ; rule #1
                       (< nb-count 4) state                 ; rule #2
                       :else false))]                       ; rule #3
    (for [y (range nrow)]
      (apply str
        (for [x (range ncol)]
          (let [cur-state (= \# (get-in matrix [y x]))
                nb-count (nbors x y)]
            (if (next-state cur-state nb-count) \# \space)))))))

(assert
  (= (__ ["      "
          " ##   "
          " ##   "
          "   ## "
          "   ## "
          "      "])
     ["      "
      " ##   "
      " #    "
      "    # "
      "   ## "
      "      "]))


(assert
  (= (__ ["     "
          "     "
          " ### "
          "     "
          "     "])
     ["     "
      "  #  "
      "  #  "
      "  #  "
      "     "]))

(assert
  (= (__ ["      "
          "      "
          "  ### "
          " ###  "
          "      "
          "      "])
     ["      "
      "   #  "
      " #  # "
      " #  # "
      "  #   "
      "      "]))

