(fn __ [[x & xs :as coll]]
 (if (nil? coll)
  []
  (if (some coll? x)
   (concat (__ x) (__ xs))
   (cons x (__ xs)))))