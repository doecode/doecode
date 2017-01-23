package gov.osti.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	protected static void closeConnectionsQuietly(PreparedStatement ps, ResultSet rs, Connection c) {
		try {
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
			if (c != null)
				c.close();
		} catch (SQLException se) {

		}
	}
}
