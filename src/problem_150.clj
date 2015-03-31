(fn __ [n]
  (let [from (fn [n]
               (let [strnum (str n)
                     x (quot (count strnum) 2)
                     h (apply str (drop-last x strnum))]
                 (read-string h)))
        odds (->>
              (iterate inc (from n))
              (map str)
              (map #(concat % (reverse (butlast %))))
              (map #(read-string (apply str %))))
        evens (->>
               (iterate inc (max 1 (from n)))
               (map str)
               (map #(concat % (reverse %)))
               (map #(read-string (apply str %))))
        pick (fn pick [[x & xs :as xall] [y & ys :as yall]]
               (lazy-seq
                (if (< x y)
                  (cons x (pick xs yall))
                  (cons y (pick ys xall)))))]
    (->>
     (pick odds evens)
     (filter #(<= n %)))))
