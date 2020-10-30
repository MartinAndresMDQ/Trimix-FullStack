# Person API - Spring MVC, MySQL, Hibernate Rest API + Angular 10

Build Restful CRUD API for a simple person-Manage application using Spring MVC, Mysql and Hibernate.

## Requirements

1. Java - 1.8

2. Maven - 3.5.1

3. MySQL

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/MartinAndresMDQ/Trimix-FullStack.git
```

**2. Create Mysql database**

```bash
create database trimixdb
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/db.properties`

+ change `mysql.user` and `mysql.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
cd Trimix-Backend
mvn package
```

A new WAR file will be generated at `project/target/trimix-Backend-0.0.1-SNAPSHOT.war`, just copy and deploy to your Tomcat.

The app will start running at <http://localhost:8080/trimix-Backend/>.



# Persona App

Build a Simple Angular 10 CRUD application using http

## Steps to Setup

**1. Clone the application**

```bash
cd Trimix-Frontend
```

**2. Intall Angular CLI globally**

```bash
npm install -g @angular/cli
```

**3. Intall dependencies/npm modules**

Go to the project directory and execute the following command from the terminal

```bash
intall npm
```

**4. Build and run the app**

```bash
ng serve --open
```

The app will open in the default browser with <http://localhost:4200/>.