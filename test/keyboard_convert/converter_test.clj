(ns keyboard-convert.converter-test
  (:require [keyboard-convert.converter :as k.converter]
            [clojure.test :refer [deftest is testing]]))

(testing k.converter/get-index-cifra
  (testing "given a keyword of a cifra,
  then should return the index of the cifra in the acorde list")
  (is (= (k.converter/get-index-cifra "c") 1))
  (is (= (k.converter/get-index-cifra "f") 4)))

(testing k.converter/get-letter-by-index
  (testing "given a index, should return the letter of the acorde from the default acorde list (third-oitava)"
    (is (= (k.converter/get-letter-by-index 1) "y")))
  (testing "given a index and the reference oitava,
            should return the letter of the acorde from the reference oitava list"
    (is (= (k.converter/get-letter-by-index 1 k.converter/first-oitava) "2"))
    (is (= (k.converter/get-letter-by-index 1 k.converter/second-oitava) "9"))
    (is (= (k.converter/get-letter-by-index 1 k.converter/fourth-oitava) "d"))
    (is (= (k.converter/get-letter-by-index 1 k.converter/fifth-oitava) "z"))))

(testing k.converter/get-cifra-sharpeada
  (testing "given a cifra,
  then should return the cifra in the acorde format")
  (is (= (k.converter/get-cifra-sharpeada "c") "C"))
  (is (= (k.converter/get-cifra-sharpeada "f") "F")))

(testing k.converter/build-cifra
  (testing "given a cifra,
  then should return the cifra in the acorde format")
  (is (= (k.converter/build-cifra "f" true) "I"))
  (is (= (k.converter/build-cifra "b" false) "a")))

(testing k.converter/get-letter
  (testing "given a cifra,
  then should return the cifra in the acorde format")
  (is (= (k.converter/get-letter "d") "y"))
  (is (= (k.converter/get-letter "e" true) "U"))
  (is (= (k.converter/get-letter "b" false) "a")))
