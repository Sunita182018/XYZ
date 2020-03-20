package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class TestDB {

	public static void main(String arg[]) throws IOException {
        List<LoginBean> list = getdata();
        
        Object[][] result = new Object[list.size()][]; 
        int count = 0; 
        for(LoginBean temp : list){
            Object[]  obj = new Object[2]; 
            obj[0] = temp.getUserName(); 
            obj[1] = temp.getPassword(); 
            
            result[count ++] = obj; 
        }
        System.out.println(result);
        for(Object[] a:result)
        {
            for(Object b: a)
                System.out.println(b);
        }
    }
        
        
    static List<LoginBean> getdata() throws IOException {
    Properties properties = new Properties();
    FileInputStream inStream = new FileInputStream("./resources/sql.properties");
    properties.load(inStream);
    String sql = properties.getProperty("get.logins"); 
    
    GetConnection gc  = new GetConnection(); 
    List<LoginBean> list = null;
    try {
        gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
        list = new ArrayList<LoginBean>(); 
        
        gc.rs1 = gc.ps1.executeQuery(); 
        
        while(gc.rs1.next()) {
        
            LoginBean temp = new LoginBean(); 
            temp.setUserName(gc.rs1.getString(1));
            temp.setPassword(gc.rs1.getString(2));
     
list.add(temp); 
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return list; 
    }

}
