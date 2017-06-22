package viewmodel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer
{
	private int port;
	private ClientHandler ch;
	private volatile boolean stop;
	private ExecutorService executor;
	
	
	public MyServer(int port,ClientHandler ch) 
	{
		this.port = port;
		this.ch = ch;
		stop = false;
		executor = Executors.newCachedThreadPool();
	}
	
	private void runServer() throws Exception 
	{
		ServerSocket server = new ServerSocket(port);
		while(!stop)
		{
			try
			{
				Socket aClient = server.accept();
				executor.execute(new Runnable() 
				{ 
					public void run() {
						try{
							ch.handleClient(aClient.getInputStream(), aClient.getOutputStream());
							aClient.getInputStream().close();
							aClient.getOutputStream().close();
							aClient.close();
						} catch(IOException e) {}
					}
				});
			}catch(SocketTimeoutException e) {}
		}
		server.close();
	}
	
	public void start(){
		new Thread(new Runnable() {
			public void run() {
				try{
					runServer();
				}
				catch(Exception e){}
			}
		}).start();
	}
	
	public void stop()
	{
		stop = true;
	}
}








