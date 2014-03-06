package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Soap extends Product {

	private String quantity,volume;


	public Soap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Soap(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String quantity, String volume) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.quantity=quantity;
		this.volume=volume;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("volume");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Volume");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("volume")){
			return getVolume();
		}
		else{
			return "";
		}

	}
}
