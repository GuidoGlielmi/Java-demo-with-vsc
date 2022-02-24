> ## How to create a Spring Boot project from scratch in VSC

- Download "Java Extension Pack"
- Download "Spring Boot Extension Pack". This is an a alternative way to [Spring Initializr](https://start.spring.io)
- Then, from the command pallet, execute "Spring Initializr: Create a Maven Project", and proceed to the following steps:
  - Select the last stable version (usually appears first).
  - Select the Java language.
  - Enter the Group ID.
  - Enter the artifact id (project's name).
    A maven artifact is a structure that supports any Java project.
    This process has several parts:
    - validate : Checks if the project has the correct structure and the files are where they are supposed to be.
    - compile : Compiles the code.
    - test: Responsible for passing unit test, something very important that Maven reinforces in someway.
    - package: Remember that compiling code and generating the .class files is very different to generating a reusable package.
    - install: Installs a new Maven artifact in our Maven repository.
    - deploy: So the artifact can be utilized for other developers, which installs a new remote repository other users will have access (Nexus o Artifactory).
  - Select the package.
    Jar is a file format based on the popular ZIP file format and is used
    for aggregating many files into one. Although JAR can be used as a general
    archiving tool, the primary motivation for its development was so that Java
    applets and their requisite components (.class files, images and sounds) can
    be downloaded to a browser in a single HTTP transaction, rather than opening
    a new connection for each piece. This greatly improves the speed with which
    an applet can be loaded onto a web page and begin functioning. Additionally,
    individual entries in a JAR file may be digitally signed by the applet author
    to authenticate their origin.  
    _JAR_ is:
    - the only archive format that is cross-platform
    - the only format that handles audio and image files as well as class files
    - backward-compatible with existing applet code
    - an open standard, fully extendable, and written in java
    - the preferred way to bundle the pieces of a java applet
  - Select the preferred Java version.
  - Select the dependencies. At least "Spring web" and "SpringBoot Dev Tools".
  - Select destination folder for the project.

##

To use servlets add the following dependencies:

```
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>jstl</artifactId>
</dependency>
<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
  <scope>provided</scope>
</dependency>
```

Create a this folder structure:

```
 main/webapp/WEB-INF/views
```

And add the following lines to the applications.properties:

```
spring.mvc.view.prefix: /WEB-INF/views/
spring.mvc.view.suffix: .jsp
```

> ## _NOTES_
>
> It may be necessary to look for the jdk by inputting (_on windows_) in the powershell:
>
> `dir /b /s java.exe`
>
> And paste the outputted directory, (without entering the _bin_ folder and _escaping backslashes_) as the value for the "java.jdt.ls.java.home" property in the _settings.json_ file. This is the same as setting an environment variable _JAVA_HOME_ in the OS.
>
> ##
>
> Useful links:  
> http://www.lordofthejars.com/2011/09/questa-di-marinella-e-la-storia-vera.html  
> https://dev.to/alexmercedcoder/create-java-spring-api-with-vscode-postgres-0-to-deploy-142  
> https://www.mytroubleshooting.com/2018/06/spring-boot-mvc-jsp-visual-studio-code.html?m=1  
