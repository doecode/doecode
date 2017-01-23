package gov.osti.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;



/**
 * Utility class to perform tasks that are repeated across multiple servlets and
 * their helpers
 * 
 * @author welscht
 */

public class ServletUtil {

	protected static final Logger log = Logger.getLogger(ServletUtil.class.getName());


	/**
	 * Takes a BufferedReader and parses it line by line with a StringBuilder.
	 * Returns the StringBuilder's String.
	 * 
	 * @param reader
	 *            BufferedReader passed in, typically from Request in POSTs.
	 * @return String of the BufferedReader's data
	 * @throws IOException
	 */
	public static String parseReader(BufferedReader reader) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
		}
		return stringBuilder.toString();

	}

	/**
	 * Takes a BufferedReader and parses it line by line with a StringBuilder.
	 * Returns the StringBuilder's String. Then closes the BufferedReader in a
	 * finally block.
	 * 
	 * @param reader
	 *            BufferedReader passed in, typically from Request in POSTs.
	 * @return String of the BufferedReader's data
	 * @throws IOException
	 */
	public static String parseReaderAndClose(BufferedReader reader) throws IOException {

		try {
			return parseReader(reader);
		} finally {
			reader.close();
		}
	}

	/**
	 * Takes a PrintWriter and output String and writes the output String to the
	 * PrintWriter's stream. Closes the PrintWriter in a finally block.
	 * 
	 * @param out
	 *            The PrintWriter passed in, typically from
	 *            Response.getWriter().
	 * @param output
	 *            The String to be written to the PrintWriter's output stream.
	 */
	public static void writeToOutput(PrintWriter out, String output) {
		try {
			out.write(output);

		} catch (Exception e) {
			throw e;

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * Takes a PrintWriter and output String and writes the output String to the
	 * PrintWriter's stream. Flushes the output stream. Closes the PrintWriter
	 * in a finally block.
	 * 
	 * @param out
	 *            The PrintWriter passed in, typically from
	 *            Response.getWriter().
	 * @param output
	 *            The String to be written to the PrintWriter's output stream.
	 */
	public static void writeToOutputAndFlush(PrintWriter out, String output) {
		try {
			out.write(output);
			out.flush();

		} catch (Exception e) {
			throw e;

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * Closes the PreparedStatement, ResultSet, and Connection if they are not
	 * null. If a SQLException is encountered, it is caught and not thrown.
	 * 
	 * @param ps
	 *            - PreparedStatement to be closed if not null
	 * @param rs
	 *            - ResultSet to be closed if not null
	 * @param c
	 *            - Connection to be closed if not null
	 */
	public static void closeDatabaseConnectionsQuietly(PreparedStatement ps, ResultSet rs, Connection c) {
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
