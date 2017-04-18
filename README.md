# WoWrior

# A Post API implementation for the technical Interview assignment of WoWrior Innovation Pvt Ltd.

POST API: User registration
Fields: Name, Age, Gender, Address(Locality, City, State, Country)
First check Address in Location table if not found insert Address into DB and generate a random place ID
Create user in User table and attach place ID with same.
If Address found, fetch Place ID and attach with user in User table.
 
