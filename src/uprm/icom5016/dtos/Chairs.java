package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Chairs extends Product{

	private String color,arms,material;

	public Chairs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chairs(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String color, String arms, String material) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.color=color;
		this.arms=arms;
		this.material=material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getArms() {
		return arms;
	}

	public void setArms(String arms) {
		this.arms = arms;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("arms");
		toReturn.add("color");
		toReturn.add("material");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Arms");
		toReturn.add("Color");
		toReturn.add("Material");
		return toReturn;
	}
	
	public String getAtt(String x){
		if(x.equalsIgnoreCase("arms")){
			return getArms();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else if(x.equalsIgnoreCase("material")){
			return getMaterial();
		}
		else{
			return "";
		}
	}
}
