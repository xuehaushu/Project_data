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
import com.orm.Torder;
import com.orm.Tsonghuoyuan;

public class order_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("orderAdd"))
		{
			orderAdd(req, res);
		}
		if(type.endsWith("orderMana_caozuoyuan"))
		{
			orderMana_caozuoyuan(req, res);
		}
		if(type.endsWith("orderDel"))
		{
			orderDel(req, res);
		}
		if(type.endsWith("orderDetail"))
		{
			orderDetail(req, res);
		}
		
		if(type.endsWith("orderMana_admin"))
		{
			orderMana_admin(req, res);
		}
		if(type.endsWith("order_fenpai_songhuoyuan"))
		{
			order_fenpai_songhuoyuan(req, res);
		}
		
		if(type.endsWith("orderMana_songhuoyuan"))
		{
			orderMana_songhuoyuan(req, res);
		}
		if(type.endsWith("order_huidan_add"))
		{
			order_huidan_add(req, res);
		}
		
		
		if(type.endsWith("order_search_kehu"))
		{
			order_search_kehu(req, res);
		}
	}
	
	
	public void orderAdd(HttpServletRequest req,HttpServletResponse res)//定义添加订单的方法
	{
		String danhao=req.getParameter("danhao");//定义一个danhao，获得订单单号
		String huoleixing=req.getParameter("huoleixing");
		String huomingcheng=req.getParameter("huomingcheng");
		String huozhong=req.getParameter("huozhong");
		
		String huotiji=req.getParameter("huotiji");
		String baozhi=req.getParameter("baozhi");
		String kuaijian=req.getParameter("kuaijian");
		String beizhu=req.getParameter("beizhu");
		
		String jixingming=req.getParameter("jixingming");
		String jidianhua=req.getParameter("jidianhua");
		String jidizhi=req.getParameter("jidizhi");
		String shouxingming=req.getParameter("shouxingming");
		
		String shoudianhua=req.getParameter("shoudianhua");
		String shoudizhi=req.getParameter("shoudizhi");
		int songhuoyuan_id=0;//将送货员的id设为0
		String songhuoyuan_huidan="";//将参数定义为空
		
		
		String sql="insert into t_order values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//定义sql语句
		Object[] params={danhao,huoleixing,huomingcheng,huozhong,//
				         huotiji,baozhi,kuaijian,beizhu,
				         jixingming,jidianhua,jidizhi,shouxingming,
				         shoudianhua,shoudizhi,songhuoyuan_id,songhuoyuan_huidan};//将订单中的信息存放在object类中
		DB mydb=new DB();//创建新的数据库连接对象
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭数据库
		
		req.setAttribute("msg", "订单录入完毕");//弹出订单录入完毕框
        String targetURL = "/common/msg.jsp";//定义一个URl
		dispatch(targetURL, req, res);//调用方法
        
	}
	
	
	public void orderDel(HttpServletRequest req,HttpServletResponse res)//定义删除订单的方法
	{
		String sql="delete from t_order where id=?";//定义sql语句
		Object[] params={Integer.parseInt(req.getParameter("id"))};//将id信息存放到object类中
		DB mydb=new DB();//创建新的数据库连接
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭数据库
		
		req.setAttribute("msg", "操作成功");//弹出操作成功框
        String targetURL = "/common/msg.jsp";//定义一个URL
		dispatch(targetURL, req, res);//调用方法
	}

	public void orderMana_caozuoyuan(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List orderList=new ArrayList();
		String sql="select * from t_order";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Torder order=new Torder();
				
				order.setId(rs.getInt("id"));
				order.setDanhao(rs.getString("danhao"));
				order.setHuoleixing(rs.getString("huoleixing"));
				order.setHuomingcheng(rs.getString("huomingcheng"));
				
				order.setHuozhong(rs.getString("huozhong"));
				order.setHuotiji(rs.getString("huotiji"));
				order.setBaozhi(rs.getString("baozhi"));
				order.setKuaijian(rs.getString("kuaijian"));
				
				order.setBeizhu(rs.getString("beizhu"));
				order.setJixingming(rs.getString("jixingming"));
				order.setJidianhua(rs.getString("jidianhua"));
				order.setJidizhi(rs.getString("jidizhi"));
				
				order.setShouxingming(rs.getString("shouxingming"));
				order.setShoudianhua(rs.getString("shoudianhua"));
				order.setShoudizhi(rs.getString("shoudizhi"));
				order.setSonghuoyuan_id(rs.getInt("songhuoyuan_id"));
				order.setSonghuoyuan_huidan(rs.getString("songhuoyuan_huidan"));
				
				
				orderList.add(order);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("admin/order/orderMana_caozuoyuan.jsp").forward(req, res);
	}
	
	
	public void orderMana_admin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List orderList=new ArrayList();  //定义一个orderList的集合
		String sql="select * from t_order order by songhuoyuan_id desc";//如果送货员id是0，表示没有指派送货员。所有倒序
		Object[] params={};//创建object对象
		DB mydb=new DB();   //创建连接对象
		try
		{
			mydb.doPstm(sql, params);//调用doPstm方法
			ResultSet rs=mydb.getRs(); //将Rs赋值给rs
			while(rs.next())        //判断rs
			{
				Torder order=new Torder();  //定义一个order对象
				
				order.setId(rs.getInt("id")); //将结果集的id赋值给order中的id
				order.setDanhao(rs.getString("danhao"));
				order.setHuoleixing(rs.getString("huoleixing"));
				order.setHuomingcheng(rs.getString("huomingcheng"));
				
				order.setHuozhong(rs.getString("huozhong"));
				order.setHuotiji(rs.getString("huotiji"));
				order.setBaozhi(rs.getString("baozhi"));
				order.setKuaijian(rs.getString("kuaijian"));
				
				order.setBeizhu(rs.getString("beizhu"));
				order.setJixingming(rs.getString("jixingming"));
				order.setJidianhua(rs.getString("jidianhua"));
				order.setJidizhi(rs.getString("jidizhi"));
				
				order.setShouxingming(rs.getString("shouxingming"));
				order.setShoudianhua(rs.getString("shoudianhua"));
				order.setShoudizhi(rs.getString("shoudizhi"));
				order.setSonghuoyuan_id(rs.getInt("songhuoyuan_id"));
				order.setSonghuoyuan_huidan(rs.getString("songhuoyuan_huidan"));
				
				
				orderList.add(order); //调用add方法
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("admin/order/orderMana_admin.jsp").forward(req, res);
	}
	
	
	public void order_fenpai_songhuoyuan(HttpServletRequest req,HttpServletResponse res)//定义分派送货员的方法
	{
		int songhuoyuan_id=Integer.parseInt(req.getParameter("songhuoyuan_id"));//获得送货员的id，转换为int型
		int id=Integer.parseInt(req.getParameter("id"));//获得id，将id转换为int型
		
		String sql="update t_order set songhuoyuan_id=? where id=?";//定义sql语句
		Object[] params={songhuoyuan_id,id};
		DB mydb=new DB();//创建新的数据库连接对象
		mydb.doPstm(sql, params);//与数据库进行连接
		mydb.closed();//关闭数据库
		
		req.setAttribute("msg", "分派送货员完毕");//弹出分派送货员完毕框
        String targetURL = "/common/msg.jsp";//定义一个URl
		dispatch(targetURL, req, res);//调用方法
	}
	
	
	public void orderMana_songhuoyuan(HttpServletRequest req,HttpServletResponse res) //定义一个方法
			throws ServletException, IOException //抛出异常
	{
		Tsonghuoyuan songhuoyuan=(Tsonghuoyuan)(req.getSession().getAttribute("songhuoyuan")); //获取对象信息
		
		List orderList=new ArrayList(); //定义一个List集合
		String sql="select * from t_order where songhuoyuan_id=?"; //定义sql语句
		Object[] params={songhuoyuan.getId()}; //将送货员id存放在object类中
		DB mydb=new DB(); //创建新的数据库连接
		try
		{
			mydb.doPstm(sql, params); //调用方法
			ResultSet rs=mydb.getRs(); //将Rs赋值给rs
			while(rs.next()) //判断结果集
			{
				Torder order=new Torder(); //定义对象
				
				order.setId(rs.getInt("id")); //赋值
				order.setDanhao(rs.getString("danhao"));
				order.setHuoleixing(rs.getString("huoleixing"));
				order.setHuomingcheng(rs.getString("huomingcheng"));
				
				order.setHuozhong(rs.getString("huozhong"));
				order.setHuotiji(rs.getString("huotiji"));
				order.setBaozhi(rs.getString("baozhi"));
				order.setKuaijian(rs.getString("kuaijian"));
				
				order.setBeizhu(rs.getString("beizhu"));
				order.setJixingming(rs.getString("jixingming"));
				order.setJidianhua(rs.getString("jidianhua"));
				order.setJidizhi(rs.getString("jidizhi"));
				
				order.setShouxingming(rs.getString("shouxingming"));
				order.setShoudianhua(rs.getString("shoudianhua"));
				order.setShoudizhi(rs.getString("shoudizhi"));
				order.setSonghuoyuan_id(rs.getInt("songhuoyuan_id"));
				order.setSonghuoyuan_huidan(rs.getString("songhuoyuan_huidan"));
				
				
				orderList.add(order); //把order添加到集合中
		    }
			rs.close(); //关闭结果集
		}
		catch(Exception e) //异常
		{
			e.printStackTrace(); //执行方法，处理异常
		}
		mydb.closed(); //关闭数据库连接
		
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("admin/order/orderMana_songhuoyuan.jsp").forward(req, res);
	}
	
	
	public void order_huidan_add(HttpServletRequest req,HttpServletResponse res)
	{
		String songhuoyuan_huidan=req.getParameter("songhuoyuan_huidan");
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_order set songhuoyuan_huidan=? where id=?";
		Object[] params={songhuoyuan_huidan,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "录入完毕");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void orderDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Torder order=new Torder();
		
		String sql="select * from t_order where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			order.setId(rs.getInt("id"));
			order.setDanhao(rs.getString("danhao"));
			order.setHuoleixing(rs.getString("huoleixing"));
			order.setHuomingcheng(rs.getString("huomingcheng"));
			
			order.setHuozhong(rs.getString("huozhong"));
			order.setHuotiji(rs.getString("huotiji"));
			order.setBaozhi(rs.getString("baozhi"));
			order.setKuaijian(rs.getString("kuaijian"));
			
			order.setBeizhu(rs.getString("beizhu"));
			order.setJixingming(rs.getString("jixingming"));
			order.setJidianhua(rs.getString("jidianhua"));
			order.setJidizhi(rs.getString("jidizhi"));
			
			order.setShouxingming(rs.getString("shouxingming"));
			order.setShoudianhua(rs.getString("shoudianhua"));
			order.setShoudizhi(rs.getString("shoudizhi"));
			order.setSonghuoyuan_id(rs.getInt("songhuoyuan_id"));
			order.setSonghuoyuan_huidan(rs.getString("songhuoyuan_huidan"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("order", order);
		req.getRequestDispatcher("admin/order/orderDetail.jsp").forward(req, res);
	}
	
	
	public void order_search_kehu(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String danhao=req.getParameter("danhao").trim();
		
		Torder order=null;
		String sql="select * from t_order where danhao=?";
		Object[] params={danhao};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				order=new Torder();
				
				order.setId(rs.getInt("id"));
				order.setDanhao(rs.getString("danhao"));
				order.setHuoleixing(rs.getString("huoleixing"));
				order.setHuomingcheng(rs.getString("huomingcheng"));
				
				order.setHuozhong(rs.getString("huozhong"));
				order.setHuotiji(rs.getString("huotiji"));
				order.setBaozhi(rs.getString("baozhi"));
				order.setKuaijian(rs.getString("kuaijian"));
				
				order.setBeizhu(rs.getString("beizhu"));
				order.setJixingming(rs.getString("jixingming"));
				order.setJidianhua(rs.getString("jidianhua"));
				order.setJidizhi(rs.getString("jidizhi"));
				
				order.setShouxingming(rs.getString("shouxingming"));
				order.setShoudianhua(rs.getString("shoudianhua"));
				order.setShoudizhi(rs.getString("shoudizhi"));
				order.setSonghuoyuan_id(rs.getInt("songhuoyuan_id"));
				order.setSonghuoyuan_huidan(rs.getString("songhuoyuan_huidan"));
				
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("order", order);
		req.getRequestDispatcher("qiantai/order/order_search_kehu.jsp").forward(req, res);
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
