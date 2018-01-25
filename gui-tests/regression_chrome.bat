call mvn clean
call mvn test -Dbrowser=chrome -Druntags=@Regression
cd target
allure serve

