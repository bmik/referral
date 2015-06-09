package edu.uek.referral.model.repository;

import edu.uek.referral.logic.util.PropertyHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by bmik on 2015-06-02.
 */
public class RepositoryManager {

    private static RepositoryManager manager;

    private static final String DB_DRIVER_CLASS = "org.postgresql.Driver";
    private static final String DB_URL_PREFIX = "jdbc:postgresql://";

    private static final Logger logger = Logger.getLogger(RepositoryManager.class.getName());

    private RepositoryManager() {}

    public static RepositoryManager getInstance() {
        if (manager == null) {
            manager = new RepositoryManager();
        }

        return manager;
    }

    public Connection getConnection() {

        Connection connection = null;

        logger.info("Attempting to connect DataSource...");

        try {
            String dbUser = PropertyHandler.getProperty("db.user");
            String dbPass = PropertyHandler.getProperty("db.pass");
            String dbHost = PropertyHandler.getProperty("db.host");
            String dbPort = PropertyHandler.getProperty("db.port");
            String dbName = PropertyHandler.getProperty("db.name");

            Class.forName(DB_DRIVER_CLASS);

            String dbUrl = String.format("%s%s:%s/%s",
                    DB_URL_PREFIX,
                    dbHost,
                    dbPort,
                    dbName);

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);

        } catch (ClassNotFoundException e) {
            logger.info("DataSource connection failed - " + e.getStackTrace());
        } catch (SQLException e) {
            logger.info("DataSource connection failed - " + e.getStackTrace());
        }

        logger.info("DataSource connected!");

        return connection;

    }

}
