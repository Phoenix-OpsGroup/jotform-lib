
## Getting Started ##


### Generate from archetype ###
```
mvn archetype:generate -DarchetypeCatalog=local \
    -DarchetypeGroupId=us.westly -DarchetypeArtifactId=westly-app -DarchetypeVersion=0.0.1 \
    -DgroupId=com.phoenixops -DartifactId=demo -Dversion=1.0-SNAPSHOT
```

### mvn package ###

Creates:
```
    target/${project.artifactId}-${project.version}.jar
    target/${project.artifactId}-${project.version}-jar-with-dependencies.jar
    deploy/bin/${project.artifactId}-${project.version}-bin.tar.gz
    deploy/project/${project.artifactId}-${project.version}-project.tar.gz
    deploy/src/${project.artifactId}-${project.version}-src.tar.gz
```
### Reads configuration XML file and spews contents ###
```
java -jar \
    target/${project.artifactId}-${project.version}-jar-with-dependencies.jar \
    --config config/${project.artifactId}-config.xml
```


### Recommended Usage ###
```java
 App.run()

    // Entry point to begin coding.

  App.validateCommandLineOptions()

    // Add other command line options you require
```

### SonarQube ###
* SonarQube Server requires this plugin in the extensions/plugins directory:
** http://docs.sonarqube.org/display/SONARQUBE45/Cobertura+Plugin

Usage:
* Compiles, builds Cobertura files, pushes to SonarQube
```
mvn site sonar:sonar
```

### IntelliJ IDEA ###
* https://plugins.jetbrains.com/search/index?pr=idea&search=SonarQube
** SonarQube Community Plugin
*** Connect IntelliJ IDEA to SonarQube Server
** SonarLint
*** Code quality feedback
