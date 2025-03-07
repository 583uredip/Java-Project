package controllers;
import java.lang.*;
import models.*;

public class ClientController
{
	public void insertClient(Client cli)
	{
		Client clients[]=this.getAllClient();
		
		for(int i=0;i<clients.length;i++)
		{
			if(clients[i]==null)
			{
				clients[i]=cli;
				break;
			}
		}
		
		this.write(clients);
	}
	
	public void updateClient(Client cli)
	{
		Client clients[]=this.getAllClient();
		
		for(int i=0;i<clients.length;i++)
		{
			if(clients[i]!=null)
			{
				if(clients[i].getUserId().equals(cli.getUserId()))
				{
					clients[i]=cli;
				}
			}
			
		}
            this.write(clients);
	}
	
	
	public void deleteClient(String userId)
	{
		Client clients[]=this.getAllClient();
		
		for(int i=0;i<clients.length;i++)
		{
			if(clients[i]!=null)
			{
				if(clients[i].getUserId().equals(userId))
				{
					clients[i]=null;
				}
			}
		}
		
		this.write(clients);
	}
	
	public Client searchClient(String usarId)
	{
		Client clients[]=this.getAllClient();
		
		for(int i=0;i<clients.length;i++)
		{
			if(clients[i]!=null)
			{
				if(clients[i].getUserId().equals(usarId))
				{
					return clients[i];
				}
			}
		}
		
		return null;
	}
	
	
	public Client[] getAllClient() {
		String fileName = "C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\controllers\\data\\Client.txt";
		FileIO fie = new FileIO();
	
		String[] data = fie.readFile(fileName);
		Client[] clients = new Client[100];
	
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null && !data[i].isEmpty()) {
				Client cli = new Client();
				clients[i] = cli.fromClient(data[i]); // Create a new Client object for each entry
			}
		}
	
		return clients;
	}

	
	public void write(Client clients[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(clients[i]!=null)
			{
				data[i]=clients[i].toStringClient();
			}
		}
		
		String fileName="C:\\Users\\HP\\Desktop\\java Project\\Cryptocurrency management system.java - Copy\\Cryptocurrency management system.java\\Cryptocurrency management system.java\\controllers\\data\\Client.txt";
		FileIO fie=new FileIO();
		fie.writeFile(fileName, data);
	}
}