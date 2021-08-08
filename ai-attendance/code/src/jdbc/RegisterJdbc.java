package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import entity.Register;

public class RegisterJdbc {
	
		final static String cfn = "com.mysql.jdbc.Driver";
		final static String url = "jdbc:mysql://localhost:3306/class_sign?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
		public List<Register> findAll(){
			List<Register> list = new ArrayList<Register>();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from register";                 
	            statement = con.prepareStatement(sql);           
	            res = statement.executeQuery();
	            while(res.next()) {
	            	Register r = new Register();
	            	r.setId(res.getInt(1));
	            	r.setPid(res.getInt(2));
	            	r.setDate(res.getString(3));
	            	r.setStatus(res.getInt(4));
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
		
		public Register findByid(int id){
			Register r = new Register();
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="select * from register id=?";                 
	            statement = con.prepareStatement(sql);   
	            statement.setInt(1,id);
	            res = statement.executeQuery();
	            while(res.next()) {
	            	r.setId(res.getInt(1));
	            	r.setPid(res.getInt(2));
	            	r.setDate(res.getString(3));
	            	r.setStatus(res.getInt(4));
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
		public void AddInfo(Register r){
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="insert into register(pid,date,status) values(?,?,?)";            
	            statement = con.prepareStatement(sql);           
	            statement.setInt(1,r.getPid());
	            statement.setString(2,r.getDate());
	            statement.setInt(3,r.getStatus());
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
		
		public void Alter(Register r) {
			Connection con = null;
	        PreparedStatement statement = null;
	        ResultSet res = null;
			try {			
	            Class.forName(cfn);
	            con = DriverManager.getConnection(url,"root","root");
	            String sql="update register set pid=?,date=?,status=? where id = ?";                 
	            statement = con.prepareStatement(sql);           
	            statement.setInt(1,r.getPid());
	            statement.setString(2,r.getDate());
	            statement.setInt(3,r.getStatus());
	            statement.setInt(4,r.getId());
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
	            String sql="delete from register where id = ?";                 
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
