package com.ljheee.web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.*;

/**
 *
 */
@WebListener
public class AppListener implements ServletContextListener {


	/**
	 * 
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
	 *上下文context初始化
     */
    public void contextInitialized(ServletContextEvent sce)  { 

    	Context initContext ;
    	Context envContext;
    	DataSource ds = null;
		try {
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");//此行固定
			ds = (DataSource)envContext.lookup("jdbc/ds");//此处“jdbc/ds”和context.xml文件指定的name属性一致
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
 //   	Connection conn = ds.getConnection();//用ds获得连接
    	
    	//从上下文获得数据源(DBCP，数据库连接池)
//    	DataSource ds = null ;
    	
    	
    	
    	//数据源对象ds保存到application scope[全局通用]
    	sce.getServletContext().setAttribute("pool", ds);
    	System.out.println("DB pool load success");
    }
	
}
