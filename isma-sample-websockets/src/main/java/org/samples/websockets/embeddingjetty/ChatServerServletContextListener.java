package org.samples.websockets.embeddingjetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation for start/stop Embedding Jetty
 * Server configured to manage Chat WebSocket with {@link org.samples.websockets.embeddingjetty.ChatWebSocketHandler}.
 * 
 */
public class ChatServerServletContextListener implements ServletContextListener {
	private Server server = null;

	/**
	 * Start Embedding Jetty server when WEB Application is started.
	 * 
	 */
	public void contextInitialized(ServletContextEvent event) {
		try {
			// 1) Create a Jetty server with the 8091 port.
			this.server = new Server(8081);
			// 2) Register ChatWebSocketHandler in the Jetty server instance.
			ChatWebSocketHandler chatWebSocketHandler = new ChatWebSocketHandler();
			chatWebSocketHandler.setHandler(new DefaultHandler());
			server.setHandler(chatWebSocketHandler);
			// 2) Start the Jetty server.
			server.start();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stop Embedding Jetty server when WEB Application is stopped.
	 */
	public void contextDestroyed(ServletContextEvent event) {
		if (server != null) {
			try {
				// stop the Jetty server.
				server.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
