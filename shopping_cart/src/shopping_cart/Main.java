package shopping_cart;

import java.util.Iterator;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) throws ProductNotFoundException
	{
		Order o = new Order("Loka");
		Scanner sc = new Scanner(System.in);
		
		int i;
		boolean status = true;
		
		while(status)
		{
			System.out.println("Press 1 to add new product\nPress 2 to remove product"
					+ "\nPress 3 to get product form cart\nPress 4 to get products count"
					+ "\nPress 5 to get cart price\nPress 6 to get cart details"
					+ "\nPress 0 to EXIT");
			i = sc.nextInt();
			switch(i)
			{
			case 1: 
				System.out.println("Enter product id, name, auantity and price");
				o.addProduct(new Product(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble()));
				break;
			case 2:
				System.out.println("Enter product id");
				o.removeProduct(sc.next());
				break;
			case 3:
				System.out.println("Enter product id");
				System.out.println(o.getProductFromCart(sc.next()));
				break;
			case 4:
				System.out.println(o.productCount());
				break;
			case 5:
				System.out.println("Cart Total : " + o.getCartPrice());
				break;
			case 6:
				final Iterator<Product> it = o.getCartDetails().iterator();
				while(it.hasNext())
				{		
					System.out.println (it.next());
				}
					break;
			case 0: 
				System.exit(0);
			}
		}
		sc.close();
	}
}
