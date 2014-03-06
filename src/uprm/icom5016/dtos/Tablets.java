package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Tablets extends Product{

	private String memory,screensize,os;

	
	public Tablets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tablets(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String memory, String screensize, String os) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.memory=memory;
		this.screensize=screensize;
		this.os=os;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getScreensize() {
		return screensize;
	}

	public void setScreensize(String screensize) {
		this.screensize = screensize;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("memory");
		toReturn.add("screensize");
		toReturn.add("os");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Memory");
		toReturn.add("Screen Size");
		toReturn.add("OS");
		return toReturn;
	}

	public String getAtt(String x){
		if(x.equalsIgnoreCase("memory")){
			return getMemory();
		}
		else if(x.equalsIgnoreCase("screensize")){
			return getScreensize();
		}
		else if(x.equalsIgnoreCase("os")){
			return getOs();
		}
		else{
			return "";
		}
	}
	
}
