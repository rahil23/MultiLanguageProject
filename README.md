
# MultiLanguageProject

A brief description of what this project does and who it's for
This is small Automation library created to test the specific website in multiple language like english , russian or french and run the test in multiple REsolution screen mentioned in proerties file

I have used Maven as a build tool and TESTNG library to use the annotations and run the project as suite  file.
all the dependencies like selenium-java , Extent report , testNG and compiler surefire plugin has been used and mentioend in pom.xml file

To generate a Automation report in graphical representation, we have used ExtentReport library.

For each webpage , I have cerated a seperate WebPage class which is under JAVA package and and one test class which is under test page. The Test class contains 3 test classes.

You have to use below command in terminal to run the project from the project path only. like go to terminal--> go to project path and run the below path

`mvn clean install -Dlang="<language name>" `

Language can be english , russian and french so the sample run command will look like 

`mvn clean install -Dlang="russian" `


How the flow will work?

On running the below command
`mvn clean install -Dlang="russian" `

1. Initially the call will go to pom.xml file which will download all the dependency this file will internally call the testng.xml file
2. testng.xml suite file will call the test class which is mentioned inside <test> tags
3. ON Executing the Test File class, System will run the @BeforeTest annotation method will will initiate the WebDriver instance, launch the browser , open the language specific website in speific dimension and initialise the report file.
4. The tests will run on different resolution as per language specified in properties file.
5. Once the before Method completed, different test methods will run as per mentioned priority and calls the Specific page class to perform the Action.
6. And finally we are doing Assertion to perform validation in Expected and Actual Result.
7. Refresh the Folder structure and The test resport will generate with the name of "AutomationTestReport.html" indide the 'REPORTS' folder.
8. user can also saw sample generated report in REports folder.




## Tech Stack

**Language:** Java

**Automation Tool:** Selenium , TestNG

**Automation IDE:** Eclipse

**Locators** xpath , linkText , id

**Reporting library:** Extent Reports

**other library:** properties file



## Properties Variables

To run this project, you will need to add the following properties file to your 

`english.properties`

`russian.properties`

`french.properties`

#Output
<img width="1792" alt="Screenshot 2024-04-27 at 10 15 42 AM" src="https://github.com/rahil23/MultiLanguageProject/assets/15339271/0d270fdc-5609-4be2-8f41-cc072a05dc6c">
<img width="1792" alt="Screenshot 2024-04-27 at 10 15 27 AM" src="https://github.com/rahil23/MultiLanguageProject/assets/15339271/3e1bc00a-bfad-4d40-a901-648dddf447d7">




