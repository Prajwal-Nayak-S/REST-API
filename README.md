
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



URLs
- http://localhost:8080/hello-world
- http://localhost:8080/hello-world-bean

```
{
  "message": "Hello World"
}
```

URL
- http://localhost:8080/hello-world/path-variable/Prajwal

```
{
  "message": "Hello World, Prajwal"
}
```
### Resources and URI Mappings

- Retrieve all Users      - GET  /users
- Create a User           - POST /users
- Retrieve one User       - GET  /users/{id} -> /users/1   
- Delete a User           - DELETE /users/{id} -> /users/1

- Retrieve all posts for a User - GET /users/{id}/posts 
- Create a posts for a User - POST /users/{id}/posts
- Retrieve details of a post - GET /users/{id}/posts/{post_id}




 Implementing GET Methods for User Resource

### GET http://localhost:8080/users
```json
[
    {
 "id": 1,
 "name": "Adam",
 "birthdate": "1995-05-25"
},
{
 "id": 2,
 "name": "Eve",
 "birthdate": "2000-05-25"
},
{
 "id": 3,
 "name": "Jim",
 "birthdate": "2005-05-25"
}
]

```
### GET http://localhost:8080/users/1
```json
{
 "name": "Adam",
 "birthdate": "1995-05-25",
 "_links": {
 "all-users": {
 "href": "http://localhost:8080/users"
}
}
   
}

```
## Post Method
### POST http://localhost:8080/users
```json
{
    "name": "Prajwal",
    "birthdate": "2000-07-19"
}
```
## Posting through talent-api-tester
  
![Screenshot 2025-05-25 170328](https://github.com/user-attachments/assets/4ddb11b5-0575-4f55-a057-61339e593783)

## In Response
```
Response Status : 201
Response Header => Location: http://localhost:8080/users/4

```
![Screenshot 2025-05-25 171117](https://github.com/user-attachments/assets/ddd2a561-17f6-4cdd-9431-8c2b64dfb095)

## After Posting

![Screenshot 2025-05-25 170632](https://github.com/user-attachments/assets/62706655-b4fd-4329-9eb5-5d854d807c2b)

### GET http://localhost:8080/users/1000
- Get request to a non existing resource. 
- The response shows a Customized Message Structure
```json
{
    "timestamp": "2090-08-19T13:28:16.777397",
    "message": "id:1000",
    "details": "uri=/users/1000"
}
```
