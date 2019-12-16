# Dynamic Declarative Jenkinsfile in Kotlin

pipelinekt is a kotlin library that generates Jenkinsfiles.

## Why:

1. Generate Jenkins Declarative Pipelines dynamically, a feature which is not supported by Jenkins
2. Use Kotlin to build your pipeline models
    1. IDE integration
    2. Tab Completion
    3. Compile time validation
3. Share code with sane defaults
    1. for example, cleanWs on each stage that defines an agent by default.
    2. dynamic stage definitions means any part of the pipeline can be pulled out into a method, and that means more 
    shared configuration and less code duplication

## Subprojects

* core - The base framework for the dsl
* internal - internal implementation for most dsl methods; not exposed to end users
* dsl - end user interface
* examples - code examples

# Documentation

* [Examples](examples/src/main/kotlin)
* [The Docs](docs/index.md)

# getting started 
Please see the [quickstart guide](docs/quickstart.md)
    
