## Description
This repo consist in two differente projects:
- A backend using Spring Boot
- A frontend client created in React

I created also some methods to allow the user log in the system and using web services using JWT.

## Data.json
I changed data.json because I cannot read data from Java.

- In "Test Ad 1" creatives was inside taget_audiance. I place outside ti, close to insights
- Change KeyWords for keyWords because I cannot read with capital letter in Java

## Backend
The project uses Spring Boot as the main framework for the app.

It's constructed using Maven as dependency manager.

It uses MySQL as database to store data read from data.json file.

### Configuration
Inside application.properties file you could change MySQL connection parameters and also server port.

### Launch in development mode
To launch it in development mode you only need to Run As Java Application the MainAppConfig file. It will create a server in http://localhost:8090

### Code
It uses Spring Security to manage JWT authentication from frontend client. You could see more inside WebSecurityConfig class.

Every time the aplication is launched the data from data.json file is reset and stored again in database. See more in DateReader and DataCreator classes.

There is only a REST controller to manage campaigns info. See more inside CampaignController

### Production mode
To construct the project for production you could use ```mvn clean pckage``` This will need an instance running because of testing. If you don't have any running instance you could skipe tests using ```mvn clean package -Dmaven.test.skip```

You could run your production project using ```java -jar project-1.0.jar```


## Frontend
The frontend uses React and Redux as main technologies. It uses webpack as a local server to launch the application.

### Configuration
Inside config.js file you could configure server address.

### How to launch in develpment mode
To install it please execute ```yarn install```

After install, to run it please execute ```yarn start```

To log in the application please see Valid user section.

### Code
Inside App.js you could see the entry point of the app. From this you could follow very easy the rest of classes

### How to launch in production mode
I'm so sorry but I have no time to configure webpack in production mode to create every resource needed.

### Known issues
I wanted to uses eslint to create a more beautiful and robust code but I have no idea why is not working with this version of webpack. And if I changed the version of webpack nothing was working so I decided to skip this task for now.

## Valid user
Right now only test/test user is a valid one.

If you want to create more you could create it inserting inside NC_USER table the user and BCrypt password.

## Testing
The application is not fully tested. I just cerated some of them to show you that I know how to do it.
