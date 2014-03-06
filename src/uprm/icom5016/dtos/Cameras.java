package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Cameras extends Product{

	private String type,megapixels,opticalzoom;

	public Cameras() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cameras(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String type, String megapixels, String opticalzoom) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		
		this.type=type;
		this.megapixels=megapixels;
		this.opticalzoom=opticalzoom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMegapixels() {
		return megapixels;
	}

	public void setMegapixels(String megapixels) {
		this.megapixels = megapixels;
	}

	public String getOpticalzoom() {
		return opticalzoom;
	}

	public void setOpticalzoom(String opticalzoom) {
		this.opticalzoom = opticalzoom;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("ctype");
		toReturn.add("megapixels");
		toReturn.add("opticalzoom");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Type");
		toReturn.add("Megapixels");
		toReturn.add("Optical Zoom");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("camtype")){
			return getType();
		}
		else if(x.equalsIgnoreCase("megapixels")){
			return getMegapixels();
		}
		else if(x.equalsIgnoreCase("opticalzoom")){
			return getOpticalzoom();
		}
		else{
			return "";
		}
	}
	
}
