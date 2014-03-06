package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Checkout {
	
	User user;
	CreditCard ccard;
	ArrayList<Integer> quantity;
	ArrayList<Product> products;

	public Checkout(User user, CreditCard ccard, ArrayList<Integer> quantity,
			ArrayList<Product> products) {
		super();
		this.user = user;
		this.ccard = ccard;
		this.quantity = quantity;
		this.products = products;
	}
	public User getUser() {
		return user;
	}
	public CreditCard getCcard() {
		return ccard;
	}
	public ArrayList<Integer> getQuantity() {
		return quantity;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
}
