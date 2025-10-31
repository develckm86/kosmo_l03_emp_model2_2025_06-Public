package com.smu.l03_emp_model2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory {
    private static Connection conn;
    private static String oracleUrl="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static String oracleUser="scott";
    private static String oraclePw="tiger";
    private static String oracleDriver="oracle.jdbc.OracleDriver";

    public static Connection getConn() throws SQLException,ClassNotFoundException {
        if(conn==null || conn.isClosed()){
            Class.forName(oracleDriver);
            conn= DriverManager.getConnection(oracleUrl,oracleUser,oraclePw);
        }
        return conn;
    }
    //디자인패턴 싱글톤 : 한번 만들어놓고 객체를 계속 사용하기 위한 디자인패턴
}
