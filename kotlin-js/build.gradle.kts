plugins {
    kotlin("js") version "1.7.10"
}

group = "es.joseluisgs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    //implementation("org.jetbrains.kotlin:kotlin-stdlib-js:1.7.10")
    // Cojo librerias multiplataforma
    implementation("com.benasher44:uuid:0.4.1")

    kotlin {
        js(IR) {
            binaries.executable()
            nodejs {

            }
        }
    }
}