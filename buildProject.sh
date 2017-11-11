cwd=$(pwd)
export CLASSPATH="javax.servlet-api-3.1.0.jar:$cwd/tomcat/lib/servlet-api.jar:$cwd/src:$cwd/tomcat/webapps/NorrisApp/WEB-INF/classes/"
javac -cp $CLASSPATH $cwd/src/*.java -d $cwd/classes

rm -v $cwd/tomcat/webapps/NorrisApp/META-INF/context.xml
cp -v $cwd/dd/context.xml $cwd/tomcat/webapps/NorrisApp/META-INF

rm -v $cwd/tomcat/webapps/NorrisApp/WEB-INF/web.xml
cp -v $cwd/dd/web.xml $cwd/tomcat/webapps/NorrisApp/WEB-INF

rm -v -R -f $cwd/tomcat/webapps/NorrisApp/WEB-INF/classes

cp -v -R $cwd/classes $cwd/tomcat/webapps/NorrisApp/WEB-INF

./tomcat/bin/shutdown.sh
./tomcat/bin/startup.sh 