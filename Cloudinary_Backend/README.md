# Cloudinary Media Backend (Express.js)

This folder contains the Express.js backend responsible for handling media uploads (images and videos) directly to Cloudinary. It is structured as an API independent of the push notification service.

## 🛠️ Local Setup & Installation

Below are the steps to run this specific backend on your local machine.

### 1. Navigate to this Directory
Make sure your terminal is inside the **Cloudinary** backend directory:
```bash
cd Cloudinary_Backend
```

### 2. Install Dependencies
Install all required Node.js packages using npm:
```bash
npm install
```

### 3. Configure Environment Variables
Create a `.env` file either inside this folder, or one level up in the root directory. Add the following variables:

```env
CORS_ORIGIN=<your-client-url>
CLOUDNINARY_CLOUD_NAME=<your-cloudinary-name>
CLOUDNINARY_API_KEY=<your-cloudinary-key>
CLOUDNINARY_API_SECRET=<your-cloudinary-secret>
PORT=8000
```
*(Replace the placeholders with your actual Cloudinary credentials).*

### 4. Run the Backend Server
Once the variables are configured, start the server:

**Development mode (with hot reload):**
```bash
npm run dev
```

**Production mode:**
```bash
npm start
```

---

## 🚀 Individual Deployment Guide

To deploy this specific Node.js (Express) backend to a production service like **Render**, **Railway**, or **Vercel** independently of the FCM backend:

### Step 1: Configure Your Hosting Provider
Because this backend is located inside a sub-folder (`Cloudinary_Backend`), you must tell your hosting provider where to build and run the code.

- **Option A (Render/Railway):** In your Web Service settings, set the **"Root Directory"** to `Cloudinary_Backend`.
- **Build Command:** `npm install`
- **Start Command:** `npm start` 

*(Note: If your hosting provider does not support root directory overrides, you might need to adjust your setup or deploy this subfolder uniquely using CLI tools).*

### Step 2: Set Environment Variables
Add your secrets securely to your provider's dashboard using the variables defined in step 3 above:
- `CORS_ORIGIN` (Your frontend's production URL)
- `CLOUDNINARY_CLOUD_NAME`
- `CLOUDNINARY_API_KEY`
- `CLOUDNINARY_API_SECRET`
- `PORT` (Usually optional as platforms assign this dynamically)

### Step 3: Deploy
Trigger a manual deployment. The server will start up running the Node server exclusively on the port given by your cloud provider.
