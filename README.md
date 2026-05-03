# 🏠 HomeTutor System

A comprehensive **Home Tutor Searching & Booking System** designed to bridge the gap between students and qualified tutors. This platform provides a seamless experience for finding tutors, scheduling sessions, and managing bookings through a robust administrative interface.

---

## ✨ Key Features

### 🎓 For Students
- **Smart Discovery:** Search and filter tutors by subject, availability, and location.
- **Easy Booking:** Schedule tutoring sessions with just a few clicks.
- **Secure Payments:** Integrated payment processing for booking confirmations.
- **Profile Management:** Keep track of your learning progress and upcoming sessions.
- **Review System:** Share feedback and rate your tutors.

### 👨‍🏫 For Tutors
- **Profile Showcase:** Professional profile management to highlight expertise.
- **Schedule Management:** Control your availability and manage student bookings.
- **Performance Tracking:** Monitor earnings and student reviews.

### 🛠️ For Administrators
- **User Management:** Oversee all student and tutor accounts.
- **Subject Control:** Manage the catalog of subjects and categories.
- **Financial Oversight:** Monitor transactions and payment statuses.
- **System Analytics:** Track platform growth and booking trends.

---

## 🚀 Technology Stack

- **Backend:** Java 21, Spring Boot 3.2.4
- **Security:** Spring Security (Auth, Role-based Access)
- **Frontend:** Thymeleaf Templates, Modern CSS3, JavaScript
- **Database:** H2 / MySQL (Configuration ready)
- **Build Tool:** Maven

---

## 🛠️ Installation & Setup

### Prerequisites
- JDK 21 or higher
- Maven 3.6+
- Node.js (Optional, for frontend scripts)

### Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/hometutor-booking-system.git
   cd hometutor-booking-system
   ```

2. **Configure Environment:**
   Update `src/main/resources/application.properties` with your database and server configurations.

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080`.

---
