call mvn clean
call mvn test -Dbrowser=chrome -Druntags=@Smoke -Drun.on.browserstack.grid.local=local -Dcucumber.Options="--plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm"

