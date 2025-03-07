package models;
import java.lang.*;

public class Transaction
{
  private String transactionId;
  private String userId;
  private String type;
  private double price;

  public Transaction()
 {

 }


public Transaction(String transactionId,String userId,String type,double price )
{
    this.transactionId=transactionId;
    this.userId=userId;
    this.type=type;
    this.price=price;
}
 
public void setTransactionId(String transactionId)
{
    this.transactionId=transactionId;
}
public String getTransactionId()
{
    return this.transactionId;
}
public void setUserId(String usarId)
{
    this.userId=usarId;
}
public String getUserId()
{
    return this.userId;
}
public void setType(String type)
{
    this.type=type;
}
public String getType()
{
    return this.type;
}
public void setPrice(double price)
{
    this.price=price;
}
public double getPrice()
{
    return this.price;
}

public String toStringTransaction()
{
    String str=this.transactionId+","+this.userId+","+this.type+","+this.price+"\n";
    return str;
}



public Transaction fromTransaction(String str) 
{
    String data[] = str.split(",");
    if (data.length < 4) { 
        throw new IllegalArgumentException("Invalid transaction data: " + str);
    }
    Transaction tr = new Transaction();
    tr.setTransactionId(data[0]);
    tr.setUserId(data[1]);
    tr.setType(data[2]);
    tr.setPrice(Double.parseDouble(data[3]));
    return tr;
}











}
