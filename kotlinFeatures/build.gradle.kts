plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}



dependencies {
    implementation(libs.androidx.junit)
    testImplementation(libs.junit)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}

