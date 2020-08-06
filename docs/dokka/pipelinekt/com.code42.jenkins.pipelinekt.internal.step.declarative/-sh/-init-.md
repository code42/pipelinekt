[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Sh](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Sh(script: Str, returnStdout: Bool = false.boolVar(), label: Str? = null)`

Execute a shell command

### Parameters

`script` - The shell script or command to execute.

`returnStdout` - If checked, standard output from the task is returned as the step value as a String, rather than being printed to the build log. (Standard error, if any, will still be printed to the log.) You will often want to call .trim() on the result to strip off a trailing newline.

`label` - Label to be displayed in the pipeline step view and blue ocean details for the step instead of the step type. So the view is more meaningful and domain specific instead of technical.