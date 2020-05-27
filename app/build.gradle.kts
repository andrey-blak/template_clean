plugins {
	id("com.android.application")
	id("kotlin-android")
	id("kotlin-kapt")
}

android {
	compileSdkVersion(App.compileSdkVersion)
	buildToolsVersion = App.buildToolsVersion

	defaultConfig {
		minSdkVersion(App.minSdkVersion)
		targetSdkVersion(App.targetSdkVersion)

		applicationId = "com.example.clean"
		versionCode = 1
		versionName = "1.0"
	}

	buildTypes {
		maybeCreate("release").apply {
			isMinifyEnabled = true
			isShrinkResources = true

			proguardFiles(
				getDefaultProguardFile("proguard-android.txt"),
				"proguard-rules.pro"
			)
		}

		maybeCreate("debug").apply {
			isMinifyEnabled = true
			isShrinkResources = true

			proguardFiles(
				getDefaultProguardFile("proguard-android.txt"),
				"proguard-rules.pro"
			)
		}
	}
}

dependencies {
	implementation(project(":domain"))
	implementation(project(":data"))
	implementation(project(":presentation"))

	implementation(kotlin("stdlib", kotlinVersion))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
}
