package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Calculators extends Product{

	private String type;

	public Calculators() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calculators(String pid, String category, String subcat,
			String pname, String price, String picLink, String brand,
			Integer stock, String description, String model, String type) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("ctype");
		return toReturn;
	}
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Type");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("ctype")){
			return getType();
		}
		else{
			return "";
		}
	}
}
