# LoadingDialog 加载等待窗

[![](https://www.jitpack.io/v/BenShanYang/LoadingDialog.svg)](https://www.jitpack.io/#BenShanYang/LoadingDialog)

## 效果图
![loading](https://github.com/BenShanYang/LoadingDialog/blob/main/image_demo/loading.png?raw=true)

## 使用步骤

#### Step 1.依赖LoadingDialog
Gradle
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://www.jitpack.io' }
  }
}
dependencies {
  implementation 'com.github.BenShanYang:LoadingDialog:1.0.1'
}
```
或者引用本地lib
```groovy
implementation project(':loading')
```

#### Step 2.在你的类中使用
```java
LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(this)
        .setMessage("加载中...")//设置提示文字
        .setCancelable(true)//按返回键取消
        .setMessageColor(Color.WHITE)//提示文字颜色
        .setMessageSize(14)//提示文字字号
        .setBackgroundTransparent(true)//弹窗背景色是透明或半透明
        .setCancelOutside(true);//点击空白区域弹消失
LoadingDialog dialog = loadBuilder.create();
dialog.show();
```
