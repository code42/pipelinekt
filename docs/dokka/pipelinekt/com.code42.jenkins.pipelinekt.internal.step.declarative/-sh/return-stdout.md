[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Sh](index.md) / [returnStdout](./return-stdout.md)

# returnStdout

`val returnStdout: Bool`

If checked, standard output from the task is returned as the step value as a String, rather than being printed to the build log. (Standard error, if any, will still be printed to the log.) You will often want to call .trim() on the result to strip off a trailing newline.

