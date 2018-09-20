cd /Users/yejun/.jenkins/workspace/groovyTest-build
mvn clean -Dmaven.test.skip=true package
echo '~~build success~~'
BUILD_ID=dontKillMe java -jar /Users/yejun/.jenkins/workspace/groovyTest-build/target/groovydemo-0.0.1-SNAPSHOT.jar &
echo '~~start success~~'