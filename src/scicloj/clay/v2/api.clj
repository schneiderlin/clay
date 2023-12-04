(ns scicloj.clay.v2.api
  (:require
   [clojure.string :as string]
   [clojure.test]
   [scicloj.clay.v2.config :as config]
   [scicloj.clay.v2.book :as book]
   [scicloj.clay.v2.server :as server]
   [scicloj.clay.v2.make :as make]
   [scicloj.kindly.v4.api :as kindly]
   [scicloj.kindly.v4.kind :as kind]))

(defn stop! []
  (server/close!)
  [:ok])

(defn welcome! []
  (make/make!
   {:single-value (kind/hiccup
                   [:div
                    [:p [:pre (str (java.util.Date.))]]
                    [:p [:pre [:a {:href "https://scicloj.github.io/clay/"}
                               "Clay"]
                         " is ready, waiting for interaction."]]])}))

(defn start! []
  (server/open!)
  (welcome!)
  [:ok])

(defn make! [spec]
  (make/make! spec))

(defn browse! []
  (server/browse!))
(defn port []
  (server/port))

(defn url []
  (server/url))

(defn config []
  (config/config))

(defn make-book! [options]
  (book/write-book! options))
