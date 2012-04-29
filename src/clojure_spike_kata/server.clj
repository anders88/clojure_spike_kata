(ns clojure_spike_kata.server
  (:use [clojure_spike_kata.helpers])
  (:require [noir.server :as server]
            [clojure_spike_kata.views]))

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "1337"))
        mongo-uri (get (System/getenv) "MONGOLAB_URI" "mongodb://127.0.0.1/clojure_spike_kata")]
    (monger-connect! mongo-uri)
    (server/start port {:mode mode
                        :ns 'clojure_spike_kata})))
