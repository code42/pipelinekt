[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [RTUpload](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`RTUpload(serverID: Str, buildName: Str? = null, buildNumber: Str? = null, failNoOp: Bool = false.boolVar(), spec: `[`RTSpec`](../../com.code42.jenkins.pipelinekt.core.artifactory/-r-t-spec/index.md)`? = null, specPath: Str? = null)`

Generates the necessary code to upload artifacts to Artifactory

### Parameters

`serverID` - the server id to upload to

`buildName` - the build name

`buildNumber` - the build number

`failNoOp` - specifies whether to fail the build in case no files are uploaded or downloaded

`spec` - an object representing File spec(s), which specifies the files that should be uploaded

`specPath` - path to a File that manages FIle spec(s) (rather than adding it to a closure like the spec property)