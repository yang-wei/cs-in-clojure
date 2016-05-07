(ns cs-clojure.algorithm.luhn-test
  (:require [clojure.test :refer :all]
            [cs-clojure.algorithm.luhn :refer :all]))

(deftest char->int-test
  (testing "char->int"
    (is (= (char->int \1) 1))
    (is (= (char->int \2) 2))))

(deftest luhn-double-test 
  (testing "double every other number in a seq"
    (is (= (luhn-double [1 2 3 4]) [2 2 6 4]))
    (is (= (luhn-double [2 2 2 2 2]) [2 4 2 4 2]))
    (is (= (luhn-double [7 7 7 7 7 7]) [5 7 5 7 5 7]))))

(deftest validate-test
  (testing "is number is validate"
    (is (= (validate "79927398711") false))
    (is (= (validate "79927398712") false))
    (is (= (validate "79927398713") true))
    (is (= (validate "79927398714") false))
    (is (= (validate "79927398715") false)))
  (testing "return false if not all are integer"
    (is (= (validate "hello") false))))
