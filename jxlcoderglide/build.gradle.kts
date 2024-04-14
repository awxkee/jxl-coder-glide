import com.vanniktech.maven.publish.AndroidMultiVariantLibrary

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
    id("signing")
    id("com.vanniktech.maven.publish") version "0.28.0"
    id("kotlin-kapt")
}

task("androidSourcesJar", Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

mavenPublishing {
    configure(
        AndroidMultiVariantLibrary(
            sourcesJar = true,
            publishJavadocJar = true,
        )
    )

    coordinates("io.github.awxkee", "jxl-coder-glide", System.getenv("VERSION_NAME") ?: "0.0.10")

    pom {
        name.set("Jxl Coder Glide")
        description.set("JPEG XL decoder for android Glide")
        inceptionYear.set("2023")
        url.set("https://github.com/awxkee/jxl-coder-glide")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
            license {
                name.set("The 3-Clause BSD License")
                url.set("https://opensource.org/license/bsd-3-clause")
                description.set("https://opensource.org/license/bsd-3-clause")
            }
        }
        developers {
            developer {
                id.set("awxkee")
                name.set("Radzivon Bartoshyk")
                url.set("https://github.com/awxkee")
                email.set("radzivon.bartoshyk@proton.me")
            }
        }
        scm {
            url.set("https://github.com/awxkee/jxl-coder-glide")
            connection.set("scm:git:git@github.com:awxkee/jxl-coder-glide.git")
            developerConnection.set("scm:git:ssh://git@github.com/awxkee/jxl-coder-glide.git")
        }
    }
}

android {
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }

    namespace = "com.awxkee.jxlcoder.glide"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")
    api("com.github.awxkee:jxl-coder:2.1.10")
}