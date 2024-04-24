package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
	
public class DBHundler {
		private static Connection con;
		private static String host = "localhost";
		private static String dbName = "cinema";
		private static int port = 3306;
		private static String userName = "root";
		private static String password = "root";
		
		public static boolean openConnection()
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://"+host+":"+port+"/"+dbName;
				con = DriverManager.getConnection(url,userName,password);
				return true;
			}catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		
		public static boolean closeConnection()
		{
			try {
				con.close();
				return true;
			}catch(Exception e)
			{
				return false;
			}
		}
		
		public static boolean insertStaff(String sName, String sPhoneNumber, String sPassword,int sSalary)
		{
			try {
				openConnection();
				//String sql = "insert into movie(mname,totalmins,expense,income,country) values(?,?,?,?,?);";
				String sql = "insert into staffinformation (sName,sPhoneNumber,sPassword,sSalary) values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, sName);
				ps.setString(2, sPhoneNumber);
				ps.setString(3, sPassword);
				ps.setInt(4, sSalary);
				
				int line = ps.executeUpdate();
				closeConnection();
				return line>0;
			}catch( Exception e)
			{
				return false;
			}
		}
		
		
		public static ArrayList<StaffMember> getAllStaff()
		
		{
			ArrayList<StaffMember> staffs = new ArrayList<StaffMember>();
			
			try {
				openConnection();
				String sql = "select * from staffinformation";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					StaffMember sm = new StaffMember(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
					staffs.add(sm);
				}
				closeConnection();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return staffs;
		}
		
		public static boolean deleteStaff(int sId)
		{
			try
			{
				openConnection();
				String sql = "delete from staffinformation where sid=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, sId);
				int line = ps.executeUpdate();
				closeConnection();
				return line>0;
			}catch(Exception e)
			{
				return false;
			}
		}
		
		public static ArrayList<MovieList> getAllMovie()
		{
			ArrayList<MovieList> movies = new ArrayList<MovieList>();
			
			try {
				openConnection();
				String sql = "select * from movie";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					MovieList sm = new MovieList(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
					movies.add(sm);
				}
				closeConnection();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return movies;
		}

		public static boolean updateMovie(int mId, String mTitle,String mGenre, String mSummary, String mImage, int mduration, String mdate)
		{
			try {
				openConnection();
				//String sql = "insert into movie(mname,totalmins,expense,income,country) values(?,?,?,?,?);";
				String sql = "update movie set mTitle=?,mGenre=?,mSummary=?,mImage=?,mduration=?,mdate=? where mId=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, mTitle);
				ps.setString(2, mGenre);
				ps.setString(3, mSummary);
				ps.setString(4, mImage);
				ps.setInt(5, mduration);
				ps.setString(6, mdate);
				ps.setInt(7, mId);
				int line = ps.executeUpdate();
				closeConnection();
				return line>0;
			}catch( Exception e)
			{
				return false;
			}
		}
		
		public static ArrayList<Price> getAllPrice()
		{
			ArrayList<Price> seat = new ArrayList<Price>();
			
			try {
				openConnection();
				String sql = "select * from seat";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Price sm = new Price(rs.getInt(1),rs.getString(2),rs.getInt(3));
					seat.add(sm);
				}
				closeConnection();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return seat;
		}
		
		public static boolean updatePrice(int seatId, int seatPrice)
		{
			try {
				openConnection();
				//String sql = "insert into movie(mname,totalmins,expense,income,country) values(?,?,?,?,?);";
				String sql = "update seat set seatPrice=? where seatId=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, seatPrice);
				ps.setInt(2, seatId);
				int line = ps.executeUpdate();
				closeConnection();
				return line>0;
			}catch( Exception e)
			{
				return false;
			}
		}
		
		public static boolean addAdmin(String n, String p) {
			try {
				p=Checker.digestMsg(p);
				openConnection();
				String sql="insert into admin(adminName,adminPassword) values(?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, n);
				ps.setString(2, p);
				int line=ps.executeUpdate();
				closeConnection();
				return line>0;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public static int adminLogIn(String n, String p) {
			int id=-1;
			try {
				p=Checker.digestMsg(p);
				openConnection();
				String sql="select adminId from admin where adminName=? and adminPassword=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, n);
				ps.setString(2, p);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					id = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			closeConnection();
			return id;
		}
		
		public static int staffLogIn(String n, String p) {
			int id=-1;
			try {
				openConnection();
				String sql="select sId from staffinformation where sName=? and sPassword=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, n);
				ps.setString(2, p);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					id = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			closeConnection();
			return id;
		}
		
		public static boolean insertSale(String n, String t, String st, String d,String reserve,String sd, String mid, int p)
		{
			try {
				openConnection();
				String sql = "insert into customer(sName,sTherater,sShowTime,sDate,sreserve,sshowDate,smname,price) values(?,?,?,?,?,?,?,?);";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, n);
				ps.setString(2, t);
				ps.setString(3, st);
				ps.setString(4, d);
				ps.setString(5, reserve);
				ps.setString(6, sd);
				ps.setString(7, mid);
				ps.setInt(8, p);
				int line = ps.executeUpdate();
				closeConnection();
				return line>0;
			}catch( Exception e)
			{
				return false;
			}
		}

		public static ArrayList<Sale> getAllSale()
		{
			ArrayList<Sale> sales = new ArrayList<Sale>();
			
			try {
				openConnection();
				String sql = "select * from customer";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Sale sm = new Sale(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
					sales.add(sm);
				}
				closeConnection();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return sales;
		}
		
		public static boolean updateSeat(int seatId, String seatReserve)
		{
			try {
				openConnection();
				//String sql = "insert into movie(mname,totalmins,expense,income,country) values(?,?,?,?,?);";
				String sql = "update customer set sreserve=? where sId=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, seatReserve);
				ps.setInt(2, seatId);
				int line = ps.executeUpdate();
				closeConnection();
				return line>0;
			}catch( Exception e)
			{
				return false;
			}
		}
		
		
		public static ArrayList<DayIncome> getIncome()
		{
			ArrayList<DayIncome> incomes = new ArrayList<DayIncome>();
			
			try {
				openConnection();
				String sql = "SELECT sum(seatPrice),customer.sDate FROM customer,seat WHERE customer.price=seat.seatId AND customer.sreserve ='no' GROUP BY customer.sDate;";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					DayIncome sm = new DayIncome(rs.getString(2),rs.getInt(1));
					incomes.add(sm);
				}
				closeConnection();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return incomes;
		}
		
		public static ArrayList<Sale> getAllSaleTable()
		{
			ArrayList<Sale> sales = new ArrayList<Sale>();
			
			try {
				openConnection();
				String sql = "SELECT sId,sName,sTherater,sShowTime,sDate,sreserve,smname,sshowDate,seatPrice\r\n"
						+ "FROM customer,seat\r\n"
						+ "WHERE customer.price=seat.seatId ;";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Sale sm = new Sale(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
					sales.add(sm);
				}
				closeConnection();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return sales;
		}
		
}


