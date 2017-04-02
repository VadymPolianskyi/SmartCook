package com.polyanski.common.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * Author: vadym_polyanski
 * Date: 31.03.17
 * Time: 13:36
 */
public class CreatorDB {

    public static void createDB() {
        String url = "jdbc:mariadb://localhost/";

        String username = "root";
        String password = "root";

        String sql = "CREATE DATABASE IF NOT EXISTS SmartCook";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
