package com.crud.query;

public class DatabaseQuery {
	
	public String insertRecordQuery() {
		return "INSERT INTO USERINFO(ID, USERNAME, EMAIL, ADDR)VALUES(?,?,?,?);";
	}
	public String getAllRecordsQuery() {
		return "SELECT * FROM USERINFO;";
	}
	public String getRecordByIDQuery(int ID) {
		return "SELECT * FROM USERINFO where id="+ID;
	}
	public String DeleteRecordByIDQuery(int ID) {
		return "Delete FROM USERINFO where id="+ID;
	}
	public String UpdateRecordByIDQuery(int ID) {
		return "UPDATE USERINFO SET USERNAME=?, EMAIL=?, ADDR=? WHERE ID="+ID;
	}

}
