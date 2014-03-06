package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Erasers extends Product {

	private String quantity;

	public Erasers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Erasers(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String quantity) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub

		this.quantity=quantity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("quantity");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Quantity");	
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("quantity")){
			return getQuantity();
		}
		else{
			return "";
		}
	}
}
