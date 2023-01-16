package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.crud.database.DatabaseConn;
import com.crud.model.User;
import com.crud.query.DatabaseQuery;

public class DatabaseService {
	
	DatabaseQuery dq=new DatabaseQuery();
	
	DatabaseConn dc=new DatabaseConn();

	public void insertRecord(User user) {
		try(Connection conn=DatabaseConn.getConnection();
				PreparedStatement ps=conn.prepareStatement(dq.insertRecordQuery());) {
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddr());
			
			int rows=ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("record insert success");
			}else {
				System.out.println("record insert failed");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void getAllRecords() {
		try(Connection conn= DatabaseConn.getConnection();
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery(dq.getAllRecordsQuery());) {
			
			while(rs.next()) {
				printAllRecords(new User(rs.getInt("ID"),rs.getString("username"),rs.getString("email"),rs.getString("addr")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void printAllRecords(User user) {
		System.out.println(user.getId()+" "+user.getName()+" "+user.getEmail()+" "+user.getAddr());
	}
	
	public boolean getRecordByID(int ID) {
		
		boolean isFound=false;
		try(Connection conn=DatabaseConn.getConnection();
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery(dq.getRecordByIDQuery(ID));) {
			
			if(rs.next()) {
				isFound= true;
				printAllRecords(new User(rs.getInt("ID"),rs.getString("username"),rs.getString("email"),rs.getString("addr")));
			}else {
				System.out.println("No Records Found...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isFound;
	}
	
	public void DeleteRecordByID(int ID) {
		try(Connection conn=DatabaseConn.getConnection();
				Statement st=conn.createStatement();) {
			int rows=st.executeUpdate(dq.DeleteRecordByIDQuery(ID));
			if(rows>0) {
				System.out.println("record deleted successfully");
			}else {
				System.out.println("record not found");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateRecordByID(User user) {
		try(Connection conn=DatabaseConn.getConnection();
				PreparedStatement ps=conn.prepareStatement(dq.UpdateRecordByIDQuery(user.getId()));) {
			
//			ps.setInt(1, user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getAddr());
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				System.out.println("record updated");
			}else {
				System.out.println("something went wrong");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
