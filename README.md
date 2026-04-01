# Student Hub - Centralized Backend

Welcome to the centralized backend repository for the Student Hub project. This repository is a **monorepo** that contains two independent microservices:

1.  **Cloudinary Backend**: An Express.js (Node.js) service for handling media uploads (Images/Videos) to Cloudinary.
2.  **FCM Backend**: A Ktor (Kotlin) service for handling Android push notifications via Firebase Cloud Messaging.

---

## 🛠️ Combined Local Setup

If you want to run both backends locally, follow these steps:

### 1. Configure the Shared Environment
Create a **single** `.env` file in the **root directory** of this project (the folder containing this README). Both services can use configuration from this root setup.

```env
# Cloudinary Backend Config
PORT=8000
CORS_ORIGIN=<your-client-url>
CLOUDNINARY_CLOUD_NAME=<your-cloudinary-name>
CLOUDNINARY_API_KEY=<your-cloudinary-api-key>
CLOUDNINARY_API_SECRET=<your-cloudinary-api-secret>

# FCM Backend Config
# (The FCM backend parses your service_account_key.json, see FCM docs below)
```

### 2. Start the Cloudinary Backend
Open a terminal, navigate to the Node application, install dependencies, and run:
```bash
cd Cloudinary_Backend
npm install
npm run dev
```
*(Runs on port 8000 by default).*

### 3. Start the FCM Backend
Open a *second* terminal, navigate to the Kotlin application, ensure your Firebase key is in `src/main/resources/`, and run:
```bash
cd FCM_Backend
./gradlew run
```
*(Runs on port 8080 by default).*

---

## 🚀 How to Deploy Both Services

Because these are two different technologies (Node.js and Kotlin/Java) inside one repository, **you must deploy them as two separate services / applications** on your hosting provider (like Render, Railway, or Heroku). 

You **cannot** run them inside a single web service. Use the following strategy:

### Strategy for Hosting Providers (e.g., Render)

1. **Create Web Service #1 (API/Media)**: 
   - Connect this GitHub repository.
   - Set the **Root Directory** to `Cloudinary_Backend`.
   - Set the Build Command to `npm install`.
   - Set the Start Command to `npm start`.
   - Add your Cloudinary `.env` variables to this specific service.

2. **Create Web Service #2 (Notifications)**:
   - Connect the *exact same* GitHub repository.
   - Set the **Root Directory** to `FCM_Backend`.
   - Select Docker environment (a `Dockerfile` is provided).
   - Add your `FIREBASE_SERVICE_ACCOUNT_KEY` environment variable to this specific service.

Now both services will independently pull from this single repository but build and run in their own specific environments. For more detailed, individual deployment instructions, check the READMEs inside each folder.

---

## 📂 Project Structure

```text
.
├── Cloudinary_Backend/         # Node.js/Express Media Service
│   ├── src/                    # Controllers, Routes, Utils
│   ├── README.md               # Specific Setup & Deploy Guide
│   └── package.json            
├── FCM_Backend/                # Kotlin/Ktor Notification Service
│   ├── src/main/kotlin/        # Source Code
│   ├── Dockerfile              # Docker configuration for deployment
│   ├── README.md               # Specific Setup & Deploy Guide
│   └── build.gradle.kts        
└── README.md                   # This file (Global Overview)
```
