package controllers;
import java.lang.*;
import models.*;

public class AdminController
{
	public void insertAdmin(Admin ad)
	{
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i]==null)
			{
				admins[i]=ad;
				break;
			}
		}
		
		this.write(admins);
	}
	
	public void updateAdmin(Admin ad)
	{
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(ad.getUserId()))
				{
					admins[i]=ad;
				}
			}
		}
		   this.write(admins);
	}
	
	
	public void deleteAdmin(String usarId)
	{
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(usarId))
				{
					admins[i]=null;
				}
			}
		}
		
		this.write(admins);
	}
	
	public Admin searchAdmin(String userId)
	{
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(userId))
				{
					return admins[i];
				}
			}
		}
		
		return null;
	}
	
	public Admin[] getAllAdmin()
	{
		String fileName="controllers\\data\\Admin.txt";
		FileIO fie=new FileIO();
		String data[]=fie.readFile(fileName);
		Admin admins[]=new Admin[100];
		

		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				if(admins[i]==null)
				{
					admins[i]=new Admin().formAdmin(data[i]);
				}
				
			}
		}
		
		return admins;
	}
	
	public void write(Admin admins[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(admins[i]!=null)
			{
				data[i]=admins[i].toStringAdmin();
			}
		}
		
		String fileName="controllers\\data\\Admin.txt";
		FileIO fie=new FileIO();
		fie.writeFile(fileName, data);
	}
}