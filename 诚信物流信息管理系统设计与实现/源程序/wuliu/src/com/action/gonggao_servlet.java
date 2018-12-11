package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tgonggao;

public class gonggao_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("gonggaoAdd"))
		{
			gonggaoAdd(req, res);
		}
		if(type.endsWith("gonggaoMana"))
		{
			gonggaoMana(req, res);
		}
		if(type.endsWith("gonggaoDel"))
		{
			gonggaoDel(req, res);
		}
		if(type.endsWith("gonggaoDetail"))
		{
			gonggaoDetail(req, res);
		}
		if(type.endsWith("gonggaoAll"))
		{
			gonggaoAll(req, res);
		}
		if(type.endsWith("gonggaoDetailQian"))
		{
			gonggaoDetailQian(req, res);
		}
	}
	
	
	public void gonggaoAdd(HttpServletRequest req,HttpServletResponse res)//定义公告add的方法用来增加公告
	{
		String id=String.valueOf(new Date().getTime());//定义一个id
		String title=req.getParameter("title");//定义一个title，获得公告标题
		String content=req.getParameter("content");//定义一个content，获得公告内容
		String shijian=new Date().toLocaleString();//定义时间，获得当前时间
		
		
		String sql="insert into t_gonggao values(?,?,?,?)";//定义sql语句
		Object[] params={id,title,content,shijian};//用Object类存放公告所有的信息
		DB mydb=new DB();//创建新的数据库连接对象
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭连接
		
		req.setAttribute("message", "操作成功");//显示增加公告成功，弹出操作成功框
		req.setAttribute("path", "gonggao?type=gonggaoMana");//操作成功后，显示所有公告
		
        String targetURL = "/common/success.jsp";//定义了一个URL
		dispatch(targetURL, req, res);//调用方法
        
	}
	
	
	public void gonggaoDel(HttpServletRequest req,HttpServletResponse res)//定义删除公告方法
	{
		String id=req.getParameter("id");//获取当前公告的id
		
		String sql="delete from t_gonggao where id=?";//定义删除的sql语句
		Object[] params={id};//存放id
		DB mydb=new DB();//创建新的数据库连接对象
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭连接
		
		req.setAttribute("message", "操作成功");//显示删除公告成功，弹出操作成功框
		req.setAttribute("path", "gonggao?type=gonggaoMana");//操作成功后，显示所有公告
		
        String targetURL = "/common/success.jsp";//定义了一个URL
		dispatch(targetURL, req, res);//调用方法
	}

	public void gonggaoMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List gonggaoList=new ArrayList();
		String sql="select * from t_gonggao";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgonggao gonggao=new Tgonggao();
				
				gonggao.setId(rs.getString("id"));
				gonggao.setTitle(rs.getString("title"));
				gonggao.setContent(rs.getString("content"));
				gonggao.setShijian(rs.getString("shijian"));
				
				gonggaoList.add(gonggao);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gonggaoList", gonggaoList);
		req.getRequestDispatcher("admin/gonggao/gonggaoMana.jsp").forward(req, res);
	}
	
	
	public void gonggaoDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tgonggao gonggao=new Tgonggao();
		
		String sql="select * from t_gonggao where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			gonggao.setId(rs.getString("id"));
			gonggao.setTitle(rs.getString("title"));
			gonggao.setContent(rs.getString("content"));
			gonggao.setShijian(rs.getString("shijian"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gonggao", gonggao);
		req.getRequestDispatcher("admin/gonggao/gonggaoDetail.jsp").forward(req, res);
	}
	
	public void gonggaoAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List gonggaoList=new ArrayList();
		String sql="select * from t_gonggao";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgonggao gonggao=new Tgonggao();
				
				gonggao.setId(rs.getString("id"));
				gonggao.setTitle(rs.getString("title"));
				gonggao.setContent(rs.getString("content"));
				gonggao.setShijian(rs.getString("shijian"));
				
				gonggaoList.add(gonggao);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gonggaoList", gonggaoList);
		req.getRequestDispatcher("qiantai/gonggao/gonggaoAll.jsp").forward(req, res);
	}
	
	public void gonggaoDetailQian(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tgonggao gonggao=new Tgonggao();
		
		String sql="select * from t_gonggao where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			gonggao.setId(rs.getString("id"));
			gonggao.setTitle(rs.getString("title"));
			gonggao.setContent(rs.getString("content"));
			gonggao.setShijian(rs.getString("shijian"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gonggao", gonggao);
		req.getRequestDispatcher("/qiantai/gonggao/gonggaoDetailQian.jsp").forward(req, res);
	}
	
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
