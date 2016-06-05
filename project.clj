(defproject clj-playground "0.1.0-SNAPSHOT"
  :description "A collection of random Clojure code I like to play with from time to time"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot clj-playground.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
