## 项目名：yygomyc 每易充

### 1、mvp＋retiofit＋rxjav完成整体框架
   > 网络模块完成（测试登录接口通过）
   
   > 使用依赖如下：
    ```
     /* RxAndroid */
     compile 'io.reactivex.rxjava2:rxjava:2.1.0'
     /*RxJava*/
     compile 'io.reactivex.rxjava2:rxandroid:2.0.1'
     /*Rx生命周期管理*/
     compile 'com.trello.rxlifecycle2:rxlifecycle:2.1.0'
     compile 'com.trello.rxlifecycle2:rxlifecycle-components:2.1.0'
     compile 'com.squareup.retrofit2:retrofit:2.3.0'
     /*gson转换器的依赖**/
     compile 'com.squareup.retrofit2:converter-gson:2.3.0'
     compile 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'
     /*网络请求框架*/
     compile 'com.squareup.okhttp3:logging-interceptor:3.8.0'
    ```
   
   
### 2、v7包版本：com.android.support:appcompat-v7:25.4.0   

### 3、添加SplashActivity（欢迎页解决启动时短暂的白屏，可在此加入广告页）
   
### 4、顶部菜单使用toorbar（android.support.v7.widget.Toolbar）

### 5、底部菜单使用BottomNavigationBar

 > 使用版本：compile 'com.ashokvarma.android:bottom-navigation-bar:2.0.1' 
 
 > com.ashokvarma.bottomnavigation.BottomNavigationBar
 
 > 结合Fragment实现页面之间的切换,同时引入引入ViewStub
 
 > 引入ViewStub的好处说明：
 ```
    ViewStub 是一个不可见的，大小为0的视图，可以在运行过程中延时加载布局资源。
    当ViewStub被设置成可见，或者它的inflate() 方法被调用的时候，布局资源才会被填充，
    然后ViewStub本身就会被填充起来的布局资源替换掉。
  ```

### 6、打包
 > 创建签名文件
 
 > 打包：1:Build->Generate Signed APK。 2:Gradle配置打包（具体详细见build.gradle）
    
 > 用Terminal执行命令打包要点：
   ```
    添加gradle环境变量
    window的打包命令为：gradlew assembleRelease
    mac：./gradlew assembleRelease
   ```                                   

### 7、多渠道打包（后续补充。。。）
 > Walle：Android Signature V2 Scheme签名下的新一代渠道包打包神器
 
 > [介绍地址](https://tech.meituan.com/android-apk-v2-signature-scheme.html)
 
 > 配置如下
 ```
    在位于项目的根目录 build.gradle 文件中添加Walle Gradle插件的依赖， 如下：
    buildscript {
        dependencies {
            classpath 'com.meituan.android.walle:plugin:1.1.5'
        }
    }
    
    并在当前App的 build.gradle 文件中apply这个插件，并添加上用于读取渠道号的AAR
    apply plugin: 'walle'
    dependencies {
        compile 'com.meituan.android.walle:library:1.1.5'
    }
    
    配置插件
    walle {
        // 指定渠道包的输出路径
        apkOutputFolder = new File("${project.buildDir}/outputs/channels");
        // 定制渠道包的APK的文件名称
        apkFileNameFormat = '${appName}-${packageName}-${channel}-${buildType}-v${versionName}-${versionCode}-${buildTime}.apk';
        // 渠道配置文件
        channelFile = new File("${project.getProjectDir()}/channel")
    }
```
 > 操作：在Terminal中输入对应的指令，即可完成打包
 ```
 1:所有渠道:./gradlew clean assembleReleaseChannels
    渠道包的生成目录默认存放在 build/outputs/apk/，也可以通过Walle闭包中的apkOutputFolder参数来指定输出目录
 2:指定渠道:
     如：./gradlew clean assembleReleaseChannels -PchannelList=huawei
 
```

 > 结果：
 ```
 运行./gradlew clean assembleReleaseChannels后，
 可以在build/outputs/channels看到对应的渠道包。
```

### 8、混淆