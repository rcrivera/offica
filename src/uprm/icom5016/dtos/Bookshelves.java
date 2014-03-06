package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Bookshelves extends Product {

	private String color,nshelves,material,size;
	

	public Bookshelves() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookshelves(String pid, String category, String subcat,
			String pname, String price, String picLink, String brand,
			Integer stock, String description, String model, String color, String nshelves, String material, String size) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.color=color;
		this.nshelves=nshelves;
		this.material=material;
		this.size=size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNshelves() {
		return nshelves;
	}

	public void setNshelves(String nshelves) {
		this.nshelves = nshelves;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("size");
		toReturn.add("color");
		toReturn.add("material");
		toReturn.add("nshelves");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Size");
		toReturn.add("Color");
		toReturn.add("Material");
		toReturn.add("Shelves #");
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
		else if(x.equalsIgnoreCase("nshelves")){
			return getNshelves();
		}
		else{
			return "";
		}
	}
	
}
