(fn __ [[op & exprs]]
  (fn [defs]
    (let [f #(cond (symbol? %) (defs %)
                   (number? %) %
                   :else ((__ %) defs))
          exprs' (map f exprs)
          op' (condp = op '+ + '- - '* * '/ /)]
      (apply op' exprs'))))
