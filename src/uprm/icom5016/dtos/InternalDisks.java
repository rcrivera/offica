package uprm.icom5016.dtos;

import java.util.ArrayList;

public class InternalDisks extends Product{

	private String capacity,rpm;


	public InternalDisks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternalDisks(String pid, String category, String subcat,
			String pname, String price, String picLink, String brand,
			Integer stock, String description, String model, String capacity, String rpm) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.capacity=capacity;
		this.rpm=rpm;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getRpm() {
		return rpm;
	}

	public void setRpm(String rpm) {
		this.rpm = rpm;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("capacity");
		toReturn.add("rpm");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Capacity");
		toReturn.add("RPM");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("capacity")){
			return getCapacity();
		}
		else if(x.equalsIgnoreCase("rpm")){
			return getRpm();
		}
		else{
			return "";
		}

	}
}
