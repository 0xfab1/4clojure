(defn __ [trump]
  (let [score (fn [first-suit]
                (fn [card] (+ (:rank card)
                              (cond (= (:suit card) trump) 20
                                    (= (:suit card) first-suit) 0
                                    :else -20))))]
    (fn [cards]
      (let [first-suit (->> cards first :suit)]
        (->> cards
             (map (score first-suit))
             (interleave cards)
             (partition 2)
             (sort-by second >)
             first
             first)))))

(let [notrump (__ nil)]
  (assert (and (= {:suit :club :rank 9} (notrump [{:suit :club :rank 4}
                                                  {:suit :club :rank 9}]))
               (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                                   {:suit :club :rank 10}])))))

(assert (= {:suit :club :rank 10} ((__ :club) [{:suit :spade :rank 2}
                                               {:suit :club :rank 10}])))

(assert (= {:suit :heart :rank 8}
           ((__ :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                         {:suit :diamond :rank 10} {:suit :heart :rank 4}])))