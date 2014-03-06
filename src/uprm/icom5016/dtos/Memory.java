package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Memory extends Product{

	private String capacity,type;
	

	public Memory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Memory(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String capacity, String type) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		
		this.capacity=capacity;
		this.type=type;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("capacity");
		toReturn.add("type");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Capacity");
		toReturn.add("Type");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("capacity")){
			return getCapacity();
		}
		else if(x.equalsIgnoreCase("type")){
			return getType();
		}
		else{
			return "";
		}
	}
}