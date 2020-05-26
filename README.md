# TextView dot animation

### Android Library to depict dot loading animation on ` TextView `
<img src="https://github.com/rajputkapil/textviewdotsanimation/blob/master/app/src/main/res/raw/loading.gif" width="300" />

## How to use it in your build:

1. Add the JitPack repository to your build file
- add it in your root build.gradle at the end of repositories:
    ```java
    allprojects { 
      repositories {
      ...
      maven { url 'https://jitpack.io' }
      }
    }
     ```
2. Add the dependency in your app level gradle
  
    ```
    dependencies { 
      implementation 'com.github.rajputkapil:textviewdotsanimation:v1.0'
    }
     ```
## Features
 
* Add the count of dots you want to display to the user
* Add text to show on left of animated dots like loading...
* Can also show only dots with animation
 
## Class and Methods
 
* In your ` layout xml file ` call this view 
 
    ```
    <dots.animation.textview.TextAndAnimationView
      xmlns:app="http://schemas.android.com/apk/res-auto"
      android:id="@+id/animated_dots"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      app:numberOfDots="10"
      app:setText="Loading"
      app:setTextSize="30" />
     ```
 * Anotomy
 
  Attribute | Detail  
  -----------------|-----------------------------
  app:numberOfDots | No of dots to show on screen
  app:setText | Show text with dots   
  app:setTextSize | Decides Text size  
  
 #### Note
- In **.java** or **.kt** don't forget to call stopAnimation()
    ```java
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      textAndAnimationView = findViewById(R.id.animated_dots)
    }
     ```
    ```java
    override fun onStop() {
      super.onStop()
      textAndAnimationView.stopAnimation()
    }
	```

### About Me
Github: https://github.com/rajputkapil  
Email: kapil12111@gmail.com   
Stackoverflow : https://stackoverflow.com/users/4286992/kapil-rajput?tab=profile  


### License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
