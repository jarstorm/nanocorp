## Description
This repo consist in two differente projects:
- A backend using Spring Boot to act as a server
- A frontend client created in React

## Data.json
I changed data.json because I cannot read data from Java.

- In "Test Ad 1" creatives was inside taget_audiance. I place outside ti, close to insights
- Change KeyWords for keyWords because I cannot read with capital letter in Java

## Backend
The project uses Spring Boot as the main framework for the app.

It's construcvted using Maven as dependency manager.

It uses MySQL as database to store daat read from data.json file.

To launch it you only need to Run As Java Application the MainAppConfig file. It will create a server in http://localhost:8090

Inside application.properties file you could change MySQL connection parameters.


## Frontend
The frontend uses React and Redux as main technologies.

To install it please execute ```yarn install```

To run it please execute ```yarn start```

Using webpack you could create a local server to launch the application.
