Decrypting Adobe Coldfusion 11 datasource passwords
========================================

With Coldfusion 9 and earlier, it was easy to recover database passwords from the ColdFusion server configuration. This was useful when copying datasources between servers, or when the password has been forgotten or is randomly generated and is needed for another tool.

ColdFusion 11 (10 ?) changed the way passwords were stored, and requires a new method of recovery.


compile
=======
Set CFROOT to the install directory of your ColdFusion server. e.g. export CFROOT=/opt/cf11/cfusion

    javac decryptCf11Dsn.java -classpath $CFROOT/lib/cfusion.jar:XPath4SAX-0.0.1-SNAPSHOT.jar

usage
=====
Set CFROOT to the install directory of your ColdFusion server. e.g. export CFROOT=/opt/cf11/cfusion

Run the compile Java code with the correct classpath.

The arguments are the path to your ColdFusion 11 install, and then the datasource name.

    java -classpath $CFROOT/lib/cf-logging.jar:$CFROOT/lib/log4j-1.2.15.jar:$CFROOT/lib/cfusion.jar:$CFROOT/lib/xercesImpl.jar:XPath4SAX-0.0.1-SNAPSHOT.jar:. decryptCf11Dsn $CFROOT someDataSourceName

You can also lookup the encrypted password in $CFROOT/lib/neo-datasource.xml, then the arguments are the path to your ColdFusion install, a '-p' and then the encrypted string.

    java -classpath $CFROOT/lib/cf-logging.jar:$CFROOT/lib/log4j-1.2.15.jar:$CFROOT/lib/cfusion.jar:$CFROOT/lib/xercesImpl.jar:XPath4SAX-0.0.1-SNAPSHOT.jar:. decryptCf11Dsn $CFROOT -p sdgsdgsdgsdg=

You may need to run this sudo or as root, depending on your server.
