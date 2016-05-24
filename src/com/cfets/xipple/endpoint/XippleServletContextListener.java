package com.cfets.xipple.endpoint;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

/**
 * Created by ZYC on 2016/5/24.
 */
public class XippleServletContextListener implements ServletContextListener {

    XippleWebSocketClient ws;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ws = new XippleWebSocketClient("wss://s2.ripple.com");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (ws!=null){
            try {
                ws.Close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
