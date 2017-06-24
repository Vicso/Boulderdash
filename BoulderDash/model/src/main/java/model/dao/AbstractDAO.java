package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * <h1>The Class AbstractDAO.</h1>
 * 
 * @version 1.0
 */
abstract class AbstractDAO {

    /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */
    protected static ResultSet executeQuery(final String query) {
        return BoulderDashBDDConnector.getInstance().executeQuery(query);
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
    protected static int executeUpdate(final String query) {
        return BoulderDashBDDConnector.getInstance().executeUpdate(query);
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the callable statement
     */
    static CallableStatement prepareCall(final String query) {
        return BoulderDashBDDConnector.getInstance().prepareCall(query);
    }
}
