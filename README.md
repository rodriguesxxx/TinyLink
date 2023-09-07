# TinyLink
A simple and fast link shortener api


# Docs
Project documentation, development report, challenges overcome and perspective for the future.

### Requirements
---
- #### Java 20
### Clone Application
---
    git clone https://github.com/daniel-rodrigues1089/TinyLink

### config Application Database
---
    cd TinyLink/api/src/resources
    
    //Open file application.properties


configure your database information

### Run Application
---
    cd ..

    cd java/br/com/tinylink/api

    java ApiApplication.java



## Endpoints
### We have 2 endpoints:

- http://localhost:8080/tinylink/{code} (GET)

    This endpoint redirects to the shortened link
- http://localhost:8080/tinylink (POST)
    
    This endpoint receives a json containing the url

    ```json
        "url":"https://https://daniel-rodrigues.onrender.com/"
    ```

    return example: http://localhost:8080/123456


# Real example of use


# Beyond the code

Throughout the development, he acquires a lot of experience with spring boot, and I was able to contemplate how powerful it is.
I intend to continue this project, creating a web interface. For ordinary users to use;
I am very satisfied with the result and ready for new challenges.
