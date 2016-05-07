(defproject cloth "0.2.0"
  :description "Clojure(Script) tools for Ethereum"
  :url "https://github.com/pelle/cloth"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.40"]
                 [funcool/cats "1.2.1"]
                 [funcool/promesa "1.1.1"]
                 [funcool/httpurr "0.6.0"]
                 [aleph "0.4.1" :scope "provided"]
                 [funcool/cuerdas "0.7.2"]
                 [org.ethereum/ethereumj-core "1.2.0-RELEASE"]
                 [clj-time "0.11.0"]
                 [com.andrewmcveigh/cljs-time "0.4.0"]
                 [cheshire "5.6.1"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.1"]
            [lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.2"]
            [lein-doo "0.1.6"]
            [lein-ancient "0.6.10"]
            [lein-externs "0.1.5"]]
  :npm {:dependencies [[ethereumjs-tx "1.1.1"]]}

  :cljsbuild
  {:builds {:dev      {:source-paths ["src"]
                       :figwheel     true
                       :compiler     {:optimizations :none
                                      :main          cloth.core
                                      :asset-path "js/out"
                                      :output-to "resources/public/js/cloth.js"
                                      :output-dir "resources/public/js/out"}}
            :test     {:source-paths ["src" "test"]
                       :compiler     {:output-to     "out/testable.js"
                                      :main          cloth.runner
                                      :source-map    true
                                      :optimizations :none}}
            :advanced {:source-paths ["src" "test"]
                       :compiler     {:output-to     "out/testable.js"
                                      :main          "cloth.do-runner"
                                      :optimizations :advanced}}}}
  :doo {:build "test"}
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release" "target"]
  ;; Home of ethereumj
  :repositories [["oss.jfrog.org" "http://dl.bintray.com/ethereum/maven"]])
