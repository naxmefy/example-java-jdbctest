package me.nax.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class JDBC {
	private static final Logger logger = LogManager.getLogger(JDBC.class);
	
	public static Map<String, Boolean> areReachable(String ...urls) {
		Map<String, Boolean> results = new HashMap<>();
		for(String url : urls) {
			results.put(url, isReachable(url));
		}
		return results;
	}
	
	public static boolean isReachable(String url) {
		try {
			Connection conn = DriverManager.getConnection(url);
			logger.info(String.format("%s is reachable (%s)", url, conn));
			return true;
		} catch (SQLException e) {
			logger.error(String.format("%s isn't reachable", url), e);
			System.err.println(String.format("\n%s: %s isn't reachable", e.getMessage().trim(), url));
			e.printStackTrace();
		}
		return false;
	}
}
