package uprm.icom5016.dtos;

public class ReturnedProduct extends Product{
	
	private String quantity2Return;
	private String purchasedPrice;
	private String quantityPurchased;
	


	public ReturnedProduct(Product p) {
		super(p.getPid(), p.getCategory(), p.getSubcat(), p.getPname(), p.getPrice(), p.getPicLink(), p.getBrand(), p.getStock(), p.getDescription(),
			p.getModel());
	}

	public String getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(String quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}

	public String getQuantity2Return() {
		return quantity2Return;
	}

	public void setQuantity2Return(String quantity2Return) {
		this.quantity2Return = quantity2Return;
	}

	public void setPurchasedPrice(String purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}

	public String getPurchasedPrice() {
		return purchasedPrice;
	}
}
