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
	
	
	public void orderAdd(HttpServletRequest req,HttpServletResponse res)//������Ӷ����ķ���
	{
		String danhao=req.getParameter("danhao");//����һ��danhao����ö�������
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
		int songhuoyuan_id=0;//���ͻ�Ա��id��Ϊ0
		String songhuoyuan_huidan="";//����������Ϊ��
		
		
		String sql="insert into t_order values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//����sql���
		Object[] params={danhao,huoleixing,huomingcheng,huozhong,//
				         huotiji,baozhi,kuaijian,beizhu,
				         jixingming,jidianhua,jidizhi,shouxingming,
				         shoudianhua,shoudizhi,songhuoyuan_id,songhuoyuan_huidan};//�������е���Ϣ�����object����
		DB mydb=new DB();//�����µ����ݿ����Ӷ���
		mydb.doPstm(sql, params);//�����ݿ��������
		mydb.closed();//�ر����ݿ�
		
		req.setAttribute("msg", "����¼�����");//��������¼����Ͽ�
        String targetURL = "/common/msg.jsp";//����һ��URl
		dispatch(targetURL, req, res);//���÷���
        
	}
	
	
	public void orderDel(HttpServletRequest req,HttpServletResponse res)//����ɾ�������ķ���
	{
		String sql="delete from t_order where id=?";//����sql���
		Object[] params={Integer.parseInt(req.getParameter("id"))};//��id��Ϣ��ŵ�object����
		DB mydb=new DB();//�����µ����ݿ�����
		mydb.doPstm(sql, params);//�����ݿ��������
		mydb.closed();//�ر����ݿ�
		
		req.setAttribute("msg", "�����ɹ�");//���������ɹ���
        String targetURL = "/common/msg.jsp";//����һ��URL
		dispatch(targetURL, req, res);//���÷���
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
		List orderList=new ArrayList();  //����һ��orderList�ļ���
		String sql="select * from t_order order by songhuoyuan_id desc";//����ͻ�Աid��0����ʾû��ָ���ͻ�Ա�����е���
		Object[] params={};//����object����
		DB mydb=new DB();   //�������Ӷ���
		try
		{
			mydb.doPstm(sql, params);//����doPstm����
			ResultSet rs=mydb.getRs(); //��Rs��ֵ��rs
			while(rs.next())        //�ж�rs
			{
				Torder order=new Torder();  //����һ��order����
				
				order.setId(rs.getInt("id")); //���������id��ֵ��order�е�id
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
				
				
				orderList.add(order); //����add����
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
	
	
	public void order_fenpai_songhuoyuan(HttpServletRequest req,HttpServletResponse res)//��������ͻ�Ա�ķ���
	{
		int songhuoyuan_id=Integer.parseInt(req.getParameter("songhuoyuan_id"));//����ͻ�Ա��id��ת��Ϊint��
		int id=Integer.parseInt(req.getParameter("id"));//���id����idת��Ϊint��
		
		String sql="update t_order set songhuoyuan_id=? where id=?";//����sql���
		Object[] params={songhuoyuan_id,id};
		DB mydb=new DB();//�����µ����ݿ����Ӷ���
		mydb.doPstm(sql, params);//�����ݿ��������
		mydb.closed();//�ر����ݿ�
		
		req.setAttribute("msg", "�����ͻ�Ա���");//���������ͻ�Ա��Ͽ�
        String targetURL = "/common/msg.jsp";//����һ��URl
		dispatch(targetURL, req, res);//���÷���
	}
	
	
	public void orderMana_songhuoyuan(HttpServletRequest req,HttpServletResponse res) //����һ������
			throws ServletException, IOException //�׳��쳣
	{
		Tsonghuoyuan songhuoyuan=(Tsonghuoyuan)(req.getSession().getAttribute("songhuoyuan")); //��ȡ������Ϣ
		
		List orderList=new ArrayList(); //����һ��List����
		String sql="select * from t_order where songhuoyuan_id=?"; //����sql���
		Object[] params={songhuoyuan.getId()}; //���ͻ�Աid�����object����
		DB mydb=new DB(); //�����µ����ݿ�����
		try
		{
			mydb.doPstm(sql, params); //���÷���
			ResultSet rs=mydb.getRs(); //��Rs��ֵ��rs
			while(rs.next()) //�жϽ����
			{
				Torder order=new Torder(); //�������
				
				order.setId(rs.getInt("id")); //��ֵ
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
				
				
				orderList.add(order); //��order��ӵ�������
		    }
			rs.close(); //�رս����
		}
		catch(Exception e) //�쳣
		{
			e.printStackTrace(); //ִ�з����������쳣
		}
		mydb.closed(); //�ر����ݿ�����
		
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
		
		req.setAttribute("msg", "¼�����");
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
