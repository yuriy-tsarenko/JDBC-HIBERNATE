package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository;

import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.db_connector.DataBaseConnector;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.util.PrimaryKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.util.Constants.CHAR;

public interface Repository {

    Logger log = Logger.getLogger(Repository.class);

    default <T> List<T> getAllEntities(String query, Class<T> type) {
        List<T> entities = new ArrayList<>();
        try {
            Statement connection = DataBaseConnector.createConnection();
            Gson gson = new GsonBuilder().serializeNulls().create();
            ResultSet resultSet = connection.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                Object value;
                String key;
                for (int i = 1; i <= columnCount; i++) {
                    value = resultSet.getObject(i);
                    key = metaData.getColumnLabel(i);
                    row.put(key, value);
                }
                String jsonMap = gson.toJson(row);
                T entity = gson.fromJson(jsonMap, type);
                entities.add(entity);
            }
            DataBaseConnector.closeConnection();
        } catch (SQLException e) {
            log.error(e);
        }
        return entities;
    }

    default <T> String queryBuilderUpdate(Map<String, Object> args, PrimaryKey<T> primaryKey, String tableName) throws Exception {
        StringBuilder builder = new StringBuilder("UPDATE " + tableName + " SET ");
        args.forEach((key, value) -> builder.append(key).append("=").append(CHAR).append(value).append(CHAR));

        if (primaryKey != null) {
            builder.append("WHERE " + primaryKey.getKey() + "=" + CHAR).append(primaryKey.getValue()).append(CHAR).append(";");
        } else {
            throw new Exception("update without established primary key is impossible!");
        }
        return builder.toString();
    }
}
