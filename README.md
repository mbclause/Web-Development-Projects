# Web Development Class Projects

This repository contains a wide range of web development assignments and labs completed for a university-level Web Development course. The projects span both frontend and backend technologies including HTML, JSP, Java Servlets, JDBC, SQL, CSS, and AJAX.

> 🧑‍🎓 All work in this repository was completed independently by **Michael Clausen**. Starter code (e.g., servlet and JSP templates) was provided by the professor for some assignments, but all application logic, integration, and debugging were done by me.

---

## 📂 Contents

### 🔹 Core Technologies

- **Frontend:** HTML, CSS, JavaScript, AJAX
- **Backend:** Java Servlets, JSP, JDBC
- **Database:** MySQL / SQL via JDBC

---

## 💡 Highlight Projects

### 🧮 BMI Calculator (`/BMI`)

- Java Servlet that calculates **Body Mass Index (BMI)** based on user input (height/weight).
- Returns formatted HTML output with BMI result and interpretation.
- Demonstrates clean servlet structure and output formatting.

✅ **Fully functional**

---

### 📒 Guest Book (`/GuestBook`, `GuestBookJDBC`)

- Users can submit messages and view all prior entries.
- Two versions:
  - In-memory guestbook (`GuestBook`)
  - Persistent guestbook using JDBC and SQL (`GuestBookJDBC`)
- Demonstrates servlet lifecycle and database integration.

✅ **Core features working**
⚠️ Requires DB setup for `GuestBookJDBC`

---

### 🧪 Midterm Project (`/Midterm`)

- Multi-page JSP and Servlet application simulating midterm coverage.
- Features login, form handling, file uploads, and session tracking.
- Meant to test integration of multiple skills under timed conditions.

✅ **Mostly functional**
⚠️ May require local setup to enable all features

---

### 🧪 Practice Final (`/PracticeFinal`)

- Simulates final exam development conditions.
- Implements servlet-based control flow, input validation, and dynamic results page.
- Useful for end-to-end testing of development environment setup.

✅ **Fully implemented**

---

### 🎓 Final Project (`/Final`)

- Capstone project combining:
  - User session management
  - Form input and validation
  - JDBC database access
  - JSP rendering and servlet control
- Designed to reflect a full-stack Java web application.

✅ **Runs with correct setup**
⚠️ Requires SQL schema and servlet container to deploy

---

## 🧪 Additional Labs and Assignments

- `lab1.html` → `lab21.html`: Hands-on exercises with HTML, CSS, JavaScript, and JSP
- `CurrencyConverter.java`: Demonstrates GET vs POST handling in servlets
- `ShoppingList.jsp`: Session-aware list functionality in JSP
- `AddItem.java` + `DeleteItem.java`: Simple CRUD operations

---

## ▶️ How to Run

1. Import the project into **Eclipse** (or another IDE) as a **Dynamic Web Project**.
2. Use **Apache Tomcat** or similar servlet container.
3. Ensure a compatible **JDBC driver** is configured.
4. Set up any required SQL schemas using `.sql` files (e.g., `forums.sql`, `items.sql`).
5. Access applications via `http://localhost:8080/...`.

---

## 👥 Author & Attribution

- **Author:** Michael Clausen
- **Collaboration:** None — all work done individually
- **Instructor:** Provided base servlet and JSP scaffolding for some assignments

---

## 📚 References

- Oracle Java Servlet API
- StackOverflow (for debugging)
- Instructor office hours and email support

---

## 📜 License

This repository is intended for educational use. All student code is original unless otherwise noted in the file headers.
