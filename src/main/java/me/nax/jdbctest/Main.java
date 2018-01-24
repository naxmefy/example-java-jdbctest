package me.nax.jdbctest;

import java.util.Map;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		for (Map.Entry<String, Boolean> entry : JDBC.areReachable(args).entrySet()) {
			System.out.println(String.format("Entry %s %s reachable", entry.getKey(),
					Boolean.TRUE.equals(entry.getValue()) ? "is" : "isn't"));
		}
	}
}
