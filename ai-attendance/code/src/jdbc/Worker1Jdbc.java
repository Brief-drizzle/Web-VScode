package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import entity.Worker1;

public class Worker1Jdbc {
	
		final static String cfn = "com.mysql.jdbc.Driver";
		final static String url = "jdbc:mysql://localhost:3306/class_sign?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
		public List<Worker1> findAll(){
			List<Worker1> list = new ArrayList<Worker1>();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from worker1";                 
	            statement = con.prepareStatement(sql);           
	            res = statement.executeQuery();
	            while(res.next()) {
	            	Worker1 w = new Worker1();
	            	w.setId(res.getInt(1));
	            	w.setName(res.getString(2));
	            	w.setSex(res.getString(3));
	            	w.setPhone(res.getString(4));
	            	w.setWork(res.getString(5));
	            	w.setImage(res.getString(6));
	            	w.setNumber(res.getString(7));
	            	list.add(w);
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
		
		public Worker1 findByid(int id){
			Worker1 w = new Worker1();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from worker1 where id=?";                 
	            statement = con.prepareStatement(sql);      
	            statement.setInt(1,id);
	            res = statement.executeQuery();
	            while(res.next()) {
	            	w.setId(res.getInt(1));
	            	w.setName(res.getString(2));
	            	w.setSex(res.getString(3));
	            	w.setPhone(res.getString(4));
	            	w.setWork(res.getString(5));
	            	w.setImage(res.getString(6));
	            	w.setNumber(res.getString(7));
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
			return w;
		}
		
		
		/*添加信息*/
		public void AddInfo(Worker1 w){
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="insert into worker1(name,sex,phone,work,image,number) values(?,?,?,?,?,?)";            
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,w.getName());
	            statement.setString(2,w.getSex());
	            statement.setString(3,w.getPhone());
	            statement.setString(4,w.getWork());
	            statement.setString(5,w.getImage());
	            statement.setString(6,w.getNumber());
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
		
		public void Alter(Worker1 w) {
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="update worker1 set name=?,sex=?,phone=?,work=?,image=?,number=? where id = ?";                 
	            statement = con.prepareStatement(sql);           
	            statement.setString(1,w.getName());
	            statement.setString(2,w.getSex());
	            statement.setString(3,w.getPhone());
	            statement.setString(4,w.getWork());
	            statement.setString(5,w.getImage());
	            statement.setString(6,w.getNumber());
	            statement.setInt(7,w.getId());
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
	            String sql="delete from worker1 where id = ?";                 
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
