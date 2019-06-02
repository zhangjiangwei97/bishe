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
	 * ����������Ӧ��ռλ���ʺŵķ�ʽ���Ĳ�ѯ����װ��һ��ͨ�õĺ��� String sql =
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
			// ��������ִ��SQLԤ����Ĳ�������ѯ���
			stm = con.prepareStatement(sql);
			// ����Ӧ�Ĳ������õ���Ӧ�Ĳ�������
			for (int i = 0; i < params.length; i++)
				// ��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
				stm.setString(i + 1, params[i]);
			// ��ѯ��ý����
			rs = stm.executeQuery();
			// ��ȡ�����(rs)�Ľṹ
			ResultSetMetaData rsmd = rs.getMetaData();
			// ��ȡ������ṹ������
			int columnTotal = rsmd.getColumnCount();
			// �����������ÿһ�У��ֱ��ÿ�еĸ���������ȡ�����������������ݷ�װ������obj�У����ݽ�������������������飩
			while (rs.next()) {
				Object[] obj = new Object[columnTotal];
				for (int i = 0; i < obj.length; i++) {
					obj[i] = rs.getObject(i + 1);
				}
				arr.add(obj);// �ѵ�ǰ�����ݶ�����ӵ������б��
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �ر����ݿ�������Դ
		closeDBResource(rs, stm, con);
		return arr;

	}
	
	
	/*
	 * ����������Ӧ��ռλ���ʺŵķ�ʽ���Ĳ�ѯ����װ��һ��ͨ�õĺ��� 
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
			// ��������ִ��SQLԤ����Ĳ�������ѯ���
			stm = con.prepareStatement(sql);
			// ����Ӧ�Ĳ������õ���Ӧ�Ĳ�������
			for (int i = 0; i < params.length; i++)
				// ��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
				stm.setString(i + 1, params[i]);
			// ��ѯ��ý����
			rows = stm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �ر����ݿ�������Դ
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