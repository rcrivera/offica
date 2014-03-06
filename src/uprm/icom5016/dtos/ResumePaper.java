package uprm.icom5016.dtos;

import java.util.ArrayList;

public class ResumePaper extends Product{

	private String size,nsheets,quantity;
	

	public ResumePaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResumePaper(String pid, String category, String subcat,
			String pname, String price, String picLink, String brand,
			Integer stock, String description, String model, String size, String nsheets, String quantity) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.size=size;
		this.nsheets=nsheets;
		this.quantity=quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNsheets() {
		return nsheets;
	}

	public void setNsheets(String nsheets) {
		this.nsheets = nsheets;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("size");
		toReturn.add("nsheets");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Size");
		toReturn.add("Sheets #");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("size")){
			return getSize();
		}
		else if(x.equalsIgnoreCase("nsheets")){
			return getNsheets();
		}
		else{
			return "";
		}
	}
}
