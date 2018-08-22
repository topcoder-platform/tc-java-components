# TC-COMPONENTS

## Requirements
- JDK >=1.5
- Maven 3.5

## Configuring Repository
Edit `pom.xml` add topcoder internal private repository inside `repositories`
```
<repository>
	<id>{repo's name}</id>
	<url>{url}</url>
	<snapshots>
	<enabled>true</enabled>
	<updatePolicy>always</updatePolicy>
	</snapshots>
</repository>
```

## Build All Modules
```
mvn clean package -Dmaven.test.skip=true
```

## Install All Modules to Local Maven Repository
```
mvn clean install -Dmaven.test.skip=true
```

## Build Individual Module
```
cd <module directory>
mvn clean package -Dmaven.test.skip=true
```
