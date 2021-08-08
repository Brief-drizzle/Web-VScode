package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import entity.People;

public class PeopleJdbc {
	
		final static String cfn = "com.mysql.jdbc.Driver";
		final static String url = "jdbc:mysql://localhost:3306/class_sign?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
		public List<People> findAll(){
			List<People> list = new ArrayList<People>();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from people";                 
	            statement = con.prepareStatement(sql);           
	            res = statement.executeQuery();
	            while(res.next()) {
	            	People p = new People();
	            	p.setId(res.getInt(1));
	            	p.setName(res.getString(2));
	            	p.setSex(res.getString(3));
	            	p.setAddress(res.getString(4));
	            	p.setPhone(res.getString(5));
	            	p.setImage(res.getString(6));
	            	p.setNumber(res.getString(7));
	            	p.setPassword(res.getString(8));
	            	p.setNumber2(res.getString(9));
	            	list.add(p);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        	System.out.println("获取信息失败");
	            e.printStackTrace();
	        
	        }finally{
	            try {
	                if(res != null) res.close();
	                if(statement != null) statement.close();
	                if(con != null) con.close();
	            } catch (Exception e2) {
	                // TODO: handle exception
	                e2.printStackTrace();
	            }
	        }
			return list;
		}
		
		public People findByid(int id){
			People p = new People();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from people where id=?";                 
	            statement = con.prepareStatement(sql);  
	            statement.setInt(1,id);
	            res = statement.executeQuery();
	            while(res.next()) {
	            	p.setId(res.getInt(1));
	            	p.setName(res.getString(2));
	            	p.setSex(res.getString(3));
	            	p.setAddress(res.getString(4));
	            	p.setPhone(res.getString(5));
	            	p.setImage(res.getString(6));
	            	p.setNumber(res.getString(7));
	            	p.setPassword(res.getString(8));
	            	p.setNumber2(res.getString(9));
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        	System.out.println("获取信息失败");
	            e.printStackTrace();
	        
	        }finally{
	            try {
	                if(res != null) res.close();
	                if(statement != null) statement.close();
	                if(con != null) con.close();
	            } catch (Exception e2) {
	                // TODO: handle exception
	                e2.printStackTrace();
	            }
	        }
			return p;
		}
		
		
		/*添加信息*/
		public void AddInfo(People p){
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="insert into people(name,sex,address,phone,image,number,password,number2) values(?,?,?,?,?,?,?,?)";            
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,p.getName());
	            statement.setString(2,p.getSex());
	            statement.setString(3,p.getAddress());
	            statement.setString(4,p.getPhone());
	            statement.setString(5,p.getImage());
	            statement.setString(6,p.getNumber());
	            statement.setString(7,p.getPassword());
	            statement.setString(8,p.getNumber2());
	            statement.executeUpdate();
	        } catch (Exception e) {
	        	System.out.println("添加失败");
	            e.printStackTrace();
	        
	        }finally{
	            try {
	                if(res != null) res.close();
	                if(statement != null) statement.close();
	                if(con != null) con.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
		}
		
		public void Alter(People p) {
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="update people set name=?,sex=?,address=?,phone=?,image=?,number=?,password,number2 where id = ?";                 
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,p.getName());
	            statement.setString(2,p.getSex());
	            statement.setString(3,p.getAddress());
	            statement.setString(4,p.getPhone());
	            statement.setString(5,p.getImage());
	            statement.setString(6,p.getNumber());
	            statement.setString(7,p.getPassword());
	            statement.setString(8,p.getNumber2());
	            statement.setInt(9,p.getId());
	            statement.execute();
	        } catch (Exception e) {
	            e.printStackTrace();
	        
	        }finally{
	            try {
	                if(res != null) res.close();
	                if(statement != null) statement.close();
	                if(con != null) con.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
		}
		
		/*删除信息*/
		public void Delete(int id) {
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="delete from people where id = ?";                 
	            statement = con.prepareStatement(sql);           
	            statement.setInt(1,id);
	            statement.execute();
	        } catch (Exception a) {
	        	System.out.println("删除信息失败");
	            a.printStackTrace();
	        
	        }finally{
	            try {
	                if(res != null) res.close();
	                if(statement != null) statement.close();
	                if(con != null) con.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
		}
	
}
