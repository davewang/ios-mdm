AppFuse Modular Spring MVC Archetype (Mobile Device Management) 
--------------------------------------------------------------------------------
If you're reading this then you've created your new project using Maven and
appfuse-basic-spring.  You have only created the shell of an AppFuse Java EE
application.  The project object model (pom) is defined in the file pom.xml.
The application is ready to run as a web application. The pom.xml file is
pre-defined with Hibernate as a persistence model and Spring MVC as the web
framework.

There are two modules in this project. The first is "core" and is meant to 
contain Services and DAOs. The second is "web" and contains any web-related
files. Using this modular archetype is recommended when you're planning on
using "core" in multiple applications, or you plan on having multiple clients
for the same backend.

To get started, complete the following steps:

1. Download and install a MySQL 5.x database from
   http://dev.mysql.com/downloads/mysql/5.0.html#downloads.

2. From the command line, cd into the core directory and run "mvn install".

3. From the command line, cd into the payload directory and run "mvn install".

4. From the command line, cd into the web directory and run "mvn jetty:run".
> before need config https with web/src/main/resources/certs/make_certs.sh to make cert 
> need config push cert with http://www.softhinker.com/in-the-news/iosmdmvendorcsrsigning

5. View the application at http://localhost:8080 or https://localhost:8448

6. More information can be found at:

    http://appfuse.org/display/APF/AppFuse+QuickStart


