plugins {
    id("java")
}

group = "dev.drtheo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://libraries.minecraft.net")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.mojang:datafixerupper:6.0.8")
}

tasks.test {
    useJUnitPlatform()
}