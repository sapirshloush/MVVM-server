package viewmodel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Model;

public class MyServer extends Observable implements Observer,Viewmodel
{
	private int port;
	private ClientHandler ch;
	private volatile boolean stop;
	private ExecutorService executor;
	private Model model;
	
	public MyServer(int port,ClientHandler ch,Model model) 
	{
		this.port = port;
		this.ch = ch;
		stop = false;
		this.model=model;
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}








