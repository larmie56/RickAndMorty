interface BuildType {
    companion object {
        val Debug: BuildType = DebugBuildType()
        val Release: BuildType = ReleaseBuildType()
    }

    val name: String
    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val applicationIdSuffix: String
    val versionNameSuffix: String
}

private class DebugBuildType : BuildType {
    override val name: String = "debug"
    override val isMinifyEnabled: Boolean = false
    override val isTestCoverageEnabled: Boolean = true
    override val applicationIdSuffix: String = ".debug"
    override val versionNameSuffix: String = "-DEBUG"
}

private class ReleaseBuildType : BuildType {
    override val name: String = "release"
    override val isMinifyEnabled: Boolean = true
    override val isTestCoverageEnabled: Boolean = true
    override val applicationIdSuffix: String = ".release"
    override val versionNameSuffix: String = "-RELEASE"

}

