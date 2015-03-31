(defn build [maze-str]
  (let [maze (atom {})]
    (dorun (map-indexed (fn [i row]
                          (dorun (map-indexed (fn [j cell]
                                                (if (not= cell \space) (swap! maze assoc [i j] cell))) row))) maze-str))
    maze))

(def oink (build [
        "#######"
        "#     #"
        "#  #  #"
        "#M # C#"
        "#######"]))

(println (sort (keys @oink)))
