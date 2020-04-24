package com.ShareCarManageSystem.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ShareCarManageSystem.model.Car;
import com.ShareCarManageSystem.model.FixCar;
import com.ShareCarManageSystem.model.RentCar;
import com.ShareCarManageSystem.model.RepayCar;

/**
 * 数据库连接类
 *
 */
public class Database {
	// 数据库连接字符串

	private String conStr = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ShareCarManageSystem";
	// 数据库连接用户名
	private String dbUserName = "sa";
	// 数据库连接密码
	private String dbPassword = "123456";
	// 数据库连接对象
	private static Connection con = null;

	public Database() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conStr, dbUserName, dbPassword);
			System.out.println("[数据库连接成功]");
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}

	/**
	 * 管理员登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean adminLogin(String username, String password) {
		String sql = "select Username from t_admin where Username=? and password=?";
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 查询车辆信息数据
	 *
	 * @return
	 */
	public static List<Car> queryCarInfo() {
		String sql = "select * from t_car";
		List<Car> list = new ArrayList<Car>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt(1));
				car.setName(rs.getString(2));
				car.setColor(rs.getString(3));
				car.setType(rs.getString(4));
				car.setPrice(rs.getFloat(5));
				list.add(car);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 删除车辆信息
	 *
	 * @param id
	 * @return
	 */
	public static boolean deleteCarInfo(int id) {
		String sql = "delete from t_car where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 添加车辆信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean addCarInfo(Car car) {
		String sql = "insert into t_car values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getName());
			ps.setString(2, car.getColor());
			ps.setString(3, car.getType());
			ps.setFloat(4, car.getPrice());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改车辆信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean modifyCarInfo(Car car) {
		String sql = "update t_car set name=?,color=?,type=?,price=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getName());
			ps.setString(2, car.getColor());
			ps.setString(3, car.getType());
			ps.setFloat(4, car.getPrice());
			ps.setInt(5, car.getId());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询租车信息数据
	 *
	 * @return
	 */
	public static List<RentCar> queryRentCarInfo() {
		String sql = "select * from t_rentCar";
		List<RentCar> list = new ArrayList<RentCar>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RentCar car = new RentCar();
				car.setId(rs.getInt(1));
				car.setRentDate(rs.getString(2));
				car.setName(rs.getString(3));
				car.setCarId(rs.getInt(4));
				car.setPrice(rs.getFloat(5));
				list.add(car);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 删除租车信息
	 *
	 * @param id
	 * @return
	 */
	public static boolean deleteRentCarInfo(int id) {
		String sql = "delete from t_rentCar where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 添加租车信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean addRentCarInfo(RentCar car) {
		String sql = "insert into t_rentCar values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getRentDate());
			ps.setString(2, car.getName());
			ps.setInt(3, car.getCarId());
			ps.setFloat(4, car.getPrice());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改租车信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean modifyRentCarInfo(RentCar car) {
		String sql = "update t_rentCar set RentDate=?,Name=?,CarID=?,Price=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getRentDate());
			ps.setString(2, car.getName());
			ps.setInt(3, car.getCarId());
			ps.setFloat(4, car.getPrice());
			ps.setInt(5, car.getId());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询还车信息数据
	 *
	 * @return
	 */
	public static List<RepayCar> queryRepayCarInfo() {
		String sql = "select * from t_repayCar";
		List<RepayCar> list = new ArrayList<RepayCar>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RepayCar car = new RepayCar();
				car.setId(rs.getInt(1));
				car.setRepayDate(rs.getString(2));
				car.setName(rs.getString(3));
				car.setCarId(rs.getInt(4));
				car.setStatus(rs.getString(5));
				list.add(car);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 删除还车信息
	 *
	 * @param id
	 * @return
	 */
	public static boolean deleteRepayCarInfo(int id) {
		String sql = "delete from t_repayCar where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 添加还车信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean addRepayCarInfo(RepayCar car) {
		String sql = "insert into t_repayCar values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getRepayDate());
			ps.setString(2, car.getName());
			ps.setInt(3, car.getCarId());
			ps.setString(4, car.getStatus());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改还车信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean modifyRepayCarInfo(RepayCar car) {
		String sql = "update t_repayCar set RepayDate=?,Name=?,CarID=?,Status=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getRepayDate());
			ps.setString(2, car.getName());
			ps.setInt(3, car.getCarId());
			ps.setString(4, car.getStatus());
			ps.setInt(5, car.getId());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询修车信息数据
	 *
	 * @return
	 */
	public static List<FixCar> queryFixCarInfo() {
		String sql = "select * from t_fixCar";
		List<FixCar> list = new ArrayList<FixCar>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FixCar car = new FixCar();
				car.setId(rs.getInt(1));
				car.setFixDate(rs.getString(2));
				car.setQuestion(rs.getString(3));
				car.setCarId(rs.getInt(4));
				car.setPrice(rs.getFloat(5));
				list.add(car);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 删除修车信息
	 *
	 * @param id
	 * @return
	 */
	public static boolean deleteFixCarInfo(int id) {
		String sql = "delete from t_fixCar where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 添加修车信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean addFixCarInfo(FixCar car) {
		String sql = "insert into t_fixCar values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getFixDate());
			ps.setString(2, car.getQuestion());
			ps.setInt(3, car.getCarId());
			ps.setFloat(4, car.getPrice());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改修车信息
	 *
	 * @param emp
	 * @return
	 */
	public static boolean modifyFixCarInfo(FixCar car) {
		String sql = "update t_fixCar set FixDate=?,Question=?,CarID=?,Status=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getFixDate());
			ps.setString(2, car.getQuestion());
			ps.setInt(3, car.getCarId());
			ps.setFloat(4, car.getPrice());
			ps.setInt(5, car.getId());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 分析利润
	 * 
	 * @return
	 */
	public static List<String[]> profitAnalysis() {
		String sql1 = "select * from t_rentCar";
		String sql2 = "select * from t_fixCar";
		List<String[]> list = new ArrayList<String[]>();
		try {
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			float sum1 = 0;
			float sum2 = 0;
			while (rs.next()) {
				String[] temp = new String[] { rs.getString(2), "租车", Integer.toString(rs.getInt(4)),
						"+" + Float.toString(rs.getFloat(5)) };
				sum1 += rs.getFloat(5);
				list.add(temp);
			}
			rs.close();
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while (rs.next()) {
				String[] temp = new String[] { rs.getString(2), "修车", Integer.toString(rs.getInt(4)),
						"-" + Float.toString(rs.getFloat(5)) };
				sum2 += rs.getFloat(5);
				list.add(temp);
			}
			list.add(new String[] { Float.toString(sum1), Float.toString(sum2) });
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
