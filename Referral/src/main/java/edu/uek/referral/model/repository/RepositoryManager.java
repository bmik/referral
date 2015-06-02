package edu.uek.referral.model.repository;

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

    private static final String PROPERTY_FILE = "config.properties";
    private static final String DB_DRIVER_CLASS = "org.postgresql.Driver";
    private static final String DB_URL_PREFIX = "jdbc:postgresql://";

    private static final Logger logger = Logger.getLogger(RepositoryManager.class.getName());

    public void getConnection() {

        Connection connection;
        Properties properties = new Properties();

        logger.info("Attempting to connect DataSource...");

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE));
            String dbUser = properties.getProperty("db.user");
            String dbPass = properties.getProperty("db.pass");
            String dbHost = properties.getProperty("db.host");
            String dbPort = properties.getProperty("db.port");
            String dbName = properties.getProperty("db.name");

            Class.forName(DB_DRIVER_CLASS);

            String dbUrl = String.format("%s%s:%s/%s",
                    DB_URL_PREFIX,
                    dbHost,
                    dbPort,
                    dbName);

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);

        } catch (IOException e) {
            logger.info("DataSource connection failed - " + e.getStackTrace());
        } catch (ClassNotFoundException e) {
            logger.info("DataSource connection failed - " + e.getStackTrace());
        } catch (SQLException e) {
            logger.info("DataSource connection failed - " + e.getStackTrace());
        }

        logger.info("DataSource connected!");

    }

}
