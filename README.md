# RestAssured_Acquis ---- API Testing Framework to test https://reqres.in/

Tested APIs --

* GET User
* POST User
* DELETE User

Tools Used for testing --

* RestAssured Framework
* GSON
* TestNG Framework

How to execute --

This is a maven project and its enabled to handle configurations and data source for following environments

* DEV
* INT
* PREPROD
* PROD

The test can be triggered with the following command

mvn clean test -Denv=[ENVIRONMENT]


Folder structure --

* API Test and Library : /test/java/tests
* POJO Classes : /main/java/datamodel
* API Method List : /main/java/core/APIMethods
* Data Source : /test/java/data
