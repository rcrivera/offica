package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Lamps extends Product{

	private String lightbulbtype,type;


	public Lamps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lamps(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String type, String lightbulbtype) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.type=type;
		this.lightbulbtype=lightbulbtype;

	}

	public String getLightbulbtype() {
		return lightbulbtype;
	}

	public void setLightbulbtype(String lightbulbtype) {
		this.lightbulbtype = lightbulbtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("ltype");
		toReturn.add("lightbulbtype");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Type");
		toReturn.add("Lightbulb Type");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("ltype")){
			return getType();
		}
		else if(x.equalsIgnoreCase("lightbulbtype")){
			return getLightbulbtype();
		}

		else{
			return "";
		}


	}
}
