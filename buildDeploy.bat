rmdir D:\tomcat7\webapps\whouse /s /q
del D:\tomcat7\webapps\whouse.war
copy D:\WhareHouse\target\whouse.war D:\tomcat7\webapps\
cd D:\tomcat7\bin\
catalina.bat run