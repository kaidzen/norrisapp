#!/bin/bash

cwd=$(pwd)
mkdir $cwd/tomcat
wget http://mirror.vorboss.net/apache/tomcat/tomcat-8/v8.5.23/bin/apache-tomcat-8.5.23.tar.gz
tar -xvf apache-tomcat-8.5.23.tar.gz -C $cwd/tomcat --strip-components=1