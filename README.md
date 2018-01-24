# me.nax.jdbctest

test jdbc url is reachable

## installation

no upload to maven centry yet...

## usage

```java
boolean memoryIsReachable = JDBC.isReachable("jdbc:h2:mem:test");
boolean oracleIsReachable = JDBC.isReachable("jdbc:oracle:thin:@localhost:1521:XE");

Map<String, Boolean> reaches = JDBC.areReachable("jdbc:h2:mem:test", "jdbc:oracle:thin:@localhost:1521:XE");
```