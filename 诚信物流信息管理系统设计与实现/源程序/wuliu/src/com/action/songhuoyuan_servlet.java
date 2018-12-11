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
	
	
	
	
	public void songhuoyuanAdd(HttpServletRequest req,HttpServletResponse res)//���������ͻ�Ա�ķ���
	{
		String name=req.getParameter("name");//����һ��name������ͻ�Ա����
		String sex=req.getParameter("sex");//����һ��sex������ͻ�Ա�Ա�
		String age=req.getParameter("age");//����һ��age������ͻ�Ա����
		String tel=req.getParameter("tel");//����һ��tel������ͻ�Ա�绰
		
		String address=req.getParameter("address");//����һ��address������ͻ�Ա��ַ
		String loginname=req.getParameter("loginname");//����һ��loginname������ͻ�Ա��¼��
		String loginpw=req.getParameter("loginpw");//����һ��loginpw������ͻ�Ա��¼����
		String del="no";//����delΪno
		
		String sql="insert into t_songhuoyuan values(?,?,?,?,?,?,?,?)";//����sql���
		Object[] params={name,sex,age,tel,address,loginname,loginpw,del};//��object�����ͻ�Ա��������Ϣ
		DB mydb=new DB();//�����µ����ݿ����Ӷ���
		mydb.doPstm(sql, params);//�����ݿ��������
		mydb.closed();//�ر����ݿ�
		
		req.setAttribute("message", "�����ɹ�");//���������ɹ���
		req.setAttribute("path", "songhuoyuan?type=songhuoyuanMana");//�����ɹ�����ʾ�ͻ�Ա��������Ϣ
		
        String targetURL = "/common/success.jsp";//����һ��URL
		dispatch(targetURL, req, res);//���÷���
	}
	public void songhuoyuanDel(HttpServletRequest req,HttpServletResponse res)//����ɾ���ͻ�Ա�ķ���
	{
		int id=Integer.parseInt(req.getParameter("id"));//���id����idת��Ϊint��
		
		String sql="update t_songhuoyuan set del='yes' where id=?";//����sql���
		Object[] params={id};//��id�ŵ�object����
		DB mydb=new DB();//�����µ����ݿ����Ӷ���
		mydb.doPstm(sql, params);//�����ݿ��������
		mydb.closed();//�ر����ݿ�
		
		req.setAttribute("message", "�����ɹ�");//���������ɹ���
		req.setAttribute("path", "songhuoyuan?type=songhuoyuanMana");//�����ɹ�����ʾ�����ͻ�Ա��Ϣ
		
        String targetURL = "/common/success.jsp";//����һ��URL
		dispatch(targetURL, req, res);//���÷���
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
