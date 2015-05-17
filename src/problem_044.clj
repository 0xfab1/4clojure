(fn [n xs]
 (let [z (mod n (count xs))]
  (concat (drop z xs) (take z xs))))