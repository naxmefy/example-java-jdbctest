package me.nax.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Before using this class make sure that required JDBC drivers are loaded.
 */
public class JDBC {
	private static final Logger logger = LogManager.getLogger(JDBC.class);
	
	/**
	 * Tests each jdbc url and returns a map with results.
	 * 
	 * @param urls Each string should be a jdbc url.
	 * @return A Map contains urls as keys and a boolean value to indicate the reachability. 
	 */
	public static Map<String, Boolean> areReachable(String ...urls) {
		Map<String, Boolean> results = new HashMap<String, Boolean>();
		for(String url : urls) {
			results.put(url, isReachable(url));
		}
		return results;
	}
	
	/**
	 * Tests a single jdbc url and returns a boolean to indicate the reachability.
	 * @param url A string that should be a jdbc url.
	 * @return A boolean value to indicate the reachability. 
	 */
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
