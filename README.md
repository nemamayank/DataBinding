**DataBinding**

Data Binding Library is a support library that enables you to bind UI elements in your layouts to data sources in your app using a declarative style rather than programmatically.
- Helps you to understand the binding of data through XML in your projects
- Its exclude your boilerplate id's in your project which beautifies your project in a simple and clean way.
To start using data binding on your android studio:
- Download the library from the Support Repository in the Android SDK manager.
- Configure your app to use data binding, add the dataBinding element to your build.gradle file in the app module, as shown in the    following example:

```
// enable data binding for app here
android {
    ...
    dataBinding {
        enabled = true
    }
}
```
  
  
  <img src="https://user-images.githubusercontent.com/9590912/38034266-8a931564-32bf-11e8-9f96-04c58cbbd577.gif" alt="alt text" width="300" height="600">
