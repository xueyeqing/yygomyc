# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/a1/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
# webView处理，项目中没有使用到webView忽略即可
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#####################################################
#
# WebView相关
#
#####################################################
# webView处理，项目中没有使用到webView忽略即可  替换成自己你自己定义的那个类名
# eg:登录的js
#-keepclassmembers class com.winorout.yygo.myc.xxx {
#    public *;
#}

#-keepattributes *JavascriptInterface*

#-keepclassmembers class * extends android.webkit.webViewClient {
#    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
#   public boolean *(android.webkit.WebView, java.lang.String);
#}
#-keepclassmembers class * extends android.webkit.webViewClient {
#    public void *(android.webkit.webView, jav.lang.String);
#}


#####################################################
#
# 基本配置-不能被混淆的
#
#####################################################

# 指定压缩级别
-optimizationpasses 5
# 混淆时采用的算法(google推荐，一般不改变)
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#混淆后类名都为小写
-dontusemixedcaseclassnames
#指定不去忽略非公共的库的类
-dontskipnonpubliclibraryclassmembers
#生成原类名和混淆后的类名的映射文件
-verbose
-printmapping proguardMapping.txt
#不做预校验的操作
-dontpreverify

#忽略警告
#-ignorewarning

#保留我们使用的四大组件，自定义的Application等等这些类不被混淆
#因为这些子类都有可能被外部调用
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Appliction
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService


-keepattributes *Annotation*

#####################################################
#
# support.v4/v7包不混淆
#
#####################################################
# 保留support下的所有类及其内部类
-keep class android.support.** {*;}
-keep class android.support.v4.** { *; }
-keep class android.support.v7.** { *; }
# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**
-keep interface android.support.v4.app.** { *; }
-keep interface android.support.v7.app.** { *; }


#####################################################
#
# 保持注解继承类不混淆
#
#####################################################


#####################################################
#
# 保持枚举enum类不被混淆
#
#####################################################
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}


#####################################################
#
# Parcelable，Serializable序列化类
#
#####################################################

#####################################################
#
# 自定义组件不被混淆
#
#####################################################


#####################################################
#
# 不混淆资源类
#
#####################################################



###-----------第三方jar包library混淆配置------------###
#Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

#Rxjava RxAndroid
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson 下面替换成自己的实体类
-keep class com.winorout.yygo.myc.model.bean.** { *; }

##---------------End: proguard configuration for Gson  ----------

#OkHttp3
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**




