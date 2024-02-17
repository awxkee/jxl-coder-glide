# JPEG XL plugin for Glide in Android 24+

The Glide JXL Plugin is an efficient and versatile library that seamlessly integrates with Glide, a popular image loading library for Android. With this plugin, you can effortlessly decode and display JPEG XL (JXL) images within your Android application, providing a superior image loading experience for your users.

# Installation

Just add app glide module in your main project and all will start work automatically

# Add Jitpack repository

```groovy
repositories {
    maven { url "https://jitpack.io" }
}
```

```groovy
implementation 'com.github.awxkee:avif-coder-glide:1.10.0' // or any version above picker from release tags
```

# Usage

```kotlin
// After you successfully added library you can start download JPEG XL images
val imageView: ImageView = findViewById(R.id.imageView)
val imageUrl = "https://example.com/your_image.jxl"

Glide.with(this)
  .load(imageUrl)
  .into(imageView)
```

# Disclaimer

## JPEG XL

Enhance your Android app's image loading capabilities with the Glide JXL Plugin and provide your users with a smoother experience when handling JPEG XL (JXL) images. If you have any questions or need assistance, please refer to the GitHub repository for more information and support.
