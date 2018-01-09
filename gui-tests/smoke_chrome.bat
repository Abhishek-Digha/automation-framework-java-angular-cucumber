call mvn clean
call mvn test -Dbrowser=chrome -Druntags=@Smoke -Drun.on.browserstack.grid.local=local

