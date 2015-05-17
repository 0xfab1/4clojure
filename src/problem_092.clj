(fn __ [[x & [y & ys :as xs] :as text]]
 (let [ranks (zipmap "IVXLCDM" '(1 5 10 50 100 500 1000))]
  (cond
   (empty? text) 0
   (or (nil? xs) (empty? xs)) (ranks x)
   :else (let [rx (ranks x)
               ry (ranks y)]
          (if (< rx ry)
           (+ (- ry rx) (__ ys))
           (+ rx (__ xs)))))))