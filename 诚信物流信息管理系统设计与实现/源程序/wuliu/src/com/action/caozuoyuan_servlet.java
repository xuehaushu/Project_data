package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.Tcaozuoyuan;

public class caozuoyuan_servlet extends HttpServlet
{ 
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("caozuoyuanAdd"))
		{
			caozuoyuanAdd(req, res);
		}
		if(type.endsWith("caozuoyuanMana"))
		{
			caozuoyuanMana(req, res);
		}
		if(type.endsWith("caozuoyuanDel"))
		{
			caozuoyuanDel(req, res);
		}
	}
	
	
	
	
	public void caozuoyuanAdd(HttpServletRequest req,HttpServletResponse res)//定义增加操作员的方法
	{
		String name=req.getParameter("name");//定义一个name，获得操作员姓名
		String sex=req.getParameter("sex");//定义一个sex，获得操作员性别
		String age=req.getParameter("age");//定义一个age，获得操作员年龄
		String tel=req.getParameter("tel");//定义一个tel，获得操作员电话
		
		String address=req.getParameter("address");//定义一个address，获得操作员地址
		String loginname=req.getParameter("loginname");//定义一个loginname，获得操作员登录名
		String loginpw=req.getParameter("loginpw");//定义一个loginpw，获得操作员登录密码
		String del="no";//定义del为no
		
		String sql="insert into t_caozuoyuan values(?,?,?,?,?,?,?,?)";//定义sql语句
		Object[] params={name,sex,age,tel,address,loginname,loginpw,del};//用object类存放操作员的所有信息
		DB mydb=new DB();//创建新的数据库连接对象
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭数据库
		
		req.setAttribute("message", "操作成功");//显示操作成功，弹出操作成功框
		req.setAttribute("path", "caozuoyuan?type=caozuoyuanMana");//操作成功后，显示所有操作员信息
		
        String targetURL = "/common/success.jsp";//定义一个URL
		dispatch(targetURL, req, res);//调用方法
	}
	public void caozuoyuanDel(HttpServletRequest req,HttpServletResponse res)//定义删除操作员的方法
	{
		int id=Integer.parseInt(req.getParameter("id"));//获得id，将id转换为int型
		
		String sql="update t_caozuoyuan set del='yes' where id=?";//定义sql语句
		Object[] params={id};//将id放到object类中
		DB mydb=new DB();//创建新的数据库连接
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭数据库
		
		req.setAttribute("message", "操作成功");//显示操作成功，弹出操作成功框
		req.setAttribute("path", "caozuoyuan?type=caozuoyuanMana");//操作成功后，显示所有操作员信息
		
        String targetURL = "/common/success.jsp";//定义一个URL
		dispatch(targetURL, req, res);//调用方法
	}
	
	
	public void caozuoyuanMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List caozuoyuanList=new ArrayList();
		String sql="select * from t_caozuoyuan where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tcaozuoyuan caozuoyuan=new Tcaozuoyuan();
				
				caozuoyuan.setId(rs.getInt("id"));
				caozuoyuan.setName(rs.getString("name"));
				caozuoyuan.setSex(rs.getString("sex"));
				caozuoyuan.setAge(rs.getString("age"));
				
				caozuoyuan.setTel(rs.getString("tel"));
				caozuoyuan.setAddress(rs.getString("address"));
				caozuoyuan.setLoginname(rs.getString("loginname"));
				caozuoyuan.setLoginpw(rs.getString("loginpw"));
				
				caozuoyuanList.add(caozuoyuan);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("caozuoyuanList", caozuoyuanList);
		req.getRequestDispatcher("admin/caozuoyuan/caozuoyuanMana.jsp").forward(req, res);
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
