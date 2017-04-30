package shopping_cart;

import java.util.Collection;

public interface IOrder 
{
	boolean addProduct(Product P);
	boolean removeProduct(String id) throws ProductNotFoundException;
	Collection<Product> getCartDetails();
	
	Product getProductFromCart(String id) throws ProductNotFoundException;
	int productCount();
	double getCartPrice();
}
