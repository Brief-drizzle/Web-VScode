package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import entity.Root;

public class RootJdbc {
	
		final static String cfn = "com.mysql.jdbc.Driver";
		final static String url = "jdbc:mysql://localhost:3306/class_sign?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
		public List<Root> findAll(){
			List<Root> list = new ArrayList<Root>();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from root";                 
	            statement = con.prepareStatement(sql);           
	            res = statement.executeQuery();
	            while(res.next()) {
	            	Root r = new Root();
	            	r.setId(res.getInt(1));
	            	r.setName(res.getString(2));
	            	r.setPassword(res.getString(3));
	            	list.add(r);
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
		
		public Root findByid(int id){
			Root r = new Root();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from article";                 
	            statement = con.prepareStatement(sql);           
	            res = statement.executeQuery();
	            while(res.next()) {
	            	r.setId(res.getInt(1));
	            	r.setName(res.getString(2));
	            	r.setPassword(res.getString(3));
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
			return r;
		}
		
		
		/*添加信息*/
		public void AddInfo(Root r){
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="insert into root(name,password) values(?,?)";            
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,r.getName());
	            statement.setString(2,r.getPassword());
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
		
		public void Alter(Root r) {
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="update root set name=?,password=? where id = ?";                 
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,r.getName());
	            statement.setString(2,r.getPassword());
	            statement.setInt(3,r.getId());
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
	            String sql="delete from root where id = ?";                 
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
