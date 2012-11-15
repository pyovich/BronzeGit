//=============================================================================
//  Class DatabaseConnection - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.database;

//*****************************************************************************
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;

// Name: DatabaseConnection.java
//
// Project: com.Transcore.Rovr.Database - DatabaseConnection
//
// Author: pyovich
//
// Purpose: TODO: Add Purpose Description
//
//(c) 2012 TransCore, LP.  All rights reserved.
//
//*****************************************************************************
// Updates:
// --------  ----- ------------------------------------------------------------
// Oct 29, 2012 -  V1.0 - Created
//
//*****************************************************************************
/**
 *
 * @author pyovich
 */
public class DatabaseConnectionFactory {

    private String driverClassName;
    private String connectionUrl;
    private String dbUser;
    private String dbPwd;
    private static DatabaseConnectionFactory connectionFactory = null;

    private DatabaseConnectionFactory() {
        try {

            // Load configurastion from property files
            Properties prop = new Properties();

            try {
                FileInputStream configFile = new FileInputStream("config.properties");
                prop.load(configFile);

                // get the property value and print it out
                driverClassName = prop.getProperty("driverClassName");
                connectionUrl = prop.getProperty("connectionUrl");
                dbUser = prop.getProperty("dbUser");
                dbPwd = prop.getProperty("dbPwd");

                configFile.close();
            } catch (IOException ex) {
                log(Level.SEVERE, ex.getMessage());
            }

            Class.forName(driverClassName);
        } catch (ClassNotFoundException ex) {
            log(Level.SEVERE, ex.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;

        conn = DriverManager.getConnection(getConnectionUrl(), getDbUser(), getDbPwd());
        return conn;
    }

    public static DatabaseConnectionFactory getInstance() {

        if (connectionFactory == null) {
            connectionFactory = new DatabaseConnectionFactory();
        }

        return connectionFactory;
    }

    private static void log(Level level, String message) {
        Logger.getLogger(DatabaseConnectionFactory.class.getName()).log(level, message);
    }

    /**
     * @return the connectionUrl
     */
    public String getConnectionUrl() {
        return connectionUrl;
    }

    /**
     * @param connectionUrl the connectionUrl to set
     */
    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    /**
     * @return the dbUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * @param dbUser the dbUser to set
     */
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    /**
     * @return the dbPwd
     */
    public String getDbPwd() {
        return dbPwd;
    }

    /**
     * @param dbPwd the dbPwd to set
     */
    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }
}
