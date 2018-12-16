![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/Broccoli.png)

  [![Download](https://api.bintray.com/packages/samlss/maven/broccoli/images/download.svg?version=1.0.0)](https://bintray.com/samlss/maven/broccoli/1.0.0/link) [![Api reqeust](https://img.shields.io/badge/API-11+-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=11#l11)    [![Apache License 2.0](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/samlss/Broccoli/blob/master/LICENSE) 

在预加载时显示view的占位符效果

### 截图
#### 默认效果:

![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot1.gif)


#### 自定义动画效果:
![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot2.gif)

#### 在RecyclerView使用
![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot3.gif)


#### 钉钉考勤
![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot4.png) 

![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot5.png)
------
### 依赖

#### Gradle
将其添加到你的module的build.gradle中： 

  ```java
  dependencies {
      implementation 'me.samlss:broccoli:1.0.0'
  }
  ```

#### Maven
```java
<dependency>
  <groupId>me.samlss</groupId>
  <artifactId>broccoli</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

### 代码使用

```java
Broccoli broccoli = new Broccoli();

//添加默认的占位符
broccoli.addPlaceholders('activity', 'view_id', 'view_id'); 

or 
//添加默认的占位符
broccoli.addPlaceholders('view1', 'view2', 'view3'); 

or 

//添加自定义的占位符
broccoli.addPlaceholder(new PlaceholderParameter.Builder()
                        .setView('view')
                        .setAnimation('scaleAnimation');
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build()); 

or
//添加带渐变动画的占位符
broccoli.addPlaceholder(new PlaceholderParameter.Builder()
                        .setView('view')
                        .setDrawable(new BroccoliGradientDrawable(Color.parseColor("#DDDDDD"),
                            Color.parseColor("#CCCCCC"), 0, 1000, new LinearInterpolator())
                        .build()); 
broccoli.show();
```



### License

```
Copyright 2018 samlss

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
