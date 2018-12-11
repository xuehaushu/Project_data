package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;


import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tcaozuoyuan;
import com.orm.Tsonghuoyuan;

public class loginService
{
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//ϵͳ����Ա��½
		{
			String sql="select * from t_admin where userName=? and userPw=?";//����sql������
			Object[] params={userName,userPw};//����һ��object�࣬����û���������
			DB mydb=new DB();//������һ��DB����
			mydb.doPstm(sql, params);//����doPstm����
			try 
			{
				ResultSet rs=mydb.getRs();//����һ�����������
				boolean mark=(rs==null||!rs.next()?false:true);//�ж����ݿ����Ƿ���ڸ��û���������
				if(mark==false)//�û���Ϊfalse�����
				{
					 result="no";//����no
				}
				else
				{
					 result="yes";//����yes
					 TAdmin admin=new TAdmin();//����admin����
					 admin.setUserId(rs.getInt("userId"));//��admin������ֵ
					 admin.setUserName(rs.getString("userName"));//��admin������ֵ
					 admin.setUserPw(rs.getString("userPw"));//��admin������ֵ
					 WebContext ctx = WebContextFactory.get(); //����WebContext����������ȡsession
					 HttpSession session=ctx.getSession(); //����session��ȡ
					 session.setAttribute("userType", 0);//����session��������ֵ
		             session.setAttribute("admin", admin);//��admin��ֵ
				}
				rs.close();//�رս����
			} 
			catch (SQLException e)//����SQLException�쳣
			{
				System.out.println("��¼ʧ�ܣ�");//������
				e.printStackTrace();//���ú���
			}
			finally
			{
				mydb.closed();
			}
			
		}
		
		
		if(userType==1)
		{
			String sql="select * from t_caozuoyuan where del='no' and loginname=? and loginpw=?";
			Object[] params={userName.trim(),userPw.trim()};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 System.out.println("GG");
					 Tcaozuoyuan caozuoyuan=new Tcaozuoyuan();
					 
					 caozuoyuan.setId(rs.getInt("id"));
					 caozuoyuan.setName(rs.getString("name"));
					 caozuoyuan.setSex(rs.getString("sex"));
					 caozuoyuan.setAge(rs.getString("age"));
						
					 caozuoyuan.setTel(rs.getString("tel"));
					 caozuoyuan.setAddress(rs.getString("address"));
					 caozuoyuan.setLoginname(rs.getString("loginname"));
					 caozuoyuan.setLoginpw(rs.getString("loginpw"));
					 
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 1);
		             session.setAttribute("caozuoyuan", caozuoyuan);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("��¼ʧ�ܣ�");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
		}
		if(userType==2)
		{
			String sql="select * from t_songhuoyuan where del='no' and loginname=? and loginpw=?";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 
					 Tsonghuoyuan songhuoyuan=new Tsonghuoyuan();
						
						songhuoyuan.setId(rs.getInt("id"));
						songhuoyuan.setName(rs.getString("name"));
						songhuoyuan.setSex(rs.getString("sex"));
						songhuoyuan.setAge(rs.getString("age"));
						
						songhuoyuan.setTel(rs.getString("tel"));
						songhuoyuan.setAddress(rs.getString("address"));
						songhuoyuan.setLoginname(rs.getString("loginname"));
						songhuoyuan.setLoginpw(rs.getString("loginpw"));
					 
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 2);
		             session.setAttribute("songhuoyuan", songhuoyuan);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("��¼ʧ�ܣ�");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		
		String sql="update t_admin set userPw=? where userId=?";
		Object[] params={userPwNew,admin.getUserId()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		return "yes";
    }
    
    
    public List songhuoyuanAll()
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
		
		return songhuoyuanList;
    }
}
