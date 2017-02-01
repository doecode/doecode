package gov.osti.database;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;


public class ConnectionSource {

	private static ConnectionSource connectionSource;
	private static PoolingDataSource<PoolableConnection> pool = null;
	private BasicDataSource dataSource;

	private ConnectionSource() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("tester");
		dataSource.setPassword("localtest");
		dataSource.setUrl("jdbc:mysql://127.0.0.1");

	}

	public static void init(String user, String password, String url) {

		Properties properties = new Properties();
		properties.setProperty("user", user);
		properties.setProperty("password", password);

		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
				new DriverManagerConnectionFactory(url, properties), null);

		GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(
				poolableConnectionFactory, null);
		pool = new PoolingDataSource<>(connectionPool);
	}

	private static ConnectionSource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (connectionSource == null) {
			connectionSource = new ConnectionSource();
			return connectionSource;
		} else {
			return connectionSource;
		}
	}

	public static Connection getConnection() throws SQLException {

		if (pool != null)
			return getPoolableConnection();

		try {
			return ConnectionSource.getInstance().dataSource.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static Connection getPoolableConnection() {
		try {
			return pool.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
