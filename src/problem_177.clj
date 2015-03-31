(fn [text]
  (let [open? (set "({[")
        brackets (set "(){}[]")
        pair-of (apply hash-map "(){}[]")]
    (let [[ok stack]
          (reduce (fn [[ok stack] tok]
                    (cond
                     (not ok) [ok stack]
                     (not (brackets tok)) [ok stack]
                     :else (if (open? tok)
                             [ok (conj stack tok)]
                             (if (= (pair-of (peek stack)) tok)
                               [ok (pop stack)]
                               [false stack])))) [true []] text)]
      (and ok (empty? stack)))))
