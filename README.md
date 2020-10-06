# AutomationTesting_PHPtravels
This is an automation testing task for PHP travels wbesite Registeration and login using Selenium Firefox WebDriver.

-[Pages](#Pages)
-[Tests](#Tests)
-[Data Generation](#Data)
-[Output Results of Reports](#Output)


### Pages
The Web pages classes for login, register, and account inherits the Page Object Model Design Pattern.

### Tests
The tests are done for the Web pages respecteviley which all inherits the base SetupTest .

### Data
Test data is separated from the code, it is imported by just its test case name using using APACHE poi from excel and passed as paramaters to the data provider annotation which passes it to the test case.

### Output
Reports Are generated indicationg failures and passes witsh screenshots for both via Extent Reports in two separte folders for Resgiter and login outputs respectively. An assertion error is thrown for testNG for notification in every error.

# Prerequisites
- JDK 15
- Firefox Webdriver
-Eclipse or IntelliJ IDE

# Built With
- Selenium WebDriver
- TestNG
- Apache poi
- Extent Reports 


