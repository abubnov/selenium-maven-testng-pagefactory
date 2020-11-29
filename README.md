# selenium-maven-testng-pagefactory
This is demo project how to test  Google page with Selenium-Maven-TestNG-PageFactory-Java framework


This maven templates is used for Selenium 3 and has the latest dependencies on November 2020
 


## How to run with Maven



*	Download the zip or clone the Git repository.

*	Unzip the zip file (if you downloaded one).

* 	Update chromedriver in src\test\resources\webdrivers\ folder according your browser version.
Note: ChromeDriver 87 version is used by default


*	Open Command Prompt and Change directory (cd) to folder containing pom.xml.

```
	cd selenium-maven-testng-pagefactory

```

* 	You can use the command bellow to running tests from command line 

#### Run all the unit test classes.

```

	mvn clean verify test 


```
#### Run a single test class.

```

 mvn -Dtest=ResultPageTest test

```


