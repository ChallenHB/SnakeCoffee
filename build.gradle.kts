import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.3.72"
}

repositories {
    jcenter()
    mavenCentral()
}

val graalVersion="20.0.0"

dependencies {

    implementation("org.graalvm.sdk:graal-sdk:$graalVersion")
    implementation("org.graalvm.js:js:$graalVersion")
    implementation("org.graalvm.js:js-scriptengine:$graalVersion")
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("junit:junit:4.12")
}

application {
    // Define the main class for the application.
    mainClassName = "hb.challen.AppKt"
}
