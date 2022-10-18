package com.example.jspWifi.repository;

import com.example.jspWifi.domain.Wifi;
import com.example.jspWifi.domain.WifiHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiRepository {
    private Connection con = null;
    private PreparedStatement pstmt = null;


    private final String url = "jdbc:mysql://localhost:3306/project1";
    private final String userId = "project1";
    private final String userPw = "zb";

    public int saveAll(List<Wifi> wifis) {
        int successCount = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into wifi values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            con = DriverManager.getConnection(url, userId, userPw);
            for (int i = 0; i < wifis.size(); i++) {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, wifis.get(i).getNo());
                pstmt.setString(2, wifis.get(i).getGu());
                pstmt.setString(3, wifis.get(i).getName());
                pstmt.setString(4, wifis.get(i).getAddress1());
                pstmt.setString(5, wifis.get(i).getAddress2());
                pstmt.setString(6, wifis.get(i).getInstLocation());
                pstmt.setString(7, wifis.get(i).getInstType());
                pstmt.setString(8, wifis.get(i).getInstAgency());
                pstmt.setString(9, wifis.get(i).getServiceType());
                pstmt.setString(10, wifis.get(i).getNetworkType());
                pstmt.setString(11, wifis.get(i).getInstYear());
                pstmt.setString(12, wifis.get(i).getInOutType());
                pstmt.setString(13, wifis.get(i).getAccessType());
                pstmt.setString(14, wifis.get(i).getX());
                pstmt.setString(15, wifis.get(i).getY());
                pstmt.setString(16, wifis.get(i).getDate());
                int rs = pstmt.executeUpdate();
                if (rs > 0) {
                    successCount += 1;
                }
            }
            disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return successCount;
    }

    public void disconnect() throws SQLException {
        if (con != null) {
            con.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
    }

    public int saveHistory(String x, String y) {
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into wifi_history values (null, ?, ?, now(),'N');";
            con = DriverManager.getConnection(url, userId, userPw);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, x);
            pstmt.setString(2, y);
            result = pstmt.executeUpdate();

            disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<Wifi> getInfo(String x, String y) {
        ArrayList<Wifi> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "SELECT * " +
                    "FROM ( " +
                    "SELECT *,( 6371 * acos( cos( radians(?) ) * cos( radians( x) ) * cos( radians( y ) - radians(?) ) + sin( radians(?) ) * sin( radians(x) ) ) ) AS distance " +
                    "FROM wifi " +
                    ") DATA " +
                    "WHERE DATA.distance < 3 " +
                    "order by distance limit 20; ";
            con = DriverManager.getConnection(url, userId, userPw);
            pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, Double.parseDouble(x));
            pstmt.setDouble(2, Double.parseDouble(y));
            pstmt.setDouble(3, Double.parseDouble(x));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(Wifi.builder()
                        .no(rs.getString("no"))
                        .gu(rs.getString("gu"))
                        .name(rs.getString("name"))
                        .address1(rs.getString("address1"))
                        .address2(rs.getString("address2"))
                        .instLocation(rs.getString("instLocation"))
                        .instType(rs.getString("instType"))
                        .instAgency(rs.getString("instAgency"))
                        .serviceType(rs.getString("serviceType"))
                        .networkType(rs.getString("networkType"))
                        .instYear(rs.getString("instYear"))
                        .inOutType(rs.getString("inOutType"))
                        .accessType(rs.getString("accessType"))
                        .x(rs.getString("x"))
                        .y(rs.getString("y"))
                        .date(rs.getString("date"))
                        .build());
            }

            disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public ArrayList<WifiHistory> getHistory() {
        ArrayList<WifiHistory> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "select * from wifi_history where is_del = 'N'";
            con = DriverManager.getConnection(url, userId, userPw);
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(WifiHistory.builder()
                        .id(Long.valueOf(rs.getString("id")))
                        .x(rs.getString("x"))
                        .y(rs.getString("y"))
                        .date(rs.getString("date"))
                        .build());
            }

            disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int deleteHistory(String id) {
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "update wifi_history set is_del='Y' where id = ? ";
            con = DriverManager.getConnection(url, userId, userPw);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            result = pstmt.executeUpdate();

            disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
