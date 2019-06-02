package com.zjw.tools;

import java.sql.*;
import java.util.ArrayList;

public class DBHelp {

	public static Connection getCon() {

		String DBDirverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DBUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=bank";
		String DBUser = "sa";
		String DBPwd = "Passw0rd";
		Connection connection = null;
		try {
			Class.forName(DBDirverName);
			connection = DriverManager.getConnection(DBUrl, DBUser, DBPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	/*
	 * 将参数化（应用占位符问号的方式）的查询语句封装成一个通用的函数 String sql =
	 * "select * from users where  username=? and userpwd=?"; pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, username);
	 * pstmt.setString(2, userpwd); rs = pstmt.executeQuery();
	 * 
	 */
	public static ArrayList executeQuery(String sql, String[] params) {
		Connection con = getCon();
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList arr = new ArrayList();
		try {
			// 创建用来执行SQL预编译的参数化查询语句
			stm = con.prepareStatement(sql);
			// 把相应的参数设置到相应的参数？处
			for (int i = 0; i < params.length; i++)
				// 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
				stm.setString(i + 1, params[i]);
			// 查询获得结果集
			rs = stm.executeQuery();
			// 获取结果集(rs)的结构
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取结果集结构的列数
			int columnTotal = rsmd.getColumnCount();
			// 遍历结果集的每一行，分别把每行的各个列数据取出，并把所有列数据封装到对象obj中（根据结果集的列数创建的数组）
			while (rs.next()) {
				Object[] obj = new Object[columnTotal];
				for (int i = 0; i < obj.length; i++) {
					obj[i] = rs.getObject(i + 1);
				}
				arr.add(obj);// 把当前行数据对象添加到数组列表里。
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭数据库的相关资源
		closeDBResource(rs, stm, con);
		return arr;

	}
	
	
	/*
	 * 将参数化（应用占位符问号的方式）的查询语句封装成一个通用的函数 
	  String sql="delete from user where id=?";
	  ps=conn.prepareStatement(sql);
      ps.setInt(1, id);
      int i=ps.executeUpdate();
	 */

	public static int executeUpdate(String sql, String[] params) {
		Connection con = getCon();
		PreparedStatement stm = null;
		ResultSet rs = null;
		int rows = 0;
		try {
			// 创建用来执行SQL预编译的参数化查询语句
			stm = con.prepareStatement(sql);
			// 把相应的参数设置到相应的参数？处
			for (int i = 0; i < params.length; i++)
				// 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
				stm.setString(i + 1, params[i]);
			// 查询获得结果集
			rows = stm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭数据库的相关资源
		closeDBResource(rs, stm, con);
		return rows;

	}

	public static void closeDBResource(ResultSet rs, Statement stm, Connection con) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stm != null) {
				stm.close();
				stm = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}