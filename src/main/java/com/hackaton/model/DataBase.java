package com.hackaton.model;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DataBase {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:base.db";

    private Connection conn;
    private Statement stat;

    public DataBase() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Brak sterownika bazy");
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Problem z połączeniem z bazą");
        }

        createTables();
    }

    /**
     * Method to create table
     *
     * @return success
     */
    private boolean createTables() {
        String delete = "DROP TABLE IF EXISTS frame;";
        String create = "CREATE TABLE frame (\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
                "  mpeg_version INT,\n" +
                "  layer INT,\n" +
                "  protection_bit BOOLEAN,\n" +
                "  bitrate INT,\n" +
                "  sampling INT,\n" +
                "  padding BOOLEAN,\n" +
                "  channel INT,\n" +
                "  mode_extension INT,\n" +
                "  copyright BOOLEAN,\n" +
                "  original BOOLEAN,\n" +
                "  emphasis INTEGER\n" +
                ");";

        try {
            stat.execute(delete);
            stat.execute(create);

        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Method to save data in base
     *
     * @return success
     */
    public boolean insertFrame(Frame f) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "INSERT INTO frame\n" +
                            "(mpeg_version, layer, protection_bit, \n" +
                            " bitrate, sampling, padding, channel, \n" +
                            " mode_extension, copyright, original, emphasis) \n" +
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?);");

            prepStmt.setInt(1, f.getMpeg_version());
            prepStmt.setInt(2, f.getLayer());
            prepStmt.setBoolean(3, f.isProtection_bit());
            prepStmt.setInt(4, f.getBitrate());
            prepStmt.setInt(5, f.getSampling());
            prepStmt.setBoolean(6, f.isPadding());
            prepStmt.setInt(7, f.getChannel());
            prepStmt.setInt(8, f.getMode_extension());
            prepStmt.setBoolean(9, f.isCopyright());
            prepStmt.setBoolean(10, f.isOriginal());
            prepStmt.setInt(11, f.getEmphasis());

            prepStmt.execute();

        } catch (SQLException e) {
            System.out.println("Problem z bazą");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Method to get records from database
     *
     * @return list of records
     */
    public List<Frame> selectFrames() {
        return selectFrames("SELECT * FROM frame");
    }

    /**
     * Method to get records from database
     *
     * @param sql custom query
     * @return list of records
     */
    public List<Frame> selectFrames(String sql) {
        List<Frame> list = new ArrayList<>();

        try {

            ResultSet result = stat.executeQuery(sql);

            int id, mpegVersion, layer, bitrate,
                    sampling, channel, modeExtension,
                    emphasis;
            boolean protectionBit, padding, copyright,
                    original;

            while (result.next()) {
                id = result.getInt("id");
                mpegVersion = result.getInt("mpeg_version");
                layer = result.getInt("layer");
                bitrate = result.getInt("bitrate");
                sampling = result.getInt("sampling");
                channel = result.getInt("channel");
                modeExtension = result.getInt("mode_extension");
                emphasis = result.getInt("emphasis");

                protectionBit = result.getBoolean("protection_bit");
                padding = result.getBoolean("padding");
                copyright = result.getBoolean("copyright");
                original = result.getBoolean("original");

                list.add(new Frame(id, mpegVersion, layer, protectionBit,
                        bitrate, sampling, padding, channel, modeExtension,
                        copyright, original, emphasis));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Method to close connection
     */
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
