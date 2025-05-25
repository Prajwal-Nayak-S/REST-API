
## URLs

- Basic Resources
  - http://localhost:8080/hello-world
  - http://localhost:8080/hello-world-bean
  - http://localhost:8080/hello-world/path-variable/Prajwal
  - http://localhost:8080/users
  - http://localhost:8080/users/1

- JPA Resources
  - http://localhost:8080/jpa/users
  - http://localhost:8080/jpa/users/1
  - http://localhost:8080/jpa/users/10001/posts
- Filtering
  - http://localhost:8080/filtering
  - http://localhost:8080/filtering-list
- Actuator
  - http://localhost:8080/actuator
- Versioning
  - http://localhost:8080/v1/person
  - http://localhost:8080/v2/person
  - http://localhost:8080/person
     - params=[version=1]
  - http://localhost:8080/person
     - params=[version=2]
  - http://localhost:8080/person/header
     - headers=[X-API-VERSION=1]
  - http://localhost:8080/person/header
     - headers=[X-API-VERSION=2]
  - http://localhost:8080/person/accept
     - produces=[application/vnd.company.app-v1+json]
  - http://localhost:8080/person/accept
  	 - produces=[application/vnd.company.app-v2+json]
- Swagger
  - http://localhost:8080/swagger-ui.html
  - http://localhost:8080/v3/api-docs
    
- HAL Browser
   - http://localhost:8080

 - Internationalization
   - http://localhost:8080/hello-world-internationalized

