(fn happy?
 ([x] (happy? #{} x))
 ([sadset x]
  (let [pow2 (fn [z] (let [z' (Integer/parseInt (str z))] (* z' z')))
        x' (apply + (map pow2 (str x)))]
   (cond
    (= x' 1) true
    (sadset x') false
    :else (happy? (conj sadset x') x')))))