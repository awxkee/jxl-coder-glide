import com.vanniktech.maven.publish.AndroidMultiVariantLibrary
import com.vanniktech.maven.publish.DeploymentValidation
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.vanniktech.maven.publish") version "0.36.0"
    id("com.google.devtools.ksp")
}

mavenPublishing {
    if (System.getenv("PUBLISH_STATE") == "Release") {
        publishToMavenCentral(
            automaticRelease = true,
            validateDeployment = DeploymentValidation.PUBLISHED
        )
        signAllPublications()
    }

    configure(
        AndroidMultiVariantLibrary(
            JavadocJar.Javadoc(),
            SourcesJar.Sources(),
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
    compileSdk = 36

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
    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.18.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.13.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    implementation("com.github.bumptech.glide:glide:5.0.7")
    ksp("com.github.bumptech.glide:ksp:5.0.7")

    api("io.github.awxkee:jxl-coder:2.6.1")
}
