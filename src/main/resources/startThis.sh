cd /Users/yejun/.jenkins/workspace/groovyTest-build
mvn clean package
echo '~~build success~~'
java -jar /Users/yejun/.jenkins/workspace/groovyTest-build/target/groovydemo-0.0.1-SNAPSHOT.jar &
echo '~~start success~~'