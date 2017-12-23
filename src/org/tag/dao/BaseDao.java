package org.tag.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import org.tag.entity.Pagination;
import org.tag.mytab.tagAttribute;

public class BaseDao  {

	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet set;

	// 获得连接对象
	protected Connection getConn(String dbName, String user, String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ dbName, user, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Result findAll(String dbName, String user, String pwd,
			String dtName, Pagination page,Boolean state) {
		try {

			String sql = "select * from " + dtName;
			if (state) {
				sql += " limit ?,?";
			}

			ps = getConn(dbName, user, pwd).prepareStatement(sql);
			if (state) {
				ps.setObject(1, (page.getIndex() - 1) * page.getSize());
				ps.setObject(2, page.getSize());
			}

			set = ps.executeQuery();
			return ResultSupport.toResult(set);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCount(String dbName, String user, String pwd,
			String dtName, Pagination page) {
		try {

			ps = getConn(dbName, user, pwd).prepareStatement(
					"select count(*) from " + dtName);
			set = ps.executeQuery();
			if (set.next()) {
				return set.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 公用增删改的方法
	public Integer executeUpdate(String dbName, String user, String pwd,
			String sql, List<Object> list) {

		try {

			ps = getConn(dbName, user, pwd).prepareStatement(sql);

			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					ps.setObject(i + 1, list.get(i));
				}
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	// 关闭连接对象
	protected void close() {
		try {
			if (set != null)
				set.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
