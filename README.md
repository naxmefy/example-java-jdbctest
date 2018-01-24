# me.nax.jdbctest

test jdbc url is reachable

[![Build Status](https://travis-ci.org/naxmefy/me.nax.jdbctest.svg?branch=master)](https://travis-ci.org/naxmefy/me.nax.jdbctest)

## installation

read https://jitpack.io/#jitpack/maven-simple ...

## usage

```java
boolean memoryIsReachable = JDBC.isReachable("jdbc:h2:mem:test");
boolean oracleIsReachable = JDBC.isReachable("jdbc:oracle:thin:@localhost:1521:XE");

Map<String, Boolean> reaches = JDBC.areReachable("jdbc:h2:mem:test", "jdbc:oracle:thin:@localhost:1521:XE");
```