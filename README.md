# Registry Lib
[![](readmefiles/maven-registry-lib.svg)](https://repo.maven.apache.org/maven2/io/github/codecraftplugin/)

## Installation

In build.gradle

```groovy
dependencies
    .......
    modImplementation "io.github.codecraftplugin:registry-lib:${project.registery_lib_version}"

}
```
In the gradle.properties of your project
```properties
registery_lib_version = 1.19.2-1.0.1
```
in the repositories section of build.gradle
```groovy
repositories {
    .....

    mavenCentral()
}
```
## License
This Library is under MIT License



