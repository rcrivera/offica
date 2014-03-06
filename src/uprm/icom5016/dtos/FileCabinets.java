package uprm.icom5016.dtos;

import java.util.ArrayList;

public class FileCabinets extends Product {

	private String type,size,material,color;
	

	public FileCabinets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileCabinets(String pid, String category, String subcat,
			String pname, String price, String picLink, String brand,
			Integer stock, String description, String model, String type, String size, String material, String color) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.type=type;
		this.size=size;
		this.material=material;
		this.color=color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("size");
		toReturn.add("color");
		toReturn.add("material");
		toReturn.add("ftype");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Size");
		toReturn.add("Color");
		toReturn.add("Material");
		toReturn.add("Type");
		return toReturn;
	}
	
	public String getAtt(String x){
		if(x.equalsIgnoreCase("size")){
			return getSize();
		}
		else if(x.equalsIgnoreCase("color")){
			return getColor();
		}
		else if(x.equalsIgnoreCase("material")){
			return getMaterial();
		}
		else if(x.equalsIgnoreCase("ftype")){
			return getType();
		}
		else{
			return "";
		}
	}
	
}
