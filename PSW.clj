;===========================================

(def home-dir "/home/david/Programming_Projects/PhoneticallySimilarWords/")

(def n1 (slurp (str home-dir "nouns2")))
(def n2 (str/split-lines nouns))
(def n3 (into #{} nouns-separated))

(def p1 (slurp (str home-dir "cmudict-0.7b")))
(def p2 (str/split-lines phonetic-dictionary))
(def p3 (map (fn[x] (str/split x #"  ")) phonetic-dictionary-split))

(def f1 (slurp (str home-dir "en_freq_list.txt")))
(def f2 (str/split-lines freq-list))
(def f3 (map (fn[x] (first (str/split x #" ")))
                               freq-list-split))

;===========================================

(require '[clojure.string :as str])

;===========================================

(defn positions
  [pred coll]
  (keep-indexed (fn [idx x]
                  (when (pred x)
                    idx))
                coll))

(def regex-char-esc-smap
  (let [esc-chars "()*&^%$#!"]
    (zipmap esc-chars
            (map #(str "\\" %) esc-chars))))

(defn str-to-pattern
  [string]
  (->> string
       (replace regex-char-esc-smap)
       (reduce str)
       re-pattern))

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

;===========================================

n1
n2
n3

p1
p2
p3

f1
f2
f3

;===========================================

(map (fn[x] (Integer. (re-find #"\d+" (second (str/split x #" ")))))
     f2)

(filter (fn[x] (if (Integer. (re-find #"\d+" (second x))) true false))
 (map (fn[x] (str/split x #" "))
     f2))

(into #{} '(["a" 100]))
;===========================================


