plugins {
	id("java-library")
	id("kotlin")
}

dependencies {
	implementation(fileTree(baseDir = "libs").include("*.jar"))

	implementation(kotlin("stdlib", kotlinVersion))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}
