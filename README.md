![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/Broccoli.png)

  [![Download](https://api.bintray.com/packages/samlss/maven/broccoli/images/download.svg?version=1.0.0)](https://bintray.com/samlss/maven/broccoli/1.0.0/link) [![Api reqeust](https://img.shields.io/badge/API-11+-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=11#l11)    [![Apache License 2.0](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/samlss/Broccoli/blob/master/LICENSE) 

 [中文](https://github.com/samlss/Broccoli/blob/master/README_CN.md)

Show the placeholder of view when you are loading something...

### Screenshots
#### The default effect:

![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot1.gif)


#### The advenced effect:
![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot2.gif)

#### Use in RecyclerView
![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot3.gif)


#### DingDing
![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot4.png) 

![Broccoli](https://github.com/samlss/Broccoli/blob/master/screenshots/screenshot5.png)
------
### Dependency

#### Gradle
Add it in your module build.gradle at the end of repositories:
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

### Sample Usage

```java
Broccoli broccoli = new Broccoli();

//add the default style placeholder
broccoli.addPlaceholders('activity', 'view_id', 'view_id'); 

or 
//add the default style placeholder
broccoli.addPlaceholders('view1', 'view2', 'view3'); 

or 

//add the custom style placeholder
broccoli.addPlaceholder(new PlaceholderParameter.Builder()
                        .setView('view')
                        .setAnimation('scaleAnimation');
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build()); 

or
//add the custom style placeholder with gradient animation
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
