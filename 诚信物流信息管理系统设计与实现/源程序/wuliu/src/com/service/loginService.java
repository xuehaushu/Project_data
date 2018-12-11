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
		
		if(userType==0)//系统管理员登陆
		{
			String sql="select * from t_admin where userName=? and userPw=?";//定义sql语句对象
			Object[] params={userName,userPw};//定义一个object类，存放用户名和密码
			DB mydb=new DB();//创建了一个DB对象
			mydb.doPstm(sql, params);//调用doPstm函数
			try 
			{
				ResultSet rs=mydb.getRs();//定义一个结果集对象
				boolean mark=(rs==null||!rs.next()?false:true);//判断数据库中是否存在该用户名和密码
				if(mark==false)//用户名为false的情况
				{
					 result="no";//返回no
				}
				else
				{
					 result="yes";//返回yes
					 TAdmin admin=new TAdmin();//定义admin对象
					 admin.setUserId(rs.getInt("userId"));//给admin对象设值
					 admin.setUserName(rs.getString("userName"));//给admin对象设值
					 admin.setUserPw(rs.getString("userPw"));//给admin对象设值
					 WebContext ctx = WebContextFactory.get(); //定义WebContext对象用来获取session
					 HttpSession session=ctx.getSession(); //定义session获取
					 session.setAttribute("userType", 0);//利用session给参数赋值
		             session.setAttribute("admin", admin);//给admin赋值
				}
				rs.close();//关闭结果集
			} 
			catch (SQLException e)//发生SQLException异常
			{
				System.out.println("登录失败！");//输出结果
				e.printStackTrace();//调用函数
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
				System.out.println("登录失败！");
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
				System.out.println("登录失败！");
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
