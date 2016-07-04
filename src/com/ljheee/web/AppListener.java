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
	 *������context��ʼ��
     */
    public void contextInitialized(ServletContextEvent sce)  { 

    	Context initContext ;
    	Context envContext;
    	DataSource ds = null;
		try {
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");//���й̶�
			ds = (DataSource)envContext.lookup("jdbc/ds");//�˴���jdbc/ds����context.xml�ļ�ָ����name����һ��
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
 //   	Connection conn = ds.getConnection();//��ds�������
    	
    	//�������Ļ������Դ(DBCP�����ݿ����ӳ�)
//    	DataSource ds = null ;
    	
    	
    	
    	//����Դ����ds���浽application scope[ȫ��ͨ��]
    	sce.getServletContext().setAttribute("pool", ds);
    	System.out.println("DB pool load success");
    }
	
}
