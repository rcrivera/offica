package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Laptops extends Product{

	private String memory,screensize,os,processor,harddrive;
	

	public Laptops() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptops(String pid, String category, String subcat, String pname,
			String price, String picLink, String brand, Integer stock,
			String description, String model, String memory, String screensize, String os, String processor, String harddrive) {
		super(pid, category, subcat, pname, price, picLink, brand, stock, description,
				model);
		// TODO Auto-generated constructor stub
		this.memory=memory;
		this.screensize=screensize;
		this.os=os;
		this.processor=processor;
		this.harddrive=harddrive;
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

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getHarddrive() {
		return harddrive;
	}

	public void setHarddrive(String harddrive) {
		this.harddrive = harddrive;
	}
	
	public ArrayList<String> getSpecificAttributes(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("memory");
		toReturn.add("screensize");
		toReturn.add("os");
		toReturn.add("harddrive");
		toReturn.add("processor");
		return toReturn;
	}
	
	public ArrayList<String> getSpecificAttributesNames(){
		ArrayList<String> toReturn = new ArrayList<String>();
		toReturn.add("Memory");
		toReturn.add("Screensize");
		toReturn.add("OS");
		toReturn.add("Hard Drive");
		toReturn.add("Processor");
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
		else if(x.equalsIgnoreCase("harddrive")){
			return getHarddrive();
		}
		else if(x.equalsIgnoreCase("processor")){
			return getProcessor();
		}
		else{
			return "";
		}
	}

}
