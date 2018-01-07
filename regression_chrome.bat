call mvn clean
call mvn test -Dbrowser=chrome -Drun.on.browserstack.grid.local=local -Dcucumber.Options="--plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm --tags @regression"


