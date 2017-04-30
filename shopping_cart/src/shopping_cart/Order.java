package shopping_cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Order implements IOrder
{
	public String id;
	private Map<String, Product> map;
	
	public Order(){}
	
	public Order(String id) 
	{
		this.id = id;
		map = new HashMap<String, Product>();
	}

	public boolean addProduct(Product p) 
	{
		if(map.containsKey(p.getId()))
		{
			Product p1 = map.get(p.getId());
			p1.setPrice(p1.getPrice() + p.getPrice());
			p1.setQty(p1.getQty() + p.getQty());
			return true;
		}
		map.put(p.getId(), p);
		return false;
	}
	
	public boolean removeProduct(String id) throws ProductNotFoundException 
	{
		if(map.containsKey(id))
		{
			map.remove(id);
			return true;
		}
		else throw new ProductNotFoundException("Product with id " + id + " not found");
	}

	public Collection<Product> getCartDetails() 
	{
		return map.values();
	}

	public Product getProductFromCart(String id) throws ProductNotFoundException 
	{
		if(map.containsKey(id))
		{
			return map.get(id);
		}
		else throw new ProductNotFoundException("Product with id " + id + " not found");
	}

	public int productCount() 
	{
		return map.size();
	}

	public double getCartPrice() 
	{
		double price = 0.0d;
		Iterator<Product> iterator = getCartDetails().iterator();
		while(iterator.hasNext())
		{
			price += iterator.next().getPrice();
		}
		return price;
	}

}
