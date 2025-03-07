package controllers;
import java.lang.*;
import models.*;

public class BrokerController
{
	public void insertBroker(Broker bro)
	{
		Broker brokers[]=this.getAllBroker();
		
		for(int i=0;i<brokers.length;i++)
		{
			if(brokers[i]==null)
			{
				brokers[i]=bro;
				break;
			}
		}
		
		this.write(brokers);
	}
	
	public boolean updateBroker(Broker bro)
	{
		Broker brokers[]=this.getAllBroker();
		
		for(int i=0;i<brokers.length;i++)
		{
			if(brokers[i]!=null)
			{
				if(brokers[i].getUserId().equals(bro.getUserId()))
				{
					brokers[i]=bro;
				}
			}
		}
		   this.write(brokers);
				return false;
	}
	
	
	public void deleteBroker(String userId)
	{
		Broker brokers[]=this.getAllBroker();
		
		for(int i=0;i<brokers.length;i++)
		{
			if(brokers[i]!=null)
			{
				if(brokers[i].getUserId().equals(userId))
				{
					brokers[i]=null;
				}
			}
		}
		
		this.write(brokers);
	}
	
	public Broker searchBroker(String usarId)
	{
		Broker brokers[]=this.getAllBroker();
		
		for(int i=0;i<brokers.length;i++)
		{
			if(brokers[i]!=null)
			{
				if(brokers[i].getUserId().equals(usarId))
				{
					return brokers[i];
				}
			}
		}
		
		return null;
	}
	
	public Broker[] getAllBroker()
	{
		String fileName="controllers\\data\\Broker.txt";
		FileIO fie=new FileIO();
		
		String data[]=fie.readFile(fileName);
		Broker brokers[]=new Broker[100];
		Broker bro=new Broker();
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				if(brokers[i]==null)
				brokers[i]=bro.fromBroker(data[i]);
			}
		}
		
		return brokers;
	}
	
	public void write(Broker brokers[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(brokers[i]!=null)
			{
				data[i]=brokers[i].toStringBroker();
			}
		}
		
		String fileName="controllers\\data\\Broker.txt";
		FileIO fie=new FileIO();
		fie.writeFile(fileName, data);
	}
}