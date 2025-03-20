☁️ CloudBMI ☁️

CloudBMI is a mobile application for calculating and tracking BMI (Body Mass Index) values. It allows users to input their height, weight, and calculates their BMI. The app stores all user data in Firebase DB and provides an interface for users to view their BMI history.
Features

    BMI Calculation: Users can input their height and weight, and the app will calculate their BMI.
    Firebase Integration: User data is stored in Firebase, including weight, height, BMI, and timestamp.
    User History: Users can view their BMI history in a list format.
    Adaptive UI: The app features a responsive design, making it usable on different screen sizes and orientations.

➡️ App Flow

    MainActivity: This is the starting point where users can input their height, weight, and calculate their BMI.
    UserlistActivity: Displays a list of users and their BMI history retrieved from Firebase.
    MainActivity3: Contains a brief explanation of what BMI is, with an option to return to the calculator.

➡️ Setup

    Clone the repository:

    git clone https://github.com/your-username/CloudBMI.git

    Open the project in Android Studio.

    Make sure you have the necessary Firebase setup and configuration files (e.g., google-services.json).

    Sync the project with Gradle files.

    Run the app on your Android device or emulator.

🔥 Firebase DB Integration

    Authentication: Firebase is used to manage user data.
    Realtime Database: User details are saved in Firebase Realtime Database under the "Users" node.
    Timestamps: The app records the timestamp of each user entry using the Firebase server value or the local time.

⬇️ Dependencies

    Firebase Realtime Database
    Kotlin Standard Library
    AndroidX Components

🙌 Contributing

Feel free to fork the repository and submit pull requests for any improvements or features you'd like to add.

This project is licensed under the MIT License - see the LICENSE file for details.
