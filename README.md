# 🤖 Email-AI-Assistant
---
### Project Description: 

- Built an AI-powered email writing assistant using React, Material UI, and Axios with a Java Spring Boot backend, integrating Google Gemini API to analyze email content and generate context-aware, professional responses.

- Developed a Chrome Extension integrated with Gmail, enabling users to generate AI-assisted replies directly within their inbox, improving productivity and streamlining communication workflows.

----
Output :

Front-End: ![FrontEndReply](https://github.com/user-attachments/assets/420aaa8a-22dc-4b56-ade1-b499605a474a)

Extension added on browser: ![AIReply](https://github.com/user-attachments/assets/7516e863-c2cf-4edf-a878-a77e7a1b39ae)

---

## 🚀 Getting Started

Follow these steps to set up the project locally:

### ✅ Prerequisites

---

## 🧩 Tech Stack
- **Frontend:** React, Material UI, Axios  
- **Backend:** Java, Spring Boot  
- **AI Integration:** Google Gemini API  
- **Extension:** Chrome Extension for Gmail  
- **Build Tools:** Vite / Webpack (optional based on your setup)

Make sure you have the following installed:

- Java (JDK 11+)
- Maven
- Node.js and npm
---

 ### ----------- To Local run on your own System -------------

---
###  Step 1: Clone the Repository

```bash
git clone https://github.com/Madhav1101/Email-AI-Assistant.git
```
---

### Step 2: Setup Front-End
Make sure you have Node.js installed.

Navigate to the Email-writer-react folder: 
### cd email-writer-react
###
```bash
npm i
```
###

```bash
npm install @mui/material @emotion/react @emotion/styled
```
```bash
npm i axios
```

### Now you can run Frontend
Enter following commmand :
```bash
npm run dev
```
### Visit http://localhost:3000

---
### Step 3 : Setup Backend
### Open AIwriter folder in your IDE
---
 ### Enter these two lines in your **application.properties** file
```bash
gemini.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=
```
```bash
 gemini.api.key = // Enter your gemini api key here
```
---

### Now you can run your Backend
```bash 
mvn spring-boot:run
```
### OR
GUI based Run the Spring boot Application.

---
### Step 4: To Add your own extension 

- step 1: Open chrome browser Click on three dots
- step 2: Click on extension 
- step 3: Click on Manage extensions
- step 4: Enable Developer Mode
- step 5: Click on Load unpacked
- step 6: Popup appears and select folder of extension Means email-writer-ext

---
> ###  **Feel Free to Fork and clone this Repository.**

> ### ⭐️ **Don't forget to Follow. Thank You!**
