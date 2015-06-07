(ns problem-195)

(defn __ [N]
  (letfn [(aux [l r]
               (if (and (= l N) (= (inc r) N))              ; last character is always right paren
                 [[\)]]
                 (let [lx (if (< l N) (map (partial cons \() (aux (inc l) r)) [])
                       rx (if (< r l) (map (partial cons \)) (aux l (inc r))) [])]
                   (concat lx rx))))]
    (if (zero? N) #{""}                                     ; special case
                  (set (map #(apply str %) (aux 0 0))))))
