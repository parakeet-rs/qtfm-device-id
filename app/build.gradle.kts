plugins {
    id("com.android.application")
}

android {
    namespace = "moe.jixun.qtfm_device_id"
    compileSdk = 34

    defaultConfig {
        applicationId = "moe.jixun.qtfm_device_id"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.1"
        setProperty("archivesBaseName", "${applicationId}-v$versionName")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    testImplementation("androidx.appcompat:appcompat:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}