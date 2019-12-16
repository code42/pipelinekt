[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [RTDownload](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`RTDownload(serverID: Str, buildName: Str? = null, buildNumber: Str? = null, failNoOp: Bool = false.boolVar(), spec: `[`RTSpec`](../../com.code42.jenkins.pipelinekt.core.artifactory/-r-t-spec/index.md)`? = null, specPath: Str? = null)`

Generates the necessary code to download artifacts to Artifactory

### Parameters

`serverID` - the server id to download from

`buildName` - the build name

`buildNumber` - the build number

`failNoOp` - specifies whether to fail the build in case no files are downloaded

`spec` - an object representing File spec(s), which specifies the files that should be downloaded

`specPath` - path to a File that manages FIle spec(s) (rather than adding it to a closure like the spec property)