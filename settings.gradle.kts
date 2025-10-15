pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

include("core", "internal", "dsl")
// Temporarily excluding examples module until we can fix all the issues
// include("examples")
