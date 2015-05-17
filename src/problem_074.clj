(fn [text]
 (let [perfect (fn [x] (== (* (Math/sqrt x) (Math/sqrt x)) x))
       nums (map #(Integer/parseInt %) (clojure.string/split text #","))]
  (apply str (interpose "," (filter perfect nums)))))