package com.kdyzm.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		Object request=sre.getSource();
		System.out.println(request+"��������");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		Object request=sre.getSource();
		System.out.println(request+"�����٣�");
	}
}
