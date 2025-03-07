package models;
import java.lang.*;
import java.util.List;

public class Cryptocurrency 
{
    private String cryptoid;
    private String name;
    private String symbol;
    private String categorry;
    private double currentPrice;
    private String details;
    public int length;
 

public Cryptocurrency()
{

}

public Cryptocurrency(String cryptoid,String name,String symbol,double currentPrice,String details)
{
    this.cryptoid=cryptoid;
    this.name=name;
    this.symbol=symbol;
    this.categorry=categorry;
    this.currentPrice=currentPrice;
    this.details=details;
}

public void setCryptoId(String cryptoid)
{
    this.cryptoid=cryptoid;
}
public String getCryptoId()
{
    return this.cryptoid;
}
public void setName(String name)
{
    this.name=name;
}
public String getName()
{
    return this.name;
}
public void setSymbol(String symbol)
{
    this.symbol=symbol;
}
public String getSymbol()
{
   return symbol;
}
public void setCategory(String category)
{
    this.categorry=category;
}
public String getCategory()
{
    return this.categorry;
}
public void setCurrentPrice(double currentPrice)
{
    this.currentPrice=currentPrice;
}
public double getCurrentPrice()
{
  return this.currentPrice;
}
public void setDetails(String details)
{
    this.details=details;
}
public String getDetails()
{
    return this.details;
}


public String toStringCryptocurrency()
{
    return this.cryptoid + "," + this.name + "," + this.symbol + "," + this.categorry + "," + this.currentPrice + "," + this.details + "\n";
}

public Cryptocurrency fromCryptocurrency(String str)
{
    String data[]=str.split(",");
    if(data.length<6)
    {
        throw new IllegalArgumentException("Tthis input is not corrert");
    }
    Cryptocurrency cr=new Cryptocurrency();
    cr.setCryptoId(data[0]);
    cr.setName(data[1]);
    cr.setSymbol(data[2]);
    cr.setCategory(data[3]);
    cr.setCurrentPrice(Double.parseDouble(data[4]));
    cr.setDetails(data[5]);
    return cr;
}

}