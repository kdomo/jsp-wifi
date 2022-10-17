package com.example.jspWifi.repository;

import com.example.jspWifi.domain.Wifi;

import java.sql.*;
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
                pstmt.setInt(11, Integer.parseInt(wifis.get(i).getInstYear()));
                pstmt.setString(12, wifis.get(i).getInOutType());
                pstmt.setString(13, wifis.get(i).getAccessType());
                pstmt.setString(14, wifis.get(i).getLat());
                pstmt.setString(15, wifis.get(i).getLnt());
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
}
