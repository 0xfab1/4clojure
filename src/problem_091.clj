(fn __ [G]
 (let [G' (set (mapcat (fn [[p q]] (list [p q] [q p])) G))
       elems (set (mapcat (fn [[p q]] (list p q)) G))
       dfs (fn dfs [visited node]
            (if (contains? visited node)
             visited
             (->> G'
                  (filter #(= node (first %)))
                  (map second)
                  (mapcat #(dfs (conj visited node) %))
                  (concat visited)
                  set)))]
  (= elems (dfs #{} (first elems)))))