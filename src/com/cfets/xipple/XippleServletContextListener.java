package com.cfets.xipple;

import com.cfets.xipple.core.Request;
import com.cfets.xipple.endpoint.XippleWebSocketClient;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

/**
 * Created by ZYC on 2016/5/24.
 */

public class XippleServletContextListener implements ServletContextListener {

    private XippleWebSocketClient ws;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ws = new XippleWebSocketClient();
        //ws.connect("ws://192.168.214.63:6666");
        ws.connect("wss://s1.ripple.com");
        ws.send(new Request("server_info"));
        //ws.createPayment();
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
