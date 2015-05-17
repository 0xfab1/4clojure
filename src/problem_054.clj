(fn party [n xs]
 (if (< (count xs) n)
  []
  (cons (take n xs) (party n (drop n xs)))))