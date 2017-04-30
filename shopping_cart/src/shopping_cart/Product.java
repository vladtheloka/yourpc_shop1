package shopping_cart;

import java.io.Serializable;

public class Product implements Serializable
{
	private static final long serialVersionUID = -5274237359902191368L;
	public String id;
	public String name;
	public int qty;
	public double price;
	
	public Product(String id, String name, int qty, double price) 
	{
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getQty() 
	{
		return qty;
	}

	public void setQty(int qty) 
	{
		this.qty = qty;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

	@Override
	public String toString() 
	{
		String sep = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		buffer.append(sep);
		buffer.append("----- Product Detail ----- ");
		buffer.append(sep);
        buffer.append("\tId = ");
		buffer.append(id);
		buffer.append(sep);
		buffer.append("\tName = ");
		buffer.append(name);
		buffer.append(sep);
		buffer.append("\tQantity = ");
		buffer.append(qty);
		buffer.append(sep);
		buffer.append("\tPrice = ");
		buffer.append(price);
		buffer.append(sep);
		return buffer.toString();
	}
	
	
}
