package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Binders extends Product{
	
	String size,color,quantity,capacity;
	public Binders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Binders(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String size, String color, String capacity) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.size=size;
		this.color=color;
		this.capacity=capacity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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
		toReturn.add("size");
		toReturn.add("color");
		toReturn.add("capacity");
		return toReturn;
	}
	
	 public ArrayList<String> getSpecificAttributesNames(){
		 ArrayList<String> toReturn = new ArrayList<String>();
			toReturn.add("Size");
			toReturn.add("Color");
			toReturn.add("Capacity");
			return toReturn;
	 }
	 
	
	public String getAtt(String x){
		if(x.equalsIgnoreCase("size")){
			return getSize();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else if(x.equalsIgnoreCase("capacity")){
			return getCapacity();
		}
		else{
			return "";
		}
	}
	

}
