[![](https://jitpack.io/v/code42/pipelinekt.svg)](https://jitpack.io/#code42/pipelinekt)

# Dynamic Declarative Jenkinsfile in Kotlin

pipelinekt is a kotlin library that improves the Jenkinsfile development experience, especially for large projects.

## Why:

1. Remove several limitations imposed by the declarative syntax, for example:
   1. No longer need to statically define stages
      1. create stages in loops or by iterating over collections
   2. move any block of code into a separate function
   3. standard code sharing with actual classes
      1. no need to call `load` to dynamically interpret groovy scripts)
2. IDE integration
   1. native kotlin + gradle - no custom groovy compiler
   2. Code completion
   3. Auto complete
3. Configure sane defaults
   1. Shared steps before and after stages
   2. default pipeline configurations
   3. default `post` stage actions

## Subprojects

* core - The base framework for the dsl
* internal - internal implementation for most dsl methods; not exposed to end users
* dsl - end user interface
* examples - code examples

# Documentation

* [Examples](https://github.com/code42/pipelinekt/tree/master/examples/src/main/kotlin)
* [The Docs](docs/index.md)

# getting started 
Please see the [quickstart guide](docs/quickstart.md)

# Contributing
1. Fork on GitHub
2. Update minor or major as needed in [version.txt] per [Semantic Versioning 2.0.0](https://semver.org)
3. Ensure all gradle tasks are successful

       ./gradlew build detek examples:build
4. Apply spotless before each commit

       ./gradlew spotlessApply
5. Create PR
