package shopping_cart;

public class ProductNotFoundException extends Exception 
{
	private static final long serialVersionUID = 4819422030734281718L;
	
	public ProductNotFoundException(){}

	public ProductNotFoundException(String msg) 
	{
		super(msg);
	}
}
