package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Mats extends Product {

	private String material,color,use;


	public Mats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mats(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String material, String color, String use) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.material=material;
		this.color=color;
		this.use=use;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}	

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("use");
		toReturn.add("color");
		toReturn.add("material");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Use");
		toReturn.add("Color");
		toReturn.add("Material");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("use")){
			return getUse();
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
