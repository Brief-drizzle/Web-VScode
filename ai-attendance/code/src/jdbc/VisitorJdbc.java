package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import entity.Visitor;

public class VisitorJdbc {
	
		final static String cfn = "com.mysql.jdbc.Driver";
		final static String url = "jdbc:mysql://localhost:3306/class_sign?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
		public List<Visitor> findAll(){
			List<Visitor> list = new ArrayList<Visitor>();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from visitor";                 
	            statement = con.prepareStatement(sql);           
	            res = statement.executeQuery();
	            while(res.next()) {
	            	Visitor v = new Visitor();
	            	v.setId(res.getInt(1));
	            	v.setName(res.getString(2));
	            	v.setSex(res.getString(3));
	            	v.setPhone(res.getString(4));
	            	v.setAddress(res.getString(5));
	            	v.setImage(res.getString(6));
	            	v.setNumber(res.getString(7));
	            	list.add(v);
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
		
		public Visitor findByid(int id){
			Visitor v = new Visitor();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from visitor where id=?";                 
	            statement = con.prepareStatement(sql);     
	            statement.setInt(1,id);
	            res = statement.executeQuery();
	            while(res.next()) {
	            	v.setId(res.getInt(1));
	            	v.setName(res.getString(2));
	            	v.setSex(res.getString(3));
	            	v.setPhone(res.getString(4));
	            	v.setAddress(res.getString(5));
	            	v.setImage(res.getString(6));
	            	v.setNumber(res.getString(7));
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
			return v;
		}
		
		
		/*添加信息*/
		public void AddInfo(Visitor v){
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="insert into visitor(name,sex,phone,address,image,number) values(?,?,?,?,?,?)";            
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,v.getName());
	            statement.setString(2,v.getSex());
	            statement.setString(3,v.getPhone());
	            statement.setString(4,v.getAddress());
	            statement.setString(5,v.getImage());
	            statement.setString(6,v.getNumber());
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
		
		public void Alter(Visitor v) {
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="update visitor set name=?,sex=?,phone=?,address=?,image=?,number=? where id = ?";                 
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,v.getName());
	            statement.setString(2,v.getSex());
	            statement.setString(3,v.getPhone());
	            statement.setString(4,v.getAddress());
	            statement.setString(5,v.getImage());
	            statement.setString(6,v.getNumber());
	            statement.setInt(7,v.getId());
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
	            String sql="delete from visitor where id = ?";                 
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
