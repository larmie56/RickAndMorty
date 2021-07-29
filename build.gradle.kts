allprojects {
    repositories {
        google()
        mavenCentral()
        //jcenter() // Warning: this repository is going to shut down soon
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}