package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Labels extends Product implements ProductInterface{

	private String size;
	private String color;
	private String quantity;
	private String type;
	
	public Labels() {
	super();
	}

	public Labels(String pid, String category, String subcat,String pname, String price, String picLink,
			String brand, Integer stock, String description, String model, String size, String color,
			String quantity, String type){
		
		super(pid,  category,  subcat, pname,  price,  picLink,
				 brand,  stock,  description,  model);
		
		this.size = size;
		this.color = color;
		this.quantity = quantity;
		this.type = type;
		
	}
	
	public Labels(String size, String color,
			String quantity, String type){
		
		this.size = size;
		this.color = color;
		this.quantity = quantity;
		this.type = type;
		
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

	public void setQuantity(String i) {
		this.quantity = i;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("size");
		toReturn.add("color");
		toReturn.add("type");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Size");
		toReturn.add("Color");
		toReturn.add("Type");
		return toReturn;
	}
	
	public String getAtt(String x){
		if(x.equalsIgnoreCase("size")){
			return getSize();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else if(x.equalsIgnoreCase("type")){
			return getType();
		}
		else{
			return "";
		}
	}
	

}