
This is a full stack java shopping cart demo application comprised of two projects (front
end using 
angular/bootstrap) and a backend project (Java EE/Spring /Mongo DB app integration) tested in Tomcat 
web container  and JBoss eap6.3 application container).
Together the projects can be used as "turn key" applications, fully configured and runnable as
described below:

1. Frontend end application 

-	it is packaged as a stand alone angular/bootsrap project created based on the angular-seed project and 
following the best practices provided in the Angular tutorial project. 
-	It can be run via "npm start" executed in the frontend folder (similar to the angular-seed project). 
Once it is up and running the angular front end app will communicate with the backend via Restful web services 
(to get the store data (books info) from the database)
-	Also the front end "app" folder contents can be copied under the webapp folder of the Java EE/Spring project
 if it is required to have a single application (front end + backend)
 
2. Backend application

The backend component / project is checked in as an Eclipse project which can be immediately imported and tested 
using <import existing maven project> using the project defined in the “frontend” folder.

The code also contains Restful web service test classes, both for unit testing (using Spring mock test framework) 
and Rest integration testing using “RestAssured” rest testing framework.
