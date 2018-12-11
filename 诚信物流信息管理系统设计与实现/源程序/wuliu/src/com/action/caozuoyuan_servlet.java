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
	
	
	
	
	public void caozuoyuanAdd(HttpServletRequest req,HttpServletResponse res)//�������Ӳ���Ա�ķ���
	{
		String name=req.getParameter("name");//����һ��name����ò���Ա����
		String sex=req.getParameter("sex");//����һ��sex����ò���Ա�Ա�
		String age=req.getParameter("age");//����һ��age����ò���Ա����
		String tel=req.getParameter("tel");//����һ��tel����ò���Ա�绰
		
		String address=req.getParameter("address");//����һ��address����ò���Ա��ַ
		String loginname=req.getParameter("loginname");//����һ��loginname����ò���Ա��¼��
		String loginpw=req.getParameter("loginpw");//����һ��loginpw����ò���Ա��¼����
		String del="no";//����delΪno
		
		String sql="insert into t_caozuoyuan values(?,?,?,?,?,?,?,?)";//����sql���
		Object[] params={name,sex,age,tel,address,loginname,loginpw,del};//��object���Ų���Ա��������Ϣ
		DB mydb=new DB();//�����µ����ݿ����Ӷ���
		mydb.doPstm(sql, params);//�����ݿ��������
		mydb.closed();//�ر����ݿ�
		
		req.setAttribute("message", "�����ɹ�");//��ʾ�����ɹ������������ɹ���
		req.setAttribute("path", "caozuoyuan?type=caozuoyuanMana");//�����ɹ�����ʾ���в���Ա��Ϣ
		
        String targetURL = "/common/success.jsp";//����һ��URL
		dispatch(targetURL, req, res);//���÷���
	}
	public void caozuoyuanDel(HttpServletRequest req,HttpServletResponse res)//����ɾ������Ա�ķ���
	{
		int id=Integer.parseInt(req.getParameter("id"));//���id����idת��Ϊint��
		
		String sql="update t_caozuoyuan set del='yes' where id=?";//����sql���
		Object[] params={id};//��id�ŵ�object����
		DB mydb=new DB();//�����µ����ݿ�����
		mydb.doPstm(sql, params);//�����ݿ��������
		mydb.closed();//�ر����ݿ�
		
		req.setAttribute("message", "�����ɹ�");//��ʾ�����ɹ������������ɹ���
		req.setAttribute("path", "caozuoyuan?type=caozuoyuanMana");//�����ɹ�����ʾ���в���Ա��Ϣ
		
        String targetURL = "/common/success.jsp";//����һ��URL
		dispatch(targetURL, req, res);//���÷���
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
