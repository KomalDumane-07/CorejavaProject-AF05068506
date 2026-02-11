# Blood Bank Management System

## Project Synopsis
The Blood Bank Management System is a console-based Core Java project that manages donors, customers, blood inventory, and blood requests. 
The system provides separate functionalities for **Admin** and **Customer** roles, ensuring that blood donations and requests are tracked efficiently. 
It uses file-based persistence to save data, so all information remains intact even after the program is closed and restarted.

---
## Modules Overview

### 1. Admin Module
- Handles login for admin using predefined credentials.  
- Can manage **Donors**, **Customers**, and **Inventory**.  
- Can view **Donation Reports** to track blood requests fulfilled.  
- Functions include **add, update, delete, view** for donors and customers, and **add/remove/view stock** for inventory.  

### 2. Customer Module
- Customer can login using credentials.  
- Can view **donor details** and **available blood inventory**.  
- Can make **blood requests**, which are approved if stock is sufficient.  
- Tracks request history and status.  

### 3. Donor Module
- Stores donor details: **ID, Name, Blood Type, Age**.  
- Admin can **add, update, delete, and search donors**.  
- Donor information is used to display available donors to customers.  

### 4. Product / Inventory Module
- Manages **blood stock** of different types (A+, A-, B+, etc.).  
- Admin can **add or remove units** from inventory.  
- Inventory updates automatically when a **blood request is approved**.  

### 5. Request Module
- Handles **blood requests** made by customers.  
- Tracks **request ID, customer, blood type, units requested, and status**.  
- Automatically updates inventory and request status upon approval.  

### 6. Utility Module
- **Database.java** handles file-based storage for **donors, customers, inventory, and requests**.  
- Ensures all data is saved and loaded correctly across program runs.  

---

## Default Credentials

**Admin:**
Username: admin
Password: 123

**Customer:**  
Username: user
Password: 123

## Features
- Console-based menu-driven system  
- File-based data persistence  
- Admin and customer roles with separate access  
- Donor and customer management  
- Inventory management with real-time stock updates  
- Blood request management with approval  
- Donation reports for admin  
