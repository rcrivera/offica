package uprm.icom5016.dtos;

import java.util.ArrayList;

public class Product implements ProductInterface{

	private String pid;
	private String pname;
	private String price;
	private String picLink;
	private String brand;
	private Integer stock;
	private String description;
	private String model;
	private String category;
	private String subcat;
	
	public Product() {
		super();
	}
	

	public Product(String pid, String category, String subcat,String pname, String price, String picLink,
			String brand, Integer stock, String description, String model) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.picLink = picLink;
		this.brand = brand;
		this.stock = stock;
		this.description = description;
		this.model = model;
		this.category = category;
		this.subcat=subcat;
	}


	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category=category;
	}
	
	public String getSubcat(){
		return subcat;
	}
	
	public void setSubcat(String subcat){
		this.subcat=subcat;;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getPicLink() {
		return picLink;
	}


	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	@Override
	public ArrayList<String> getSpecificAttributes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getAtt(String x) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<String> getSpecificAttributesNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}