
# AndroidUtils
[![](https://jitpack.io/v/alexsgi/AndroidUtils.svg)](https://jitpack.io/#alexsgi/AndroidUtils) [![](https://jitci.com/gh/alexsgi/androidutils/svg)](https://jitci.com/gh/alexsgi/androidutils)

## 1. Import

**Gradle:**
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
```gradle
dependencies {
	implementation 'com.github.alexsgi:AndroidUtils:1.0'
}
```
(Instead of "1.0" you can insert every available version → check under "releases").

## 2. Usage

 ###  Time-oriented functions :
 
 Run something delayed:
 ```java
FutureTaskExecutor.runDelayed(final Runnable runnable, int millisInFuture);
```
 ```java
FutureTaskExecutor.runDelayed(new Runnable() {
	@Override
    public void run() {
	    System.out.println("Message");
    }
}, 5000);
```
____________________
```java
FutureTaskExecutor.runDelayed(final Runnable runnable, int millisInFuture, final View view);
```
```view``` : if you want to run the runnable on the UI thread, pass a view as a param.

---

###  UI helper :
```java
ActivityUtils.setPortraitMode(Activity activity);
ActivityUtils.setLandscapeMode(Activity activity);
ActivityUtils.setAutomaticMode(Activity activity);
int orientation = ActivityUtils.getRequestedOrientation(Activity activity);
```
Example:
```java
public class MainActivity extends AppCompatActivity {
	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
		setContentView(R.layout.activity_main);  
		ActivityUtils.setPortraitMode(this);  
	}
}
```

---
Start another activity:
```java
ActivityUtils.startActivity(Activity currentActivity, Class<?> cls); // equal to startActivity(Intent intent)
ActivityUtils.startActivity(Activity currentActivity, Class<?> cls, boolean finishActivity); // (if true: activity.finish() called after intent)
ActivityUtils.startActivity(final Activity currentActivity, final Class<?> cls, int delay); // starts intent with a delay (in ms)
ActivityUtils.startActivity(final Activity currentActivity, final Class<?> cls, boolean finishActivity, int delay); // starts intent with a delay (in ms) and if finishActivity == true: activity.finish() called
```
Example:
```java
public class MainActivity extends AppCompatActivity {
	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
		setContentView(R.layout.activity_main);  
		ActivityUtils.setPortraitMode(this);  
		// ...
		ActivityUtils.startActivity(this, AnotherActivity.class, true, 5000);
	}
}
```
---
Clear text of TextViews and inherits of TextView:
```java
ActivityUtils.clearTextOnViews(View... views);
```
Example:
```java
ActivityUtils.clearTextOnViews(textView, button, whatEver);
```
---
Advanced UI settings:
```java
ActivityUtils.setLightStatusBar(View view, Activity activity);
ActivityUtils.clearLightStatusBar(Activity activity, int color);
```
Example:
```java
public class MainActivity extends AppCompatActivity {
	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    	super.onCreate(savedInstanceState);  
		setContentView(R.layout.activity_main);  
		TextView textView = findViewById(R.id.txt);
		ActivityUtils.setLightStatusBar(txt, this);
	}
}
```
