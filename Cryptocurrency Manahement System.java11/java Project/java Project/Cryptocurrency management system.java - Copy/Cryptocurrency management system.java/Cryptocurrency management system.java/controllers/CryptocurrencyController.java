package controllers;
import java.lang.*;
import models.*;

public class CryptocurrencyController
{
  public void insertCryptocurrency(Cryptocurrency cryp)
   {
    Cryptocurrency cryptocurrencies []=this.getAllCryptocurrency();
    for(int i=0;i<cryptocurrencies.length;i++)
    {
        if(cryptocurrencies[i]==null)
        {
            cryptocurrencies[i]=cryp;
            break;
        }
        
    }
       this.write(cryptocurrencies);
   }

   


   public void updateCryptocurrency(Cryptocurrency cryp)
   {
    Cryptocurrency cryptocurrencies[]=this.getAllCryptocurrency();
    for(int i=0;i<cryptocurrencies.length;i++)
    {
        if(cryptocurrencies[i]!=null)
        {
           if(cryptocurrencies[i].getCryptoId().equals(cryp.getCryptoId()))
           {
            cryptocurrencies[i]=cryp;
           }
        
        }
        
    }
	      this.write(cryptocurrencies);
   }

   public void deleteCryptocurrency(String cryptoid)
	{
		Cryptocurrency cryptocurrencies []=this.getAllCryptocurrency();
		
		for(int i=0;i<cryptocurrencies.length;i++)
		{
			if(cryptocurrencies[i]!=null)
			{
				if(cryptocurrencies[i].getCryptoId().equals(cryptoid))
				{
					cryptocurrencies[i]=null;
				}
			}
		}
		
		this.write(cryptocurrencies);
	}

    public Cryptocurrency searchCryptocurrency(String cryptoid)
	{
		Cryptocurrency cryptocurrencies[]=this.getAllCryptocurrency();
		
		for(int i=0;i<cryptocurrencies.length;i++)
		{
			if(cryptocurrencies[i]!=null)
			{
				if(cryptocurrencies[i].getCryptoId().equals(cryptoid))
				{
					return cryptocurrencies[i];
				}
			}
		}
		
		return null;
	}
	
	public Cryptocurrency[] getAllCryptocurrency()
	{
		String fileName="controllers\\data\\Cryptocurrency.txt";
		FileIO fie=new FileIO();
		String data[]=fie.readFile(fileName);
		Cryptocurrency cryptocurrencies[]=new Cryptocurrency[data.length];
		Cryptocurrency cryp= new Cryptocurrency();
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null && !data[i].isEmpty())
			{
	            
				cryptocurrencies[i]=cryp.fromCryptocurrency(data[i]);
			
			}
		}
		
		return cryptocurrencies;
	}

   
	public void write(Cryptocurrency cryptocurrencies[]) {
		
		String data[] = new String[cryptocurrencies.length];
		
		
		for (int i = 0; i < cryptocurrencies.length; i++) 
		{
			if (cryptocurrencies[i] != null)
			 {
				data[i] = cryptocurrencies[i].toStringCryptocurrency();
			}
		}
		
		String fileName = "controllers\\data\\Cryptocurrency.txt";
		FileIO fie = new FileIO();
		fie.writeFile(fileName, data);
	}











	
}
	



	