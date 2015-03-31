(fn __ [[[a b c]
         [d e f]
         [g h i] :as board]]
  (let [B (set board)
        Bt (set (apply map list board))
        test (fn [x]
               (let [x3 (list x x x)]
                 (or
                  (B x3)
                  (Bt x3)
                  (= x3 [a e i])
                  (= x3 [c e g]))))]
    (cond
     (test :x) :x
     (test :o) :o
     :else nil)))
