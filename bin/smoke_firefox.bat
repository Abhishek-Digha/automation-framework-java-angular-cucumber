call mvn clean
call mvn test -Dbrowser=firefox -Druntags=@Smoke -Drun.on.browserstack.grid.local=local -Dcucumber.Options="--plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm"