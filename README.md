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
; under advanced compilation, compiles to ["a",Object.fromEntries([["b",["c"]]])]

```

Before compiling, require `com.widdindustries.js`

## Development

run `(compile/build)` from the test dir

# Release

create a git tag.

`make install VERSION=your-tag` (this installs in ~/.m2 - check that things look ok)

`make deploy VERSION=your-tag`  - you need to have set up clojars credentials as per https://github.com/applied-science/deps-library

`git push origin new-tag-name`




