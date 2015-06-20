package com.kdyzm.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println(arg0.getSource()+" session��������");
		ServletContext sc=arg0.getSession().getServletContext();
		List<HttpSession>list=(List<HttpSession>) sc.getAttribute("userlist");
		if(list==null)
		{
			list=new ArrayList<HttpSession>();
		}
		list.add(arg0.getSession());
		sc.setAttribute("userlist", list);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println(arg0.getSession().getId()+" �˳���");
		//�˳���ʱ����Ҫ����session��userlist��ɾ��
		HttpSession session=arg0.getSession();
		String sessionid=session.getId();
		List<HttpSession>list=(List<HttpSession>) arg0.getSession().getServletContext().getAttribute("userlist");
		list.remove(session);
	}
}
