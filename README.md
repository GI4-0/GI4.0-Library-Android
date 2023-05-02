# GI4.0-Library-Android

## Setup

The library is delivered as an build artifact on a Maven repository. Please follow the follow the following steps to include it into your project.

## Step 1

Add the jitpack repository in your build.gradle or settings.gralde

```groovy
repositories {
    ...
    maven { url 'https://jitpack.io' }
    ...
}
```

### Step 2

Add the following dependenc< in your build.gradle file (app):

```groovy
dependencies {
    ...
    implementation 'com.github.GI4-0:GI4.0-Library-Android:1.1.0'
    ...
}
```

## Using the SDK

### Search

The following static method will start the corresponding activity.

```java
GI40Library.showSearch(Context context)
```

### Scan

The following static method will start the corresponding activity.

```java
GI40Library.startScan(Context context)
```

### History

The following static method will start the corresponding activity.

```java
GI40Library.showHistory(Context context)
```
