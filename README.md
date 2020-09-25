1. Open solution with IntellIJ IDEA. Right click on Test1 - Run.

2. Solution was created using Selenium Webdriver and Java for automation.
Program structure:
- BaseTest: here we initialize the driver before class (one time only, no matter haw many tests we run) and we close the driver after each test.
- Test1: extends BaseTest and contain test scenario.
- ConfigParameters: here we add any parameters that we use for ease update in the project.
- BasePage: here we declare the driver and wait (to be able to access them from the other pages). Navigate methode is here also.
- Pages: the other pages extends BasePage. Here we declare all elements from page and use them in methods.

3. Prerequisites
Dependencies can be downloaded directly from pom.xml in IntellIJ IDEA.
Chrome driver have to be downloaded on your computer and path have to be updated in ConfigParameters.
