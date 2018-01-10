Java Automation framework for Angular applications
==================================
This framework is provided by me to aid you in getting up and running as quickly as possible when testing angular applications.  Everyone by is familiar with protractor however it forces you to rewrite (if you have existing work in java) or learn javascript in order to implement a solution.  This framework provides the option of angular based locators and the ability to wait_for_angular(); to finish loading.  Big credits go to @henrrich and @sergueik for their work on JPageFactory and JProtractor.

Before the documentation I would like to take a small section to talk about what is upcoming with the framework, or to-do if you will:

- Add Browserstack support / capabilities
- Add API testing capabilities utilising Rest-Assured
- Add performance based tests to execute .jmx files or the likes
- Possibly add support using OWASP ZAP, but that is likely a while off yet
- Fixing any outstanding issues

If you would like to contribute to this project or have ideas to improve it, please contribute! grab a fork and fire me a pull request, it would be great for your input.  If using my work here, please contribute with atleast 1 PR.

Powerful features of this framework are:
---------

- Parallel execution of the feature files at either a scenario or feature level
- Shared state between cucumber step definitions using hashmap/dependency injection
- Page Object design pattern, coupled with LoadableComponent
- Support for Chrome and firefox
- Support for local or grid based execution
- Clean, injectable settings
- PageFactory with support for angular based locators
- Aliased random data (if you so desire)
- Reporting with a beautiful UI which really compliments BDD, I have done the hardwork for you with populating the data
- Logging capabilities per forked process using Log4j
- Jenkins ready pipeline script(s) to aid in getting jenkins setup with plugins too
- JProtractor .jar included in the project [it is not on maven central so requires being built from source]
- Localisation support using my LocaleHandler

Technology Stack:
---------

- [Java](https://docs.oracle.com/javase/7/docs/api/) - Static language
- [Selenium WebDriver](http://www.seleniumhq.org/projects/webdriver/) - Libary for interacting with webpage(s)
- [Rest-Assured](http://rest-assured.io/) - A HTTP Client for API request/response testings with a simple DSL
- [JProtractor](https://github.com/sergueik/jProtractor) - Protractor port to java
- [JPageFactory](https://github.com/henrrich/jpagefactory) - Channel based locators with angular capabilities
- [CucumberJVM](https://cucumber.io/docs/reference/jvm) - A BDD tool for writing acceptance tests in plain English.
- [Teymers](https://github.com/temyers/cucumber-jvm-parallel-plugin) - A library used for generating test runners for our forked process execution
- [JFaker](https://github.com/DiUS/java-faker) - A random data generation library ported to java from ruby.
- [Allure](https://github.com/allure-framework/allure-cucumberjvm) - Awesome reporting functionality
- [Spring](https://spring.io/) - Super useful dependency injection
- [Jenkins](https://jenkins-ci.org/) - Used for build management etc
- [Maven](https://maven.apache.org/) - Software project management tool (Build, dependencies, execution etc!)
- [Geckodriver](https://github.com/mozilla/geckodriver/releases) - Firefox Driver
- [Selenium Grid](http://www.seleniumhq.org/projects/grid/) - Distributed test execution, check out `zalenium` too, it's cool!

Getting Started:
---------

1. Download and install maven -> `mvn` in command line should not return unknown command
2. Download and install the java JDK
3. Clone the project: `https://github.com/symonk/Auto-angular.git`
4. Start running tests using the .bat files in the project directory
5. Modify the code to meet your needs and happy testing!
6. Please contribute/fork if you find it useful!
7. Mess around with jenkins :x

Useful Information:
---------

- The framework settings reside in `src/test/resources/framework.properties` you can build and modify these, then check out the SpringConfiguration class
- The Driver class extends `EventFiringWebDriver`
- NGWebDriver is a must for angular, when you need to wait for angular just `getDriver().waitForAngular();` which is part of the AbstractBasePageObject class
- Standard page object pattern applies, see my example as a reference
- Shared step definition state exists by adding to the HashMap `CucumberWorld` class which is auto injected into the AbstractBaseStepDefinition class

Happy testing, a word of warning tho.  be careful when updating selenium versions etc because you run the risk of JProtractor possibly not working, it is currently being moved onto maven central but is not quite there yet.

If you have any questions, I am happy to help! find me:

- Jackofspaces@gmail.com
- https://testersio.slack.com @simonkay
