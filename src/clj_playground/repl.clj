(ns clj-playground.repl
  (:use [clojure.tools.nrepl.server :only (start-server stop-server)]))

(defn repl-server []
  (ref {:server nil}))

(defn move-repl-server! [rs & start-server-args]
  (dosync
    (alter rs (fn [s]
                (let [existing-server (:server s)]
                  (do 
                    (if-not (= existing-server nil) (stop-server existing-server))
                    (printf "Starting REPL server with config: %s\n" start-server-args)
                    (assoc-in s [:server] (apply start-server start-server-args))))))))

(defn stop-repl-server! [rs]
  (dosync
    (alter rs (fn [s]
               (let [existing-server (:server s)]
                 (do 
                   (if (= existing-server nil)
                    (printf "No REPL server running")
                    (do
                      (printf "Stopping REPL server on port: %s\n" (:port existing-server))
                      (stop-server existing-server)))
                   (assoc-in s [:server] nil)))))))

(defn start-repl-server! [& args]
  (apply move-repl-server! args))
