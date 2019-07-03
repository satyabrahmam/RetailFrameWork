package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.CategoryBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

/*
 * Class will load the sql.properties file 
 * getLogins method will connect to DB and will fetch the Category details from Category Table
 * 
 */
public class UpSkillRetailCategoryTable {
	
Properties properties; 
	
	public UpSkillRetailCategoryTable() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<CategoryBean> getCategoryDetails(){
		String sql = properties.getProperty("get.categories"); 
		
		GetConnection gc  = new GetConnection(); 
		List<CategoryBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<CategoryBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				CategoryBean temp = new CategoryBean();
				
				temp.setCategoryname(gc.rs1.getString(1));
				temp.setDescription(gc.rs1.getString(2));
				temp.setMetaTagTitle(gc.rs1.getString(3));
				temp.setMetaTagDescription(gc.rs1.getString(4));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}

}
