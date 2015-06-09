# Installation Notes 

### Required Software
1. JDK (Java Development Kit) 1.8.0_45
1. Apache Ant(TM) version 1.9.4
1. Apache Tomcat/7.0.56
1. Jenkins 1.605

### Required Libraries
1. chromedriver.exe
1. IEDriverServer.exe
1. log4j-1.2.15.jar
1. mysql-connector-java-5.1.34.jar
1. selenium-java-2.45.0-srcs.jar
1. selenium-java-2.45.0.jar
1. selenium-server-standalone-2.45.0.jar
1. testng-6.9.4.jar

### Pre Configuration

#####Java

- Set the JAVAHOME environment variable to the root location of the JDK installation directory and then add JAVA_HOME/bin to path
	
			C:\> set JAVA_HOME=C:\jdk1.7
			C:\> set PATH=%PATH%;%JAVA_HOME%\bin
						(or)
			Right click "My Computer" -> Advanced -> Environment Variables.
			
> **Note:** Before moving to further configuration, make sure you have a Java environment installed.
						
----------

##### Apache Ant

   - Step 1: Extract 'apache-ant-versionxyz-bin.zip' And place the extracted folder in C drive, preferably C:\Program Files.
   - Step 2: Now we need to SET the path in Environment variables as we do for JAVA. i.e ANT_HOME

> **Note:**  Make sure you download the appropriate formats. As .zip format is recommended format for Windows Operating systems. 
		     It looks like apache-ant-versionxyz-bin.zip.
		    

----------

#####Apache Tomcat

   - Step 1: Extract 'apache-tomcat-versionxyz-bin.zip' And place the extracted folder in C drive, preferably C:\Program Files.
   - Step 2: Now we need to SET the path in Environment variables as we do for JAVA. i.e CATALINA_HOME 

> **Note:**  Make sure you download the appropriate formats. As .zip format is recommended format for Windows Operating systems. 
		     It looks like apache-tomcat-versionxyz-bin.zip.
	 	


**Configuring Project**

