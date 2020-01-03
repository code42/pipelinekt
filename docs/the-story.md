# The Story
This is a copy of a blog post from [dev.to](https://dev.to/dgoetsch/pipelinekt-jenkinsfiles-and-kotlin-4m47)

When we introduced Jenkinsfiles into our ecosystem, we got some very nice features out of the box.  Pipelines now could execute arbitrary code, and the builds would be versioned along with the source they were building.

Our initial implementation of Jenkinsfiles had its problems.  The Jenkinsfile would share code by calling the `load` step on the same scripts repeatedly, which had several problems.
1. loading these scripts took processor time to interpret them
2. loading these scripts takes network time to move the script from the worker node to the master (where is is interpreted)
3. Pipelines could not recover after system restart and replay did not work due to the usage of `load`
4. These scripts were generally unpleasant to develop, there was poor IDE integration, and it was a subset of groovy functionality. Code completion and autocorrect did not work well.

It wasn't good, but it was better than it used to be.

The architects approached me about improving the developer experience for these pipelines.  They mentioned using Kotlin to generate pipelines, as Jenkins developers have stated they [will not support kotlin for pipelines](https://issues.jenkins-ci.org/browse/JENKINS-41676).  I was doubtful of this approach, but also intrigued.

Meanwhile, I wanted to distribute common code in a way that eliminated a developers need to worry about common details such as scm notifications, influx statistics, workspace cleanup, and scm optimization. I had become frustrated trying to communicate these issues, and Jenkinsfiles didn't give me good tools to do that, but if I was generating the Jenkinsfile I could build such code into the generation engine.

After several days of thinking I was still doubtful of the approach to generate Jenkinsfiles. However, I couldn't resist the temptation to experiment.  The opportunity to develop in kotlin was tantalizing - code completion, discoverability, and strong compile time guarantees all drew me in. So I set out to prove I could do it.

I was simultaneously elated and afraid of the idea that I was creating a Rube Goldberg machine.

At first, I experimented with compiling kotlin scripts on the fly with the kotlin interpreter.  I wrote a simple bit of kotlin code to output a jenkinsfile in a library jar.  I ended up getting this to work by loading the correct jars into jenkins and interpretting  a `.kts` script on the fly in jenkins, but I ran into several problems.
1. Local develepment was not supported very well
2. Using it required an indepth understanding of how jenkins manages libraries
3. The kotlin script engine was broken in the current version of kotlin

I had generated a pipeline from kotlin, but I was off the mark, and I wasn't convinced this approach would work out.  Could this actually make developing Jenkinsfile easier, or was I chasing my tail?  Naturally I didn't care about the answer to this question because I was having fun.

For the next week I kept working, I converted the development and generation process to use gradle, which meant that local development was now supported, the artifact resolution was standardized, and I didn't have to worry about the script engine.

Now that I had a good development environment, and could dynamically generate a jenkinsfile from kotlin source code I began to work on my library.  And this was indeed fun.  The tooling got out of my way, as is expected for kotlin development and I could focus on my code.  I was dealing with kotlin, and the IDE was able to tell me immediately if my code was valid.  I had some bumps a long the way, and occasionally I was able to generate bad Jenkinsfiles, but broadly my pipelines began to shore up.  Common code fell into place as I built up my pipelines, and patterns became apparent.  Isolating common code became trivial, since I was dealing with kotlin types and the IDE could refactor for me and tell me when I made a mistake.

After the first week I felt reassured that I was on the right path.  My kotlin code became more concise every day as I moved functionality into the shared library, and I was able to properly share code both across projects in the common library, and within pipelines that had many repetitive steps (such as our monolith).

Now, I can express my gradle pipeline build in just a few lines of kotlin without having to worry about specifically configuring all of the esoteric Jenkins features:

```kotlin
val pipelineDsl = PipelineDsl()
    
val myPipeline = pipelineDsl.pipeline {    
    agent {
        label("linux")
    }
    stages {
        stage("Build") {
            steps {
                echo("Hello, World!")
            }
        }
    }
}

generatePipeline(myPipeline, "path/to/Jenkinsfile.generated")
```

I am able to express my pipeline the same way as I could in groovy, but with improvements provided by kotlin, and configured defaults provided on the `PipelineDsl`object.

Of course, all of these default settings could be overriden, as the entire pipeline object is nothing but simple data classes.  This also makes my pipelines easy to unit test as assertions become simple kotlin object equality assertions.  The best part is I can use any tool that integrates with gradle to develop my pipelines.  Interested in trying out kotlin pipelines? Check out the repo for [documentation and examples](https://github.com/code42/pipelinekt).
