# spring-demo
Minimalist Spring Rest Demo with Cors enabled, Internal Database and multiple URI terminators for easier connection.

Two entities defined to test parent/child relationships, the repository already has test data.

# To install
Clone the repository and run the gradle project.

# End Points
## Ping
/
## User Account
### GET (Select)
#### select a list
/rest/user_account or /rest/user_account/</p>
#### select a single record
/rest/user_account/{id} or /rest/user_account/{id}/</p>
### POST (Insert)
/rest/user_account or /rest/user_account/</p>
### PUT (Update)
/rest/user_account/{id} or /rest/user_account/{id}/</p>
### DELETE (Delete)
/rest/user_account/{id} or /rest/user_account/{id}/</p>
## User Message
### GET (Select)
#### select a list
/rest/user_message or /rest/user_message/</p>
#### select a single record
/rest/user_message/{id} or /rest/user_message/{id}/</p>
### POST (Insert)
/rest/user_message or /rest/user_message/</p>
### PUT (Update)
/rest/user_message/{id} or /rest/user_message/{id}/</p>
### DELETE (Delete)
/rest/user_message/{id} or /rest/user_message/{id}/</p>
# Examples
## Insert a new User Account:
### Input
curl --header "Content-Type: application/json" -X POST http://192.168.100.19:8080/rest/user_account/ -d '{"firstName":"Billy"}'
### Output
{"id":1,"firstName":"Billy","lastName":null}
## Select an existing User Account:
### Input
curl --header "Content-Type: application/json" http://192.168.100.19:8080/rest/user_account/1/
### Output
{"id":1,"firstName":"Billy","lastName":null}
## Update the User Account: (the id in the object is optional, and if sent ignored)
### Input
curl --header "Content-Type: application/json" -X PUT http://192.168.100.19:8080/rest/user_account/1/ -d '{"firstName":"Billy","lastName":"Elliot"}'
### Output
{"id":1,"firstName":"Billy","lastName":"Elliot"}
## Delete the User Account:
### Input
curl --header "Content-Type: application/json" -X DELETE http://192.168.100.19:8080/rest/user_account/1/
