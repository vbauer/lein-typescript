lein-typescript
=================

[![Build Status](https://travis-ci.org/vbauer/lein-typescript.svg?branch=master)](https://travis-ci.org/vbauer/lein-typescript)
[![Dependencies Status](http://jarkeeper.com/vbauer/lein-typescript/status.png)](http://jarkeeper.com/vbauer/lein-typescript)


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
  :preserve-const-enums true
}
```


Configuration parameters
------------------------
<dl>

  <dt>:sources</dt>
  <dd>List of input CoffeeScript sources. It is possible to use a single source or a vector of sources. To configure this parameter, you could also use a <a href="http://en.wikipedia.org/wiki/Glob_(programming)">Glob Patterns</a>.</dd>

  <dt>:excludes</dt>
  <dd>List of glob patterns to prevent processing of some files. It is also possible to use both variants: single pattern and collection of patterns.</dd>

  <dt>:out-dir</dt>
  <dd>Redirect output structure to the specified directory (it is undefined by default). ":out" parameter will be used in priority.</dd>

  <dt>:out</dt>
  <dd>Concatenate and emit output to single file which you can specify using this parameter (it is undefined by default).</dd>

  <dt>:remove-comments</dt>
  <dd>Do not emit comments to output (default value is "false").</dd>

  <dt>:preserve-const-enums</dt>
  <dd>Do not erase const enum declarations in generated code (default value is "false").</dd>

  <dt>:suppress-implicit-any-index-errors</dt>
  <dd>Suppress noImplicitAny errors for indexing objects lacking index signatures (default value is "false").</dd>

  <dt>:declaration</dt>
  <dd>Generates corresponding ".d.ts" file (default value is "false").</dd>

  <dt>:module</dt>
  <dd>Specify module code generation: :commonjs or :amd (it is undefined by default).</dd>

</dl>


Hooks
-----

To enable this plugin in the compile stage, use the following hook:
```clojure
:hooks [lein-typescript.plugin]
```


Usage
=====

To compile TypeScript files using configuration from project.clj, you should use: `lein typescript`

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


License
=======

Copyright © 2015 Vladislav Bauer

Distributed under the Eclipse Public License, the same as Clojure.
