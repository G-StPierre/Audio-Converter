import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

    kotlin("jvm") version "1.4.32"
    application
    id("org.openjfx.javafxplugin") version "0.0.9"
}
group = "com.test"
version = "1.0-SNAPSHOT"

val tornadofx_version: String by rootProject



repositories {
    mavenCentral()
}

application {
    mainClassName = "com.example.MainKt"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("no.tornado:tornadofx:$tornadofx_version")
    testImplementation(kotlin("test-junit"))
    implementation (group="ws.schild", name = "jave-all-deps", version = "3.2.0")


}

javafx { modules = listOf("javafx.controls", "javafx.fxml", "javafx.graphics") }

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

}