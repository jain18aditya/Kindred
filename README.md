# KindredWebTest

## Framework Details:

1. Framework is written in Page Object Model where starting point will be Test runner file from where you will trigger tests written in Cucumber feature files.
2. Feature files are consist of plain English language steps whose equivalent java code is written in step definition.
3. All pages objects and page action are written at one place in Pages package and supporting code to them is written in utils.
4. No Hard coded data is used and reading data from application.properties file.
5. Now you can select which browser to use for execution you need to pass the same in application.properties file.
6. Also added codefor login functionality. As of now Register code is commented as captcha can not be handled by selenium but in sandbox environment we can leverage that code.

##Logging: 

7. Used log4j for gathering logs and log file will be generated at root location. 
8. Used hooks class of Cucumber to improve the logging.

##Screenshot: 

9. Framework takes snapshots if failed at any point in the suit and store it in "lib > screenshots" folder.

##Reports: 

10. A very good Cucumber reports are generated under target folder
11. After integrating with any CI tool it will display a even better report which will have graphs, statistics and tabular reports which can be expended.

##CI: 

12. Can be easily linked with CI tool and if required all values can be passed through CI tool itself instead of properties file which may default values in case you opt not to pass through CI.

# Run requirement:

1. Clone this project
2. Maven will download all the dependencies.
3. Run tests using following methods:
	1. Run as either JUnit from runner file (Right click on TestRunner file present in package com.kindred.runner and run as JUnit) (Using IDE)
	2. Run command prompt and navigate to project folder and run "mvn clean install". (Using command line)
4. Currently reports will be generated at "ProjectFolder/target".

# Covevred Scenarios

1. Register new user.
2. Login with existing user.
3. Verify sidebar
4. Verify search functionalities
5. Search blog
6. Verify header titles.
7. Clicking blog open the details.
8. Verify URL after search 
9. Verify search box is displayed after hitting search through sidebar
10. Verify close button would clear data present in search box
11. Verify search functionality after entering in search box and clicking search button.
12. Verify "No search result" displayed for empty search.
13. Verify putting unicode characters.
14. Verify autosuggest functionality for search.