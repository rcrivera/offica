package uprm.icom5016.dtos;

import java.util.ArrayList;

public class TissuePaper extends Product{

	private String quantity,nsheets;


	public TissuePaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TissuePaper(String pid, String category, String subcat,
			String pname, String price, String picLink, String brand,
			Integer stock, String description, String model, String quantity, String nsheets) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.quantity=quantity;
		this.nsheets=nsheets;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getNsheets() {
		return nsheets;
	}

	public void setNsheets(String nsheets) {
		this.nsheets = nsheets;
	}

	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("nsheets");
		return toReturn;
	}
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Sheets #");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("nsheets")){
			return getNsheets();
		}
		else{
			return "";
		}
	}
}
