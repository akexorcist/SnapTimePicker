[ ![Download](https://api.bintray.com/packages/akexorcist/maven/snap-time-picker/images/download.svg?version=1.0.0) ](https://bintray.com/akexorcist/maven/snap-time-picker/1.0.0/link)

Snap Time Picker
==============================
Another Material Time Picker for developer who do not like default Material Time Picker that difficult to use for most users

![Snap Time Picker Sample](https://raw.githubusercontent.com/akexorcist/Android-SnapTimePicker/master/image/00_header.gif)

Download
===============================

Maven
```
<dependency>
  <groupId>com.akexorcist</groupId>
  <artifactId>snap-time-picker</artifactId>
  <version>1.0.0</version>
</dependency>
```

Gradle
```
implementation 'com.akexorcist:snap-time-picker:1.0.0'
```

Feature
===========================
* iOS Time Picker like with Material Design style 
* Some text & color customization
* Selectable time range support
* ViewModel support for event callback with LiveData (See example)

![Snap Time Picker Sample](https://raw.githubusercontent.com/akexorcist/Android-SnapTimePicker/master/image/01_default.jpg)

Usage
===========================
Relevant class in SnapTimePicker
* SnapTimePickerDialog - Main Class 
* TimeValue - Time data holder that contain hour and minute
* TimeRange - Time range data holder that contain the range of time with start (TimeValue) and end (TimeValue)

To use the SnapTimePicker you have to create the SnapTimePickerDialog from builder
```kotlin
val dialog = SnapTimePickerDialog.Builder().build()
//
dialog.show(supportFragmentManager, tag)
```

SnapTimePickerDialog made from DialogFragment (AndroidX) so it need SupportFragmentManager from Activity/Fragment and any string tag. If you have no idea for the dialog tag. You can use `SnapTimePickerDialog.TAG` 

To custom some text and color in TimePickerDialog. 
```kotlin
SnapTimePickerDialog.Builder().apply {
    setTitle(R.string.title)
    setPrefix(R.string.time_suffix)
    setSuffix(R.string.time_prefix)
    setThemeColor(R.color.colorAccent)
    setTitleColor(R.color.colorWhite)
}.build().show(supportFragmentManager, tag)
```

`Title`, `Prefix` and `Suffix` must be define with string resource. `ThemeColor` and `TitleColor` must be color resource

![Text Customization](https://raw.githubusercontent.com/akexorcist/Android-SnapTimePicker/master/image/02_text.jpg)

![Color Customization](https://raw.githubusercontent.com/akexorcist/Android-SnapTimePicker/master/image/03_color.jpg)

To set pre-selected time and time range in TimePickerDialog. 
```kotlin
SnapTimePickerDialog.Builder().apply {
    setPreselectedTime(TimeValue(2, 34))
    setSelectableTimeRange(TimeRange(TimeValue(2, 15), TimeValue(14, 30)))
}.build().show(supportFragmentManager, tag)
```

![Color Customization](https://raw.githubusercontent.com/akexorcist/Android-SnapTimePicker/master/image/04_time_range.jpg)

For event callback from SnapTimePicker, you have assign the listener after build the SnapTimePickerDialog from builder.
```kotlin
SnapTimePickerDialog.Builder().apply {
    // 
}.build().apply{
    setListener { hour, minute -> 
        // Do something when user selected the time 
    }
}.show(supportFragmentManager, tag)
```

But use listener does not good enough if the app can work in portrait and landscape. To support screen orientation, call `useViewModel()` in SnapTimePickerDialog then observe the event callback from SnapTimePicker's ViewModel from `SnapTimePickerUtil` 

```kotlin
SnapTimePickerDialog.Builder().apply {
    useViewModel()
}.build().show(supportFragmentManager, SnapTimePickerDialog.TAG)

SnapTimePickerUtil.observe(this) { selectedHour: Int, selectedMinute: Int ->
    onTimePicked(selectedHour, selectedMinute)
}
```

SnapTimePickerDialog can be called from anywhere in your code but `SnapTimePickerUtil.observe(...)` must called in `onCreate()` only (That's how ViewModel and LiveData works).

Special Thanks
===========================
@theerasan-salutat

Licence
===========================
Copyright 2019 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
