# Student Hub - Centralized Backend

Welcome to the centralized backend repository for the **Student Hub** Android application. This repository is a **monorepo** containing two independent microservices:
Welcome to the centralized backend repository for the **Student Hub** Android application. This repository is a **monorepo** containing two independent microservices:

1.  **Cloudinary Backend**: An Express.js (Node.js) service for handling media uploads (Images/Videos) to Cloudinary.
2.  **FCM Backend**: A Ktor (Kotlin) service for handling Android push notifications via Firebase Cloud Messaging.

---

## Quick Links

- 🛠️ [Deploy Cloudinary Backend](Cloudinary_Backend/README.md#-individual-deployment-guide)
- 🛠️ [Deploy FCM Backend](FCM_Backend/README.md#-individual-deployment-guide)

---

## 📡 API Reference

### Cloudinary Backend (Default Port: `8000`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/checks` | Health-check endpoint — returns `{"message": "ok"}` |
| `POST` | `/api/v1/uploadMedia` | Upload a media file (image/video/document) to Cloudinary. Send as `multipart/form-data` with a `media` field. |

### FCM Backend (Default Port: `8080`)

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| `GET`  | `/health` | Health-check endpoint — returns `{"status": "Awake and healthy"}` | — |
| `POST` | `/send` | Send a push notification to a specific device via its FCM token | `{ "to": "<FCM token>", "notification": { "title": "...", "body": "..." } }` |
| `POST` | `/broadcast` | Broadcast a notification to all devices subscribed to the `Chat` topic | `{ "to": null, "notification": { "title": "...", "body": "..." } }` |

> **Note:** In the FCM backend, when `to` is `null`, the notification is broadcast to the **"Chat" topic** (all subscribed devices). When `to` contains a valid FCM token, it targets that specific device.