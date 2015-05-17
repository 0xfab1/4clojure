(fn [& fns]
 (fn [& xs] (map #(apply % xs) fns)))