# ougi-example

## Gradle スクリプト

```gradle
buildscript {
    ext {
        ...
        ougi_version = "0.0.12"
    }
    repositories {
        ...
        maven {
            url "https://lembryo.github.io/maven/" // ougi を使用する
        }
    }
    dependencies {
        ...
        classpath "com.lembryo:ougi:$ougi_version" // ougi plug-in を使用する
    }
}

...
apply plugin: "com.github.lembryo.ougi" // ougi plug-in を使用する

...
version "$ougi_version"

repositories {
    ...
    maven {
        url "https://lembryo.github.io/maven/" // ougi を使用する
    }
}

dependencies {
    ...
    implementation "com.lembryo:ougi:$ougi_version"
}

ougi {
    group = project.group
}
```

## 実装

TODO...
