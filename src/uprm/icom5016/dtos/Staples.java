package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Staples extends Product{

	private String size,quantity;

	public Staples() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staples(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String size, String quantity) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub

		this.size=size;
		this.quantity=quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("size");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Size");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("size")){
			return getSize();
		}
		else{
			return "";
		}
	}
}
