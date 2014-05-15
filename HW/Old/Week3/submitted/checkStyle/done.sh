 #!/bin/bash  
java -jar checkstyle-5.6-all.jar -c cs1331-checkstyle.xml ../*.java
java -jar checkstyle-5.6-all.jar -c cs1331-checkstyle.xml ../*.java | wc -l
java -jar checkstyle-5.6-all.jar -c cs1331-checkstyle.xml ../*.java | grep -cEv "(Starting audit...|Audit done)"