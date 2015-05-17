(fn [& funs]
 (fn [& args]
  (let [f1 (last funs)
        fx (reverse (butlast funs))
        init (apply f1 args)]
   (reduce (fn [ret f] (f ret)) init fx))))