#Community Service Sign up
-------------------------------------

###Create a single form which will allow a township worker to enter information about those that have signed up to volunteer in the community. The form should allow the township user to submit a group of volunteers at a time. Each group will consist of a group name, volunteer date and a list of individuals. Your application should collect the individual's full name (First, Last) and address (Street, City, State, Zip). The group does not have a maximum size but must contain at least one individual. When the minimal requirements are met the submit group button should become enabled allowing for the user to submit the group. The request should be sent to a backend REST endpoint. The REST endpoint should write the received data to a log file. The endpoint should return a 200 status and a message saying “Saved Successful”. Once the message is received on the client the form should clear.


###Technical Approach

###Step 1.

####Open Eclipse and Create Dynamic Web Project : Communityservicesignup Select Use default location folder checkbox. Target Runtime as Dynamic Web Module version as 3.1 Configuration as Default Configuration, Click on Finish

###Step 2.

####Convert Project to Maven Project to add all required Spring MVC dependencies to project.

####Steps: Right click on project -> Configure -> Convert to Maven project, immediately Right click on the project - communityservicesignup and select > Maven > Update Project to get rid of the errors. 

### Step 3.
Add the dependencies in pom.xml to utilize spring boot capability from the eclipse IDE. Use other dependencies for converting JSON to Java object.

###Step 4.

### Model Class

#### Create the class first that has the least dependencies. - User and ResponseObject


### Data Access Layer
####To decouple the implementation of our DAO, we will create the interface first. The DAO that we will have getUsers for getting list of users, createUser for creating user, updateUser for updating user information, deleteUser for deleting user record and insertBatch for creating table and preset data.


#### Now, create the implementation. On the code below, @Repository tells that the implementation is a DAO class which is similar to @Bean but have a different usage. We are going to use JdbcTemplate for simplicity and will not use any ORM. The implementation class of our DAO is as shown in UserDAOImpl.


### Service Layer
#### First we create a service facade. Then, create the service implementation. The doService method will either do the data creation or fetch the data.



### Create Controller Class.
#### We create a controller a typical controller class that contains method with same PATH mapping but using HTTP method implementation.



## Frontend additions 
###Landing Page

#### First we create the landing page under the static folder named index.html. Add  ng-app="myApp" and ng-view="" where maybe new to you. We will include Bootstrap a CSS library for the look and feel of our page.

#### app.js Setting up our dependencies. Create the file app.js under static/app folder.

#### factory.js - Create the file factory.js under static/app/factory folder. The file will be used for accessing data from our REST endpoint.

#### routes.js - Create the file routes.js under static/app/controller folder. This file is used for the views.

#### controller.js - Create the file userController.js under static/app/controller folder. The controller holds some logic on the display and routing logic.
 

#### users.html - Create the file users.html under static/app/view folder. This HTML file will render the data coming from the server and also contains input for for adding or modifying a user.

#### Application Runner - Application.java
We will create a class named Application which will run creation of data to table in an H2 database and run an embedded servlet container.


#### Run the code - Under the directory where the pom.xml is located run mvn spring-boot:run in the command line. Open the browser and type copy and paste the URL http://localhost:8080/. 
 
#### Note that we have annotated the CommunityServiceSignUpController class with RestController and @RequestMapping("/xyz"). When Spring scans our package, it will recognize this bean as being a Controller bean for processing requests. The @RequestMapping annotation tells Spring that this Controller should process all requests beginning with /xyz in the URL path. 

####Continue to build the Utility classes Entity Beans for being able to cache the information.



### Get User
Add User :http://localhost:8080/getusers
Method : get 
[{
	"id": 1,
	"groupName": "Group1",
	"volunteerDate": "03/02/2017",
	"firstName": "John",
	"lastName": "Doe",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 2,
	"groupName": "Group2",
	"volunteerDate": "03/04/2017",
	"firstName": "Jane",
	"lastName": "Doe",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 3,
	"groupName": "Group3",
	"volunteerDate": "03/05/2017",
	"firstName": "Sarah",
	"lastName": "Bosch",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 4,
	"groupName": "Group4",
	"volunteerDate": "03/06/2017",
	"firstName": "Michael",
	"lastName": "Murray",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 5,
	"groupName": "Group5",
	"volunteerDate": "03/07/2017",
	"firstName": "Barry",
	"lastName": "Coy",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 6,
	"groupName": "Group6",
	"volunteerDate": "03/08/2017",
	"firstName": "Daisy",
	"lastName": "Chen",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 7,
	"groupName": "Group7",
	"volunteerDate": "03/09/2017",
	"firstName": "May",
	"lastName": "Williams",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 8,
	"groupName": "Group8",
	"volunteerDate": "03/10/2017",
	"firstName": "Alex",
	"lastName": "Johnson",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 9,
	"groupName": "Group9",
	"volunteerDate": "03/11/2017",
	"firstName": "Ceasar",
	"lastName": "McCoy",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}, {
	"id": 10,
	"groupName": "Group10",
	"volunteerDate": "03/12/2017",
	"firstName": "Paula",
	"lastName": "May",
	"streetAddress": "someaddress",
	"city": "Exton",
	"state": "19341",
	"zip": null
}]


### Add User

Add User :http://localhost:8080/addusers
Method : Post 
Payload : 
{
 	"id": 11,
 	"groupName": "Group11",
 	"volunteerDate": "03/13/2017",
 	"firstName": "Deb",
 	"lastName": "Daisy",
 	"streetAddress": "someaddress",
 	"city": "Exton",
 	"state": "19341",
 	"zip": null
 }
 
 Response : 
 {
"success": true,
"message": "successful"
}