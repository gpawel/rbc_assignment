rem %1 is the <environment name>  in  <root>/resources/env/<environment name>
rem %2 is TestNG suite xml file to run tests from.
C:\OpenJDK\jdk-11\bin\java -Dlog4j.configurationFile=log4j2.xml -Denv=%1 -jar bin/pg-rbc-assignment.jar %2
