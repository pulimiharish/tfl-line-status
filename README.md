# TFL Line Status (TfL API)

**TFL Line Status** is a simple Android app that displays the real-time status of London Underground ("Tube") lines using the official TfL (Transport for London) API. The app is built with **Kotlin** and **Jetpack Compose**, following **Clean Architecture** principles to keep the code organized and testable. It fetches live data from TfL and presents it in a straightforward, user-friendly UI. Unit tests and screenshot tests are included to ensure everything works as expected.

## Preview

Here's a quick preview of the app in action, showing a list of Tube lines and their current status:
<img src="/art/preview.png" width="300"/>

## Getting Started

### Building the App

1. **Clone the repository:** If you haven't already, clone this project to your local machine using Git.
2. **Open in Android Studio:** Launch Android Studio and select **File > Open**. Navigate to the project directory you just cloned. Android Studio will import the project and start a Gradle sync.
3. **Build the project:** Once the project is open, build it by clicking the **Build** option or the *Play* ▶️ button in Android Studio. Gradle will handle downloading dependencies and compiling the app.
    - *Alternatively*, you can build via command line. Open a terminal in the project root and run:
      ```bash
      ./gradlew assembleDebug
      ```  
      This will compile the app and produce an APK in the `app/build/outputs/apk/` directory.
4. **Run the app:** Connect an Android device or start an emulator. In Android Studio, press the *Run* ▶️ button to install and launch the app on your device/emulator.
    - *Command line option:* You can also install the debug build on a connected device with:
      ```bash
      ./gradlew installDebug
      ```  

### Running the App

Once installed, open the **TFL Line Status** app on your device. You should see a list of all London Tube lines, each with its current status (e.g., "Good Service", "Minor Delays", etc.). Tapping on a line will show more details about the status or any disruptions. The data is fetched live from the TfL API, so you'll need an internet connection for the latest information.

## Testing

This project includes both unit tests and screenshot-based UI tests to ensure reliability. You can run these tests using Gradle:

### Unit Tests

Unit tests cover the business logic (e.g., data parsing, ViewModel logic, etc.). To run the unit tests, use the following command in the project directory:

```bash
./gradlew test
```  

### Screenshot Tests

Screenshot tests verify that the UI looks as expected. We use Android's Jetpack Compose Screenshot Testing utility to capture UI screenshots and compare them against reference images.

Update screenshots
```bash
./gradlew updateDebugScreenshotTest
```  

Verify screenshots
```bash
./gradlew validateDebugScreenshotTest
```  