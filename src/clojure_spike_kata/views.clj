(ns clojure_spike_kata.views
  (:require [noir.response :as response]
            [monger.collection :as monger])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.page-helpers :only [html5 link-to]]
        [hiccup.form-helpers])
  (:import [org.bson.types ObjectId]))


(defpage "/" []
  (html5
   [:head
    [:title "Clojure spike"]
    ]
   [:body
    [:h1 "Clojure spike"]
    [:p (link-to "/create" "Create person")]
     ]
  )
)

(defpage "/create" []
  (html5
   [:head
    [:title "Clojure spike"]
    ]
   [:body
    [:h1 "Create person"]
    (form-to [:post "/newPerson"]
      (text-field "full_name")
      (submit-button "Create person"))
     ]
  )
)


(defpage [:post "/newPerson"] {:keys [full-name]}
  (monger/insert "person" { :fullName full-name })
  (response/redirect "/"))


