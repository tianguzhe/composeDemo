## compose study project

### 沉浸式状态栏

![沉浸式状态栏](./images/SCR-20230301-e99.jpg)

1. 添加依赖

```groovy
def accompanist_version = "0.29.1-alpha"
implementation("com.google.accompanist:accompanist-insets:$accompanist_version")
implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanist_version")
```

2. 设置占用状态栏

```kotlin
 WindowCompat.setDecorFitsSystemWindows(window, false)
```

3. 设置状态栏高度

```kotlin
Spacer(
    modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars).fillMaxWidth(),
)
```

