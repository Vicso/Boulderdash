package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class level extends AbstractDAO {
	
	/** The sql example by id. */
    private static String sqlExampleById   = "{call getLevel(?)}";

	/**
	 * constructor
	 */
	public level(){
		
	}

	/**
	 * Call the a statement who charge the level ask and return the correct level
	 * @param name
	 * 		Name of the level want to be call
	 * @return level who was chose
	 * @throws SQLException
	 * 		throws a SQL Exception
	 */
	public static String getLevel(final String name) throws SQLException {
	      final CallableStatement callStatement = prepareCall(sqlExampleById);
	      callStatement.setString(1, name);
	      String level = "";
	      if (callStatement.execute()) {
	          final ResultSet result = callStatement.getResultSet();
	          	if (result.first()) {
	          		level = level+result.getString("level");
	            }
	            result.close();
	        }
		return level;
	    }

}
