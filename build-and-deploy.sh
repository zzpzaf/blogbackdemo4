#!/bin/bash

"/Users/zafeiropoulospanos/.m2/wrapper/dists/apache-maven-3.8.6-bin/1ks0nkde5v1pk9vtc31i9d0lcd/apache-maven-3.8.6/bin/mvn" -DskipTests package -f "/Users/DEV/PROJ/STS4_VSCode_Workspace1/blogbackdemo4/pom.xml"
cp target/blogbackdemo4*.jar ~/DOCKER_SHARE1/net2/backend/api/
