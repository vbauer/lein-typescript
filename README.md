lein-typescript
=================

[![Build Status](https://travis-ci.org/vbauer/lein-typescript.svg?branch=master)](https://travis-ci.org/vbauer/lein-typescript)
[![Clojars Project](https://img.shields.io/clojars/v/lein-typescript.svg)](https://clojars.org/lein-typescript)

> **TypeScript** is a free and open source programming language developed and maintained by Microsoft. It is a strict superset of JavaScript, and adds optional static typing and class-based object-oriented programming to the language. - [Wikipedia](https://en.wikipedia.org/wiki/TypeScript)

[lein-typescript](https://github.com/vbauer/lein-typescript) is a Leiningen plugin that allows to use TypeScript compiler.


Pre-requirements
================

Install [NodeJS](http://nodejs.org/) and [NPM](https://github.com/npm/npm) (package manager for Node) to install TypeScript:

* On Ubuntu: `sudo apt-get install nodejs`
* On Mac OS X: `brew install node`


Installation
============

Install [TypeScript](https://www.npmjs.org/package/typescript) to use lein-typescript plugin. It could be done in few ways:

* Use NPM to install TypeScript globally: `npm install typescript -g`
* You can also install TypeScript in the current directory: `npm install typescript`
* Use [lein-npm](https://github.com/bodil/lein-npm) plugin: `lein npm install`
* Use just Leiningen: `lein deps`

To enable lein-typescript for your project, put the following in the :plugins vector of your project.clj file:

```clojure
; Use latest version instead of "X.X.X"
:plugins [[lein-typescript "X.X.X"]]
```


Configuration
=============

To configure lein-typescript, put the :typescript parameter in the file project.clj. It could be a single configuration (simple map) or a collection of configurations (for multiple configuration).

```clojure
:typescript {
  :sources ["*.ts" "resources/*.ts"]
  :excludes ["bad.ts"]
  :out "app.js"
  :declaration true
  :remove-comments true
  :target :es5
}
```


Configuration parameters
------------------------
<dl>

  <dt>:sources</dt>
  <dd>List of input TypeScript sources. It is possible to use a single source or a vector of sources. To configure this parameter, you could also use a <a href="http://en.wikipedia.org/wiki/Glob_(programming)">Glob Patterns</a>.</dd>

  <dt>:excludes</dt>
  <dd>List of glob patterns to prevent processing of some files. It is also possible to use both variants: single pattern and collection of patterns.</dd>

  <dt>:out-dir</dt>
  <dd>Redirect output structure to the specified directory (it is undefined by default). ":out" parameter will be used in priority.</dd>

  <dt>:out</dt>
  <dd>Concatenate and emit output to single file which you can specify using this parameter (it is undefined by default).</dd>

  <dt>:remove-comments</dt>
  <dd>Do not emit comments to output (default value is "false").</dd>

  <dt>:declaration</dt>
  <dd>Generates corresponding ".d.ts" file (default value is "false").</dd>

  <dt>:source-map</dt>
  <dd>Generates corresponding '.map' file (default is "false").</dd>

  <dt>:module</dt>
  <dd>Specify module code generation: :commonjs or :amd (it is undefined by default).</dd>

  <dt>:target</dt>
  <dd>Specify ECMAScript target version: :es3 (default), :es5, or :es6 (experimental).</dd>

  <dt>:watch</dt>
  <dd>Watch input files. It could be helpful to use this parameter with <a href="https://github.com/Raynes/lein-pdo">lein-pdo</a> and/or with separate profile (default is "false").</dd>

</dl>


Hooks
-----

To enable this plugin in the compile stage, use the following hook:
```clojure
:hooks [lein-typescript.plugin]
```


Usage
=====

To compile TypeScript files using configuration from project.clj, you should use: `lein typescript`.
It is also possible to use short alias for `typescript` task: `lein ts`.

To show help: `lein help typescript`


Example project
===============

Just clone the current repository and try to play with [example project](https://github.com/vbauer/lein-typescript/tree/master/example) for better understanding how to use lein-typescript.


Thanks to
=========

[Microsoft Corporation](http://www.microsoft.com), [Anders Hejlsberg](https://github.com/ahejlsberg) and [TypeScript community](https://github.com/Microsoft/TypeScript) for the great programming language.



Might also like
===============

* [lein-coffeescript](https://github.com/vbauer/lein-coffeescript) - a Leiningen plugin for running CoffeeScript compiler.
* [lein-jslint](https://github.com/vbauer/lein-jslint) - a Leiningen plugin for running javascript code through JSLint.
* [lein-jshint](https://github.com/vbauer/lein-jshint) - a Leiningen plugin for running javascript code through JSHint.
* [lein-plantuml](https://github.com/vbauer/lein-plantuml) - a Leiningen plugin for generating UML diagrams using PlantUML.
* [lein-asciidoctor](https://github.com/asciidoctor/asciidoctor-lein-plugin) - A Leiningen plugin for generating documentation using Asciidoctor.
* [jabberjay](https://github.com/vbauer/jabberjay) - a simple framework for creating Jabber bots.
* [coderwall-clj](https://github.com/vbauer/coderwall-clj) - a tiny CoderWall client for Clojure.


License
=======

Copyright © 2015 Vladislav Bauer

Distributed under the Eclipse Public License, the same as Clojure.
