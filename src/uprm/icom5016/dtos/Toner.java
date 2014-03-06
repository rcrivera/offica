package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Toner extends Product{

	private String color,maxyield;
	

	public Toner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Toner(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String color, String maxyield) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.color=color;
		this.maxyield = maxyield;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaxyield() {
		return maxyield;
	}

	public void setMaxyield(String maxyield) {
		this.maxyield = maxyield;
	}
	
	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("maxyield");
		toReturn.add("color");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Max Yield");
		toReturn.add("Color");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("maxyield")){
			return getMaxyield();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else{
			return "";
		}
	}
	
}
