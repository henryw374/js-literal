# js-literal

like inbuilt cljs #js literal, but recursive

## Status

just experimenting

## Usage 

depend on:  

```clojure

com.widdindustries/js-literal {:git/url "https://github.com/henryw374/js-literal.git"
:sha "abc"}

```

in `my/source.cljs`

```clojure
(ns my.source)

(def my-literal #j/s [:a {:b [:c]}])

; compiles to => Array.of("a",Object.fromEntries(Array.of(Array.of("b",Array.of("c")))));

```

Before compiling, require `com.widdindustries.js`

## Development

run `(compile/build)` from the test dir



