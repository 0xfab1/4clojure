(defn __ [input-set]
  (let [rels (->> input-set
                  (apply list)
                  flatten
                  (apply hash-map))
        nodes (->> input-set
                   (apply list)
                   flatten
                   set)
        aux (fn aux [x]
              (let [x' (rels x)]
                (if (nil? x') []
                              (let [aux-res (aux x')
                                    xtra-res (map (fn [[_ y]] [x y]) aux-res)]
                                (cons [x x'] (concat aux-res xtra-res))))))]
    (set (mapcat aux nodes))))

(let [divides #{[8 4] [9 3] [4 2] [27 9]}]
  (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))

(let [more-legs
      #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
  (= (__ more-legs)
     #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
       ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))

(let [progeny
      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
  (= (__ progeny)
     #{["father" "son"] ["father" "grandson"]
       ["uncle" "cousin"] ["son" "grandson"]}))
