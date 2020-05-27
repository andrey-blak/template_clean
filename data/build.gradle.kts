plugins {
	id("com.android.library")
	id("kotlin-android")
	id("kotlin-kapt")
}

android {
	compileSdkVersion(App.compileSdkVersion)

	defaultConfig {
		minSdkVersion(App.minSdkVersion)
		targetSdkVersion(App.targetSdkVersion)
	}

	buildTypes {
		maybeCreate("release").apply {
			isMinifyEnabled = true

			consumerProguardFiles(
				"proguard-rules.pro"
			)
		}

		maybeCreate("debug").apply {
			isMinifyEnabled = true

			consumerProguardFiles(
				"proguard-rules.pro"
			)
		}
	}
}

dependencies {
	implementation(project(":domain"))

	implementation(kotlin("stdlib", kotlinVersion))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

	api("androidx.core:core-ktx:1.2.0")
}
