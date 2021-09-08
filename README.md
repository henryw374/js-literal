# js-literal

like inbuilt cljs #js literal, but recursive

calling `clj->js` should be equivalent, but will be less efficient, 
going via cljs datastructures. So, efficiency-wise this literal comes between `cljs->js` and using 
`#js` literal all the way down.

## Status

just experimenting

## Usage 

[![Clojars Project](https://img.shields.io/clojars/v/com.widdindustries/js-literal.svg)](https://clojars.org/com.widdindustries/js-literal)

```

in `my/source.cljs`

```clojure
(ns my.source)

(def my-literal #j/s [:a {:b [:c]}])

; compiles to => Array.of("a",Object.fromEntries(Array.of(Array.of("b",Array.of("c")))));
; under advanced compilation, compiles to ["a",Object.fromEntries([["b",["c"]]])]
; if you can improve on the above, IOW object literal syntax etc, please PR

```

Before compiling, require `com.widdindustries.js`

## Development

run `(compile/build)` from the test dir

# Release

create a git tag.

`make install VERSION=your-tag` (this installs in ~/.m2 - check that things look ok)

`make deploy VERSION=your-tag`  - you need to have set up clojars credentials as per https://github.com/applied-science/deps-library

`git push origin new-tag-name`




