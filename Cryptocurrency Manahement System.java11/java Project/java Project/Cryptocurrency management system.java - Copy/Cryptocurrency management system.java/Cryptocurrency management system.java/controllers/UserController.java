package controllers;

import java.lang.*;
import models.*;

public class UserController
{
	public void insertUser(User us)
	{
		User users[]=this.getAllUser();
		
		for(int i=0;i<100;i++)
		{
			if(users[i]==null)
			{
				users[i]=us;
				break;
			}
		}
		
		this.write(users);
	}
	
	public void updateUser(User us)
	{
		User users[]=this.getAllUser();
		
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(us.getUserId()))
				{
					users[i]=us;
				}
			}
		}
		this.write(users);
	}
	
	
	public void deleteUser(String userId)
	{
		User users[]=this.getAllUser();
		
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(userId))
				{
					users[i]=null;
				}
			}
		}
		
		this.write(users);
	}
	
	public User searchUser(String userId)
	{
		User users[]=this.getAllUser();
		
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(userId))
				{
					return users[i];
				}
			}
		}
		
		return null;
	}
	
	public User[] getAllUser()
	{
		String fileName="controllers\\data\\Users.txt";
		FileIO fie=new FileIO();
		
		String data[]=fie.readFile(fileName);
		User users[]=new User[100];
		//User us=new User();
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				if(users[i]==null)
				users[i]=new User().fromUser(data[i]);
			}
		}
		
		return users;
	}
	
	public void write(User users[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(users[i]!=null)
			{
				data[i]=users[i].toStringUser();
			}
		}
		
		String fileName="controllers\\data\\Users.txt";
		FileIO fie=new FileIO();
		fie.writeFile(fileName, data);
	}

    }