(fn bal? [x]
 (let [x' (str x)
       n (quot (count x') 2)
       l (take n x')
       r (take n (reverse x'))
       sum (fn [s] (apply + (map #(-> % str Integer/parseInt) s)))]
  (= (sum l) (sum r))))