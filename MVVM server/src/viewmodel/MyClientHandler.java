package viewmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Observable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class MyClientHandler extends Observable implements ClientHandler
{
	
	public void handleClient(InputStream in, OutputStream out) 
	{
		try
		{
			while (true)
			{
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(in));
				PrintWriter writer = new PrintWriter(out);
				String request = inFromClient.readLine();
				
				
				Client client = ClientBuilder.newClient();		
				WebTarget webTarget = client.target("http://localhost:8080/HelloJersey/hello");
				
				Invocation.Builder invocationBuilder = webTarget.request();
				
				
				invocationBuilder.post(Entity.entity(request, MediaType.TEXT_PLAIN));
						
				
				Invocation.Builder invocationBuilder2 = webTarget.request();
				Response response = invocationBuilder2.get();	
				
				String msg = response.readEntity(String.class);
				System.out.println("Message from server: " + msg);	
				
			}
		}
		catch (Exception e) 
		{
			
		}
		
		finally
		{
			try
			{
				in.close();
				out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
