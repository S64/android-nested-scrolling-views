## NestedScrollingViews

Custom views of NestedScrollingChild implementation.

This is contains below components:

- NestedCoordinatorLayout
- NestedScrollingViewActions
- NestedScrollToAction

## Usages

Add following lines to your buildscripts.

```groovy
buildscript {
    ext {
        nested_scrolling_views_version = '0.0.5'
    }
}
```

```groovy
repositories {
    maven {
        url 'http://dl.bintray.com/s64/maven'
    }
}

dependencies {
    compile("jp.s64.android.nestedscrollingviews:support-v25:${nested_scrolling_views_version}")
}
```

## Apps using android-inset-views

- [Wantedly Visit](https://play.google.com/store/apps/details?id=com.wantedly.android.visit) & [Intern](https://play.google.com/store/apps/details?id=com.wantedly.android.student)

## Donate

<a href="https://donorbox.org/android-nested-scrolling-views"><img src="https://d1iczxrky3cnb2.cloudfront.net/button-small-blue.png" /></a>

## License

```
Copyright 2017 Shuma Yoshioka

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

