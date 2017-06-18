# Android_feez
<br>
<br>
<img src=https://github.com/fythatthepce/Android_feez/blob/master/pictures/android-studio-logo.png />
<br>
<br>
ref >> https://developer.android.com/samples/BasicMediaRouter/res/values/colors.html
1.colors.xml ใส่ใน AndroidStudioProjects >> ชื่อโปรเจค >> app >> src >> main >> res >> values

2.Genymotion
>> http://www.akexorcist.com/2014/02/android-dev-tips-plugin-genymotion_23.html
>> https://www.youtube.com/watch?v=uFwHFLBZBvk
>> https://inthecheesefactory.com/blog/how-to-install-google-services-on-genymotion/th
>> https://docs.google.com/file/d/0B-p1r5SNN4adcmhtaGdMVml0Qzg/edit
>> http://opengapps.org/

3.Downgrade API
>> https://stackoverflow.com/questions/34098723/downgrade-android-sdk-api-23-api-21

android {
    compileSdkVersion 25
    buildToolsVersion "25.0.3"
    defaultConfig {
        applicationId "com.example.feez.feedroid2"
        minSdkVersion 16
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.+'
    compile 'com.android.support.constraint:constraint-layout:1.0.2'
    compile ‘com.android.support:design:25.3.1’
    testCompile 'junit:junit:4.12'
}
