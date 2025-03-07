package controllers;
import java.lang.*;
import models.*;

public class TransactionController
{
	public void insertTransaction(Transaction tra)
	{
		Transaction transactions[]=this.getAllTransactions();
		
		for(int i=0;i<transactions.length;i++)
		{
			if(transactions[i]==null)
			{
				transactions[i]=tra;
				break;
			}
		}
		
		this.write(transactions);
	}
	
	public void updateTransaction(Transaction tra)
	{
	   Transaction transactions[]=this.getAllTransactions();
		
		for(int i=0;i<transactions.length;i++)
		{
			if(transactions[i]!=null)
			{
				if(transactions[i].getTransactionId().equals(tra.getTransactionId()))
				{
				   transactions[i]=tra;
				}
			}
			
		}
            this.write(transactions);
	}
	
	
	public void deleteTransaction(String transactionId )
	{
		Transaction transactions[]=this.getAllTransactions();
		
		for(int i=0;i<transactions.length;i++)
		{
			if(transactions[i]!=null)
			{
				if(transactions[i].getTransactionId().equals(transactionId))
				{
					transactions[i]=null;
				}
			}
		}
		
		this.write(transactions);
	}
	
	public Transaction searchTransaction(String transactionId)
	{
		Transaction transactions[]=this.getAllTransactions();
		
		for(int i=0;i<transactions.length;i++)
		{
			if(transactions[i]!=null)
			{
				if(transactions[i].getTransactionId().equals(transactionId))
				{
					return transactions[i];
				}
			}
		}
		
		return null;
	}
	
	public Transaction[] getAllTransactions()
	{
		String fileName="controllers/data/Transaction.txt";
		FileIO fie=new FileIO();
		String data[]=fie.readFile(fileName);
		Transaction transactions[]=new Transaction[100];
		Transaction tra=new Transaction();
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				if(transactions[i]==null)
				{
				transactions[i]=tra.fromTransaction(data[i]);
				}
			}
		}
		
		return transactions;
	}
	
	public void write(Transaction transactions[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(transactions[i]!=null)
			{
				data[i]=transactions[i].toStringTransaction();
			}
		}
		
		String fileName="controllers/data/Transaction.txt";
		FileIO fie=new FileIO();
		fie.writeFile(fileName, data);
	}
}