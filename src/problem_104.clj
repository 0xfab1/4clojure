(fn dec->roman [x]
  (let [decs [1000 900  500 400  100 90   50  40   10  9    5   4    1]
        roms ["M"  "CM" "D" "DC" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]
        dict (zipmap decs roms)
        freqs (second (reduce (fn [[rm acc] v] [(mod rm v) (assoc acc v (quot rm v))]) [x {}] decs))]
    (apply str (mapcat #(repeat (freqs %) (dict %)) decs))))
