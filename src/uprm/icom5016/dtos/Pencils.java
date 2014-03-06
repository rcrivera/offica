package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Pencils extends Product{

	private String point,type;
	private String quantity;

	public Pencils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pencils(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String point, String quantity, String type) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.point=point;
		this.quantity=quantity;
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
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
		toReturn.add("type");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Point");
		toReturn.add("Type");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("point")){
			return getPoint();
		}
		else if(x.equalsIgnoreCase("type")){
			return getType();
		}
		else{
			return "";
		}

	}
}
