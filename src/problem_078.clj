(fn __ [f & args]
 (loop [fun #(apply f args)]
  (let [res (fun)]
   (if (fn? res) (recur res) res))))