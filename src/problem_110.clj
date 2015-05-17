(fn pron [input]
 (lazy-seq
  (let [ys (partition-by identity input)
        zs (apply concat (map (fn [xs] [(count xs) (first xs)]) ys))]
   (cons zs (pron zs)))))