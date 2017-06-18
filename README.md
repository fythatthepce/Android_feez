# Android_feez
<br>
<br>
<img src=https://github.com/fythatthepce/Android_feez/blob/master/pictures/android-studio-logo.png />
<br>
<br>
ref >> https://developer.android.com/samples/BasicMediaRouter/res/values/colors.html<br>
1.colors.xml ใส่ใน AndroidStudioProjects >> ชื่อโปรเจค >> app >> src >> main >> res >> values
<br><br>
<img src=https://github.com/fythatthepce/Android_feez/blob/master/pictures/coverg_g-_2013_v2_2120x1192.png/>
<br>
2.Genymotion<br>
>> http://www.akexorcist.com/2014/02/android-dev-tips-plugin-genymotion_23.html<br>
>> https://www.youtube.com/watch?v=uFwHFLBZBvk<br>
>> https://inthecheesefactory.com/blog/how-to-install-google-services-on-genymotion/th<br>
>> https://docs.google.com/file/d/0B-p1r5SNN4adcmhtaGdMVml0Qzg/edit<br>
>> http://opengapps.org/<br>
<br><br>
3.Downgrade API<br>
>> https://stackoverflow.com/questions/34098723/downgrade-android-sdk-api-23-api-21
<br>
android {<br>
    compileSdkVersion 25<br>
    buildToolsVersion "25.0.3"<br>
    defaultConfig {<br>
        applicationId "com.example.feez.feedroid2"<br>
        minSdkVersion 16<br>
        targetSdkVersion 25<br>
        versionCode 1<br>
        versionName "1.0"<br>
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"<br>
    }<br>
    buildTypes {<br>
        release {<br>
            minifyEnabled false<br>
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'<br>
        }<br>
    }<br>
}<br>

dependencies {<br>
    compile fileTree(dir: 'libs', include: ['*.jar'])<br>
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {<br>
        exclude group: 'com.android.support', module: 'support-annotations'<br>
    })<br>
    compile 'com.android.support:appcompat-v7:25.+'<br>
    compile 'com.android.support.constraint:constraint-layout:1.0.2'<br>
    compile ‘com.android.support:design:25.3.1’<br>
    testCompile 'junit:junit:4.12'<br>
}<br>
