package uprm.icom5016.dtos;

import java.util.ArrayList;

public class StapleMachines extends Product {

	private String staplesize,type,color,nsheets;


	public StapleMachines() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StapleMachines(String pid, String category, String subcat,
			String pname, String price, String picLink, String brand,
			Integer stock, String description, String model, String staplesize, String color, String type, String nsheets) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.staplesize=staplesize;
		this.color=color;
		this.type=type;
		this.nsheets=nsheets;
	}

	public String getStaplesize() {
		return staplesize;
	}

	public void setStaplesize(String staplesize) {
		this.staplesize = staplesize;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNsheets() {
		return nsheets;
	}

	public void setNsheets(String nsheets) {
		this.nsheets = nsheets;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("size");
		toReturn.add("color");
		toReturn.add("type");
		toReturn.add("nsheets");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Size");
		toReturn.add("Color");
		toReturn.add("Type");
		toReturn.add("Sheets #");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("size")){
			return getStaplesize();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else if(x.equalsIgnoreCase("type")){
			return getType();
		}
		else if(x.equalsIgnoreCase("nsheets")){
			return getNsheets();
		}
		else{
			return "";
		}
	}
}
