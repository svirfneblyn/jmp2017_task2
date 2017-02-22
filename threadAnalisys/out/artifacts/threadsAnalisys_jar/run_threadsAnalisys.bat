java -jar  -Xmx2m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d: -agentlib:jdwp=transport=dt_socket,address=localhost:9009,server=y,suspend=n threadsAnalisys.jar

