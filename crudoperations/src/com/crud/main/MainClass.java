package com.crud.main;

import java.util.Scanner;

import com.crud.model.User;
import com.crud.service.DatabaseService;

public class MainClass {

	public static DatabaseService ds=new DatabaseService();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner sc=new Scanner(System.in);){
			
			boolean isrunning=true;
			
			while(isrunning) {
				System.out.println("enter choice");
				System.out.println("1. insert");
				System.out.println("2. select");
				System.out.println("3. select by id");
				System.out.println("4. delete");
				System.out.println("5. update");
				System.out.println("6. exit");

				int choice=Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case 1:
					System.out.println("enter id, name, email, addr");
					ds.insertRecord(new User(Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine(),sc.nextLine()));
					break;
				case 2:
					ds.getAllRecords();
					break;
				case 3:
					System.out.println("enter id to fetch record");
					ds.getRecordByID(Integer.parseInt(sc.nextLine()));
					break;
				case 4:
					System.out.println("enter id to delete record");
					ds.DeleteRecordByID(Integer.parseInt(sc.nextLine()));
					break;
				case 5:
					System.out.println("enter ID of user tobe updated");
					int updateID=Integer.parseInt(sc.nextLine());
					boolean isFound=ds.getRecordByID(updateID);
					
					if(isFound) {
						System.out.println("enter name,email,addr");
						User user=new User(updateID, sc.nextLine(),sc.nextLine(),sc.nextLine());
						ds.updateRecordByID(user);
					}
					
					break;
				case 6:
					System.out.println("thank you");
					isrunning=false;
					break;
				default:
					break;
				}
			
			} 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
