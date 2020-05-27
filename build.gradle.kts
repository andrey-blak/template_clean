import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		google()
		jcenter()
		mavenCentral()
	}
	val kotlinVersion = "1.3.72"
	dependencies {
		classpath("com.android.tools.build:gradle:3.6.3")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
	}
}

allprojects {
	repositories {
		google()
		jcenter()
		mavenCentral()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = JavaVersion.VERSION_1_8.toString()
		}
	}
}

tasks.register("clean", Delete::class) {
	delete(rootProject.buildDir)
}
