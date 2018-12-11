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
import com.orm.Tsonghuoyuan;

public class songhuoyuan_servlet extends HttpServlet
{ 
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("songhuoyuanAdd"))
		{
			songhuoyuanAdd(req, res);
		}
		if(type.endsWith("songhuoyuanMana"))
		{
			songhuoyuanMana(req, res);
		}
		if(type.endsWith("songhuoyuanDel"))
		{
			songhuoyuanDel(req, res);
		}
	}
	
	
	
	
	public void songhuoyuanAdd(HttpServletRequest req,HttpServletResponse res)//定义增加送货员的方法
	{
		String name=req.getParameter("name");//定义一个name，获得送货员姓名
		String sex=req.getParameter("sex");//定义一个sex，获得送货员性别
		String age=req.getParameter("age");//定义一个age，获得送货员年龄
		String tel=req.getParameter("tel");//定义一个tel，获得送货员电话
		
		String address=req.getParameter("address");//定义一个address，获得送货员地址
		String loginname=req.getParameter("loginname");//定义一个loginname，获得送货员登录名
		String loginpw=req.getParameter("loginpw");//定义一个loginpw，获得送货员登录密码
		String del="no";//定义del为no
		
		String sql="insert into t_songhuoyuan values(?,?,?,?,?,?,?,?)";//定义sql语句
		Object[] params={name,sex,age,tel,address,loginname,loginpw,del};//用object类存放送货员的所有信息
		DB mydb=new DB();//创建新的数据库连接对象
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭数据库
		
		req.setAttribute("message", "操作成功");//弹出操作成功框
		req.setAttribute("path", "songhuoyuan?type=songhuoyuanMana");//操作成功后，显示送货员的所有信息
		
        String targetURL = "/common/success.jsp";//定义一个URL
		dispatch(targetURL, req, res);//调用方法
	}
	public void songhuoyuanDel(HttpServletRequest req,HttpServletResponse res)//定义删除送货员的方法
	{
		int id=Integer.parseInt(req.getParameter("id"));//获得id，将id转换为int型
		
		String sql="update t_songhuoyuan set del='yes' where id=?";//定义sql语句
		Object[] params={id};//将id放到object类中
		DB mydb=new DB();//创建新的数据库连接对象
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭数据库
		
		req.setAttribute("message", "操作成功");//弹出操作成功框
		req.setAttribute("path", "songhuoyuan?type=songhuoyuanMana");//操作成功后，显示所有送货员信息
		
        String targetURL = "/common/success.jsp";//定义一个URL
		dispatch(targetURL, req, res);//调用方法
	}
	
	
	public void songhuoyuanMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List songhuoyuanList=new ArrayList();
		String sql="select * from t_songhuoyuan where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tsonghuoyuan songhuoyuan=new Tsonghuoyuan();
				
				songhuoyuan.setId(rs.getInt("id"));
				songhuoyuan.setName(rs.getString("name"));
				songhuoyuan.setSex(rs.getString("sex"));
				songhuoyuan.setAge(rs.getString("age"));
				
				songhuoyuan.setTel(rs.getString("tel"));
				songhuoyuan.setAddress(rs.getString("address"));
				songhuoyuan.setLoginname(rs.getString("loginname"));
				songhuoyuan.setLoginpw(rs.getString("loginpw"));
				
				songhuoyuanList.add(songhuoyuan);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("songhuoyuanList", songhuoyuanList);
		req.getRequestDispatcher("admin/songhuoyuan/songhuoyuanMana.jsp").forward(req, res);
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
