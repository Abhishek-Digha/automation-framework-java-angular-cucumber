call mvn clean
call mvn test -Dbrowser=chrome -Druntags=@Regression -Dcucumber.Options="--plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm"

