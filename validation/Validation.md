# Topcoder - Online Review Components - Move to Maven Validation

## Requirements
- JDK >=1.5
- Maven 3.5
- git 2+
- docker-ce 17+
- docker-compose 1.17+

## Getting tc-components-dev submission [*THIS IS IMPORTANT*]
Get all tc-components-dev here:
[https://drive.google.com/file/d/1VDyHWelH7bo2MWHb_2EfN0txqzmu_rUq/view?usp=sharing](https://drive.google.com/file/d/1VDyHWelH7bo2MWHb_2EfN0txqzmu_rUq/view?usp=sharing)

Download it and then extract tc-components-dev.zip to `<submission>`directory.

## Getting Previous Code
tc-online-review (will be used for verification)
```
git clone https://github.com/topcoder-platform/tc-online-review.git
cd tc-online-review
git checkout dev
git submodule init
git submodule update
```

temp-maven-repo. This will be used to simulate private repo. You need to fork this repo on github and clone the fork repo.
[https://github.com/appirio-tech/temp-maven-repo](https://github.com/appirio-tech/temp-maven-repo)
```
git clone <your temp-maven-repo url>
```

## Install Additional Libraries
> NOTE. It's better to delete the downloded lib of group `com.topcoder.internal`
> and `tc-components` on local maven repository see on `~/.m2/repository/com/topcoder/internal` and `~/.m2/repository/tc-components`.
> Just to make sure we'll use the new lib that we'll build.

```
cd <submission>

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=forums -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/forums.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=online_review -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/or.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=job_scheduler -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/job_scheduler.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=core.api -Dversion=4.3.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/core.api.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=security -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/security.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=tcwebcommon -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/tcwebcommon.jar
```

```
cd <or>

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=shared -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/shared/shared.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=catalog -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/shared/catalog.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=tcjive -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/tcs/tcjive.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=tc_id_generator -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/tcs/tc_id_generator.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=jiveforums -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/third_party/jive/jiveforums.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=jivebase -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/third_party/jive/jivebase.jar

mvn install:install-file -DcreateChecksum=true -DgroupId=com.topcoder.internal -DartifactId=security_ejb -Dversion=1.0.0 -DmodelVersion=4.0.0 -Dpackaging=jar -Dfile=lib/tcs/security_ejb/Security.jar

```

## Build and Install Components
```
cd <tc-components-dev>
mvn clean install -Dmaven.test.skip=true
```
Now we have all components in our local maven repo.

## Verification Using Private Repo
Copy group `com.topcider.internal` and `tc-components` to `temp-maven-repo`
then DELETE the one on local maven repo
```
cd <temp-maven-repo>
cp -R ~/.m2/repository/com/topcoder/internal/* com/topcoder/internal/
cp -R ~/.m2/repository/tc-components .

#DON'T FORGET TO DELETE ON LOCAL MAVEN REPO
rm -rf ~/.m2/repository/com/topcoder/internal/* ~/.m2/repository/tc-components

```

Commit the change and push to your github repo
```
git add tc-components/ com/topcoder/internal
git commit -a -m "add tc-components"
git push <your repo id i.e:origin> master
```

Edit file `<submission>/tc-components-dev/pom.xml` change temp-maven-repo url to your github temp-maven-repo.
Change [username] with your github username. For example:
`https://github.com/myusername/temp-maven-repo/raw/master`

Choose one of tc-components. And try to build it. For this example: let's use `autopilot`. It uses much components as dependencies.

```
cd <submission>/tc-components-dev/autopilot
mvn clean package -Dmaven.test.skip=true
```
You'll see some dependencies will be downloaded from your temp-maven-repo on github.

## Verification Running Online Review with Our New Build
Copy the our new build jar to tc-online-review/lib/tcs. Use the provided script.
```
cd <submission>/tc-components-dev
sh copy_to_lib.sh <path-to>/tc-online-review/lib/tcs

#For windows user:
copy_to_lib.bat <path-to>\tc-online-review\lib\tcs
```

Edit ```<submission>/env.sh``` to meet with your environment  . Then build and run online review.
```
cd <submission>
source env.sh
docker-compose up build-online-review
docker-compose up -d run-online-review tc-direct
```

Add ```<docker ip/docker-machine ip> cockpit.cloud.topcoder.com``` to your ```hosts``` file

1. Create challenge on direct-app
	[https://cockpit.cloud.topcoder.com/direct/launch/home](https://cockpit.cloud.topcoder.com/direct/launch/home)
	Login as heffan:password
	Fill all required fields then save as draft.

2. Open Project Detail page on Open Online review:
	Login as heffan:password
[http://cockpit.cloud.topcoder.com/review/actions/ViewProjectDetails?pid=30005520](http://cockpit.cloud.topcoder.com/review/actions/ViewProjectDetails?pid=30005520)

	Note. 30005520 should be changed to challenge id that you've created before


NOTE.
No Tokenize task on components level required.
