package com.code42.jenkins.pipelinekt.core.secrets

/**
 * The Vault secrets that will be made available to steps executed in the same context.
 * @param path The path in vault where secrets will be retrieved from.
 * @param engineVersion The engine version that Vault is storing secrets in on the path specified.
 * @param secrets The list of VaultSecret objects that will be retrieved and stored in the environment.
 */
data class VaultSecrets(
    val path: String,
    val engineVersion: String,
    val secrets: List<VaultSecret>
) :
    Secrets {
    override fun toGroovy(): String {
        val builder = StringBuilder()
        builder.appendln("  vaultSecrets: [[path: \"$path\", engineVersion: $engineVersion, secretValues: [")
        val listIterator = secrets.listIterator()
        while (listIterator.hasNext()) {
            builder.append(
                "    " + listIterator.next().toGroovy() +
                        (if (listIterator.hasNext()) ",\n" else "\n")
            )
        }
        builder.append("  ]]]")
        return builder.toString()
    }
}
