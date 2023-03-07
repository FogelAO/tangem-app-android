plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("configuration")
}

dependencies {

    /** Project*/
    implementation(project(":core:datasource"))
    implementation(project(":core:utils"))
    implementation(project(":features:referral:domain"))

    /** Time */
    implementation(Library.jodatime)

    /** DI */
    implementation(Library.hilt)
    kapt(Library.hiltKapt)
}
