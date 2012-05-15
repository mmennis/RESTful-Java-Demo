#### RESTful Java Services Demo
This project is a demo java application for Jersey based java JAX-RS services.
The demonstration is for use in simepl client applications for test purposes.

Once deployed the following services are supported
/services/hello/hello/{name}   -  returns simple string with greeting
/services/petclinic/sleep/{sleep-time}   -  returns simple string after executing SQL sleep in mysql instance.
/services/petclinic/owners/    -   returns a json list of all owners in the database (see setup)
/services/json/music/list     -   returns a json list of tracks
/services/json/music/get      -   returns a single track as a json hash object

#### Setup
Create a mysql database and use the mysqldump file in src/main/resources to create the tables and populate them.
Update the context.xml file with the correct settings for the PetclinicDB.
Assuming maven is installed run `mvn package`
Deploy the NRServices.war to a Tomcat or Jetty server and start up.

Test the server using http://<hostname>:<port>/NRServices/services/hello/hello/<your-name> in a browser