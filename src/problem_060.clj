(fn red
 ([f [x1 x2 & xs]] (concat [x1] (red f (f x1 x2) xs)))
 ([f acc [x & xs]]
  (lazy-seq
   (let [acc' (f acc x)]
    (cons acc (if (empty? xs) [acc'] (red f acc' xs)))))))