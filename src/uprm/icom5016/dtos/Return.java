package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Return {

	private String returnno;
	private String orderdate;
	private String orderno;
	private String reason;
	private ArrayList<ReturnedProduct> items = new ArrayList<ReturnedProduct>();
	private String date;
	private User user;
	private CreditCard card;
	
	
	
	public Return(String returnno, String orderno, String reason,
			ArrayList<ReturnedProduct> items, String date, User user, CreditCard card) {
		super();
		this.returnno = returnno;
		this.orderno = orderno;
		this.reason = reason;
		this.items = items;
		this.date = date;
		this.user = user;
		this.card = card;
	}



	public Return() {

	}



	public String getReturnno() {
		return returnno;
	}



	public String getOrderdate() {
		return orderdate;
	}



	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}



	public void setReturnno(String returnno) {
		this.returnno = returnno;
	}



	public String getOrderno() {
		return orderno;
	}



	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public ArrayList<ReturnedProduct> getItems() {
		return items;
	}



	public void setItems(ArrayList<ReturnedProduct> items) {
		this.items = items;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public CreditCard getCard() {
		return card;
	}



	public void setCard(CreditCard card) {
		this.card = card;
	}
		
	

}