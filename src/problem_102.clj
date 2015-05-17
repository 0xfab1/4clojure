(fn [text]
 (let [words (filter #(not= % "-") (map #(apply str %) (partition-by #(= % \-) text)))]
  (str (first words) (apply str (map clojure.string/capitalize (rest words))))))