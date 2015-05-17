(fn [x & funs]
 (let [fun (fn fun [x fs]
            (lazy-seq
             (let [x2 ((first fs) x)]
              (cons x2 (fun x2 (rest fs))))))]
  (cons x (fun x (cycle funs)))))