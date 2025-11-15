# Real-Time Edge Detection Viewer

This is an Android application that uses the device's camera to capture a video feed, processes the frames with OpenCV in C++ to detect edges, and then displays the processed video in real-time using OpenGL ES.

## Features

*   **Camera Feed Integration**: Utilizes CameraX to display a live camera preview.
*   **Frame Processing via OpenCV (C++)**: Sends camera frames to a native C++ function using JNI, where OpenCV's Canny edge detection is applied.
*   **Render Output with OpenGL ES**: Renders the processed frames using OpenGL ES 2.0 for a smooth, real-time display.
*   **Web Viewer (TypeScript)**: A basic web page that displays a placeholder for a processed frame and some sample statistics.

## Architecture

*   `/app`: Contains the Android application code, written in Kotlin. This includes the CameraX setup, `GLSurfaceView` and its renderer, and the main activity.
*   `/app/src/main/cpp`: Contains the native C++ code for image processing with OpenCV.
*   `/web`: Contains a simple TypeScript and HTML setup for a web-based viewer.

### Frame Flow

1.  The `MainActivity` sets up a CameraX `ImageAnalysis` use case.
2.  For each frame, the `ImageAnalysis` analyzer is called.
3.  The `ImageProxy` is converted to an OpenCV `Mat`.
4.  The `Mat` is passed to the native `processImage` function via JNI.
5.  The C++ `processImage` function applies the Canny edge detection algorithm.
6.  The processed `Mat` is converted to a `Bitmap` in `MainActivity`.
7.  The `Bitmap` is passed to the `MyGLRenderer`.
8.  The renderer displays the `Bitmap` on a `GLSurfaceView`.

### TypeScript Component

The `/web` directory contains a standalone `index.html` and `main.ts`. To view it, you'll need to compile the TypeScript to JavaScript. You can do this with the TypeScript compiler:

```bash
tsc web/main.ts
```

This will generate a `main.js` file. You can then open `web/index.html` in your browser to see the web viewer.

## Setup

1.  **OpenCV for Android SDK**: This project requires the OpenCV for Android SDK. You will need to download it and update the path in the `settings.gradle.kts` and `app/src/main/cpp/CMakeLists.txt` files to point to the location of the SDK on your machine.
2.  **NDK**: The Android NDK is required for the C++ portion of this project. You can install it through the SDK Manager in Android Studio.
3.  **Build the Project**: Once you have the OpenCV SDK and NK set up, you can build the project in Android Studio.
