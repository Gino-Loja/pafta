pluginManagement {
    repositories {
        google()
        mavenCentral()
        jcenter()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {

        maven(  "https://jitpack.io")
        google()
        mavenCentral()
        jcenter()
    }
}

rootProject.name = "pafta"
include(":app")
 