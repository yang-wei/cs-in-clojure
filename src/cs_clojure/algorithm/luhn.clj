(ns cs-clojure.algorithm.luhn)

(defn char->int [c]
  (Character/digit c 10))

(defn double-the-second-xs [xs]
  (if-let [y (second xs)]
    (list (first xs) (* y 2))
    (list (first xs))))

(defn minus-9-if-larger-than-9 [n]
  (if (> n 9)
    (- n 9)
    n))

(defn luhn-double [xs]
  (->> xs
      reverse             ;; need to reverse because it might be odd number
      (partition-all 2)
      (mapcat double-the-second-xs)
      (map minus-9-if-larger-than-9)
      reverse))

(defn valid? [n]
  (if (= (mod n 10) 0)
    true
    false))

(defn validate [identifier]
  (->> identifier
      (map char->int)
       luhn-double
       (apply +)
       valid?))
