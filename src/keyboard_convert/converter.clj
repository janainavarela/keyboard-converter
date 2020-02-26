(ns keyboard-convert.converter
  (:require [clojure.string :as str]))

(def first-oitava ["1" "2" "3" "4" "5" "6" "7"])
(def second-oitava ["8" "9" "0" "q" "w" "e" "r"])
(def third-oitava ["t" "y" "u" "i" "o" "p" "a"])
(def fourth-oitava ["s" "d" "f" "g" "h" "j" "k"])
(def fifth-oitava ["l" "z" "x" "c" "v" "b" "n" "m"])

(def cifra-list {:c 1
                 :d 2
                 :e 3
                 :f 4
                 :g 5
                 :a 6
                 :b 7})

(defn get-index-cifra
  [cifra]
  (get cifra-list (keyword cifra)))

(defn get-letter-by-index
  ([index]
   (get third-oitava index))
  ([index oitava]
   (get oitava index)))

(defn get-cifra-sharpeada
  [cifra]
  (str/upper-case cifra))

(defn build-cifra
  [cifra is-sharp?]
  (let [index (dec (get-index-cifra cifra))
        str-cifra (get-letter-by-index index)]
    (if is-sharp?
      (get-cifra-sharpeada str-cifra)
      str-cifra)))

(defn get-letter
  ([cifra]
   (build-cifra cifra false))
  ([cifra is-sharp?]
   (build-cifra cifra is-sharp?)))
