object AppDependencies {
    //App Dependencies
    val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime}"
    val compose_activity = "androidx.activity:activity-compose:${Versions.compose_activity}"
    val compose_ui = "androidx.compose.ui:ui:${Versions.compose_ui_version}"
    val compose_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_ui_version}"
    val compose_material = "androidx.compose.material:material:${Versions.compose_material}"
    val hilt_android =          "com.google.dagger:hilt-android:${Versions.hilt_android}"
    val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android_compiler}"
    val compose_navigation = "androidx.navigation:navigation-compose:${Versions.compose_navigation}"

    //App Testing Depes
    /* testImplementation 'junit:junit:4.13.2'
     androidTestImplementation 'androidx.test.ext:junit:1.1.5'
     androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
     androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_ui_version"
     debugImplementation "androidx.compose.ui:ui-tooling:$compose_ui_version"
     debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_ui_version"*/
}