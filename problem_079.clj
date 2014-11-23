(fn __
  ([coll] (__ coll 0))
  ([[xs & rest] pos]
   (let [x (xs pos)]
     (if (empty? rest)
       x
       (let [lsum (__ rest pos)
             rsum (__ rest (inc pos))]
         (+ x (min lsum rsum)))))))
