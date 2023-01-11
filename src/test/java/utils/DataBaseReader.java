package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBaseReader {

    private static ResultSet rset;
    private static ResultSetMetaData rSetMetaData;

    /**
     * This method create connection to the database, execute query and return object ResulSet
     *
     * @param sqlQuery
     * @return ResultSet
     */
    public static ResultSet getResultSet(String sqlQuery) {

        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("dbUrl"),
                    ConfigReader.getPropertyValue("dbUsername"),
                    ConfigReader.getPropertyValue("dbPassword"));
            statement = conn.createStatement();

            rset = statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rset;
    }

    /**
     * This method return an Object of ResultSetMetaData
     *
     * @param query
     * @return ResultSetMetaData
     */
    public static ResultSetMetaData getRsetMetada(String query) {
        rset = getResultSet(query);
        rSetMetaData = null;
        try {
            rSetMetaData = rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSetMetaData;
    }

    /**
     * This method extract data from ResultSet and stores into List of Maps
     */

    public static List<Map<String, String>> getListOfMapsFromRSet(String query) {
        getResultSet(query);
        getRsetMetada(query);
        List<Map<String, String>> listOfMap = new ArrayList<>();
        Map<String, String> map;
        try {
            while (rset.next()) {
                map = new LinkedHashMap<>();
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
                    String key = rSetMetaData.getColumnName(i);
                    String value = rset.getString(key);
                    map.put(key, value);
                }
                listOfMap.add(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfMap;
    }



}
