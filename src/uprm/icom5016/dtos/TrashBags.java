package uprm.icom5016.dtos;

import java.util.ArrayList;

public class TrashBags extends Product{

	private String capacity,color,quantity;


	public TrashBags() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrashBags(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String capacity, String color, String quantity) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.capacity=capacity;
		this.color=color;
		this.quantity=quantity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("capacity");
		toReturn.add("color");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Capacity");
		toReturn.add("Color");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("capacity")){
			return getCapacity();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else{
			return "";
		}

	}
}
