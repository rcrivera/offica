package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Markers extends Product {

	private String point;
	private String color;
	private String quantity;

	public Markers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Markers(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String point, String color, String quantity) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.point=point;
		this.color=color;
		this.quantity=quantity;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
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
		toReturn.add("point");
		toReturn.add("color");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Point");
		toReturn.add("Color");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("point")){
			return getPoint();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else{
			return "";
		}
	}
}
