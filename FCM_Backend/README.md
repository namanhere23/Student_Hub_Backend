# FCM Push Notifications Backend (Ktor)

This folder contains the Kotlin/Ktor service for the Student Hub application, entirely focused on communicating with Firebase Cloud Messaging (FCM) to trigger Android push notifications.

---

## 🛠️ Local Setup

To run this Ktor backend locally, follow these steps:

### 1. Requirements
Ensure you have the following installed on your machine:
- **Java Development Kit (JDK) 17+**
- (Optional) IntelliJ IDEA or Android Studio (for Kotlin development)
- Git

### 2. Navigate to this Directory
Make sure you are running commands from inside this specific folder:
```bash
cd FCM_Backend
```

### 3. Firebase Set Up (`service_account_key.json`)
The FCM SDK must be authenticated as an admin on your Firebase project.

1. Go to your [Firebase Console](https://console.firebase.google.com/).
2. Click the gear icon near the top left -> **Project settings** -> **Service accounts**.
3. Generate a new private key. This downloads a `.json` file.
4. Rename your downloaded file to exactly `service_account_key.json`.
5. Place this file inside `src/main/resources/` in this folder.

> **Warning:** This key grants full database access! It is excluded in `.gitignore`. **Do not commit this file to GitHub.**

### 4. Run the Ktor Server
Open your terminal inside this directory and run:
```bash
./gradlew run
```
If successful, you will see it responding locally at `http://0.0.0.0:8080`.

---

## 🚀 Individual Deployment Guide

To deploy this Kotlin service to a production cloud like **Render**, **Heroku**, or a VPS, independently of the Cloudinary backend:

### Step 1: Use Docker for Easy Deployment
This folder already contains a custom `Dockerfile`. When setting up a Web Service, you should tell your hosting provider to use this Dockerfile to build and run the application.

- **Option A (Render/Railway):** Create a new Web Service.
- **Root Directory:** Set the Root to `FCM_Backend`.
- **Environment/Build Type:** Choose **Docker**.

### Step 2: Set Environment Variables instead of the JSON file
You cannot push `service_account_key.json` to GitHub, so your production server won't have it automatically. Instead, provide it securely:

1. Copy the **entire contents** of your local `service_account_key.json` file.
2. In your cloud provider's dashboard, create a new Environment Variable.
3. **Key Name:** `FIREBASE_SERVICE_ACCOUNT_KEY`
4. **Value:** *(Paste the raw JSON content here)*

### Step 3: Deploy
Trigger a deployment. The Dockerfile will compile the Kotlin app and start a self-contained runtime server, pulling your stringified Firebase key automatically on startup.
