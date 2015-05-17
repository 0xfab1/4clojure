(fn [coll]
 (if (associative? coll)
  (if (reversible? coll) :vector :map)
  (let [coll2 (conj coll :p1 :p2)]
   (if (= (first coll2) :p2) :list :set))))