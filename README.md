<h1 align="center">Java Bookstore with JSP MVC Architecture </h1>

## Introduction

Welcome to the Java Bookstore project! This web application is built using Java Server Pages (JSP) and follows the Model-View-Controller (MVC) architecture. The project aims to provide a user-friendly bookstore where users can browse, search, and purchase books online. The MVC pattern ensures a clear separation of concerns, making the codebase modular and maintainable.

## Project Overview

The Java Bookstore implements a robust MVC structure:

- **Model:** Manages data and business logic. In this case, it handles book information, inventory, and user transactions.
  
- **View:** Represents the user interface. JSP pages are used to dynamically generate HTML content, displaying the bookstore's pages and book details.

- **Controller:** Handles user input and communicates with the model and view. It ensures the flow of data between the user and the application.

## Diagram 

<!--Insert Diagram or GIF here (if applicable) to provide a visual representation of the MVC architecture and the flow of data in the Java Bookstore. !-->
![image](https://github.com/ILoveThrumbos/MVC_Online_Book_Store/assets/139453924/b116693e-b38e-48de-bcf0-c011bf9c29fb)



## Installation and Usage Instructions

### Prerequisites

Before getting started, ensure you have the following installed:

- [Java Development Kit (JDK) - 1.8](https://www.oracle.com/java/technologies/downloads/#java8)
- [GlassFish Server 4.1.1](https://javaee.github.io/glassfish/download) 
- [NetBeans Version 8.2 or later](https://netbeans.apache.org/front/main/download/index.html)



### Steps to Run the Project

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/ILoveThrumbos/JSP_Online_Book_Shop.git
2. Launch NetBeans IDE.
   Choose "Open Project" and select the cloned java-bookstore project.
3. In NetBeans, go to the "Services" tab.
   Right-click on "Servers" and choose "Add Server."
   Select "GlassFish Server" and provide the path to your installed GlassFish Server 4.1.1.
4. Open the database configuration based on your Java DB (or MYSQL) properties and setup in the service windows explorer.
   Deploy the project to the GlassFish Server.
   
   *EXAMPLE OF STEP 4*
   
   ![image](https://github.com/ILoveThrumbos/MVC_Online_Book_Store/assets/139453924/a6ef33f7-10c5-499e-a434-ecc69916113e)
5. Create a new database connection with the provided sql queries in appendix in the java DB.

   *EXAMPLE OF STEP 5*

   ![image](https://github.com/ILoveThrumbos/MVC_Online_Book_Store/assets/139453924/06f26b40-d9d5-45b1-99ed-bf49ab1c6342)

7. Modify the AdmitBookStoreDAO.java 'con = DriverManager.getConnection("jdbc:derby://localhost:1527/Books_DB",
                                         "username", "password");' parameters to match your database connection.
   
   *EXAMPLE STEP 6*

   ![image](https://github.com/ILoveThrumbos/MVC_Online_Book_Store/assets/139453924/5439f331-420e-4134-b8d3-d34ba8309257)

   
9. Right-click on the project in NetBeans and choose "Build."
10. Open your web browser and navigate to http://localhost:8080/java-bookstore.
   Explore the bookstore, search for books, and make purchases.

### Known Issues
   - No checkout system created to validate credentails and credit card.
   - Does not contain any error messages/handling with incorrect input
   - No database to store user credentials. Standalone store with products.

## Support and Contributions
If you encounter any issues or have suggestions for improvement, please create an issue on the GitHub repository. Contributions are welcome, so feel free to submit pull requests to enhance the functionality or fix bugs.

Thank you for using the Java Bookstore! Happy reading!


## Appendix
CREATE TABLE IF NOT EXISTS TBooks (
    ISBN VARCHAR(13) PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    AUTHOR VARCHAR(255) NOT NULL,
    PRICE DECIMAL(10, 2) NOT NULL
);

INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE)
	VALUES ('1112223334', 'Web Design', 'Niederst', 86.78);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('1232345433', 'Advanced Java 2', 'Berg', 99.7);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('3456566778', 'Core Java', 'Horstmann', 77.9);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('6689655553', 'XML and Java', 'Chase', 65.45);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('9876788907', 'Java Cookbook', 'Darwin', 87.67);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('7654098767', 'Java Databases', 'Carnell', 102.5);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('7654434222', 'Building Java Enterprise Systems with J2EE', 'Perrone', 75.0);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('5439878677', 'Engineering Distributed objects', 'Emmerich', 120.0);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('5434443445', 'Java Server Programming', 'Baker', 135.75);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('5090988877', 'Enterprise JavaBeans by Example', 'Friedrich', 56.8);
INSERT INTO USER1.TBOOKS (ISBN, TITLE, AUTHOR, PRICE) 
	VALUES ('7776566545', 'Developing Java Servlets', 'Goodwill', 77.8);
