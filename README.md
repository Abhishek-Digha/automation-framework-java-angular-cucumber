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
