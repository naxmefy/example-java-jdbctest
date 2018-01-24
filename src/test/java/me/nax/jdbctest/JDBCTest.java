package me.nax.jdbctest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class JDBCTest {
	@Test
	public void testIsReachable() {
		assertTrue(JDBC.isReachable("jdbc:h2:mem:test"));
		assertFalse(JDBC.isReachable("jdbc:oracle:thin:@localhost:1521:XE"));
	}

	@Test
	public void testAreReachable() {
		Map<String, Boolean> reaches = JDBC.areReachable("jdbc:h2:mem:test", "jdbc:oracle:thin:@localhost:1521:XE");

		assertEquals(Boolean.TRUE, reaches.get("jdbc:h2:mem:test"));
		assertEquals(Boolean.FALSE, reaches.get("jdbc:oracle:thin:@localhost:1521:XE"));
	}
}
