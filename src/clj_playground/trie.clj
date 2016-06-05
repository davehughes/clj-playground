(ns clj-playground.trie)

(defn mktrie [] {:subtrie {} :terminates-word false})

(defn add-word [trie word]
  (cond
    (= (count word) 0)
      (assoc-in trie [:terminates-word] true)
    (contains? (:subtrie trie) (first word))
      (assoc-in trie [:subtrie (first word)] (add-word (get (:subtrie trie) (first word)) (rest word)))
    :default
      (assoc-in trie [:subtrie (first word)] (add-word (mktrie) (rest word)))))

(defn contains-word? [trie word]
  (cond
    (= (count word) 0)
      (:terminates-word trie)
    (contains? (:subtrie trie) (first word))
      (contains-word? (get (:subtrie trie) (first word)) (rest word))
    :default
      false))
