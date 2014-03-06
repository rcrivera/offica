package uprm.icom5016.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uprm.icom5016.dtos.*;

public class ProductDAO {
	//On the search, just show the picture, name and price, Actually there are 15 fields
	private static final String SEARCH = "SELECT pid, category, subcat, pname, price, pic FROM Products WHERE lower(pname) LIKE ? or lower(description) LIKE ? or lower(subcat) LIKE ? or lower(brand) LIKE ?";
	private static final String BROWSE_CATEGORY = "SELECT pid, category, subcat, pname, price, pic FROM products WHERE category= ?";
	private static final String BROWSE_SUBCATEGORY = "SELECT pid, category, subcat, pname, price, pic FROM products where category= ? and subcat= ?";
	private static final String BROWSE_LABELS= "SELECT products.pid, pname, price, pic, size, color, ltype as type FROM products natural join labels";
	private static final String BROWSE_BOXES= "SELECT products.pid, pname, price, pic, size, color FROM products natural join boxes";
	private static final String BROWSE_FILEFOLDERS= "SELECT products.pid, pname, price, pic, size, color FROM products natural join filefolders";
	private static final String BROWSE_BINDERS= "SELECT products.pid, pname, price, pic, size, scapacity, color FROM products natural join binders";
	private static final String BROWSE_ENVELOPES= "SELECT products.pid, pname, price, pic, size, color FROM products natural join envelopes";
	private static final String BROWSE_CHAIRS= "SELECT products.pid, pname, price, pic, color, arms, material FROM products natural join chairs";
	private static final String BROWSE_BOOKSHELVES= "SELECT products.pid, pname, price, pic, size, color, material, nshelves FROM products natural join bookshelves";
	private static final String BROWSE_FILECABINETS= "SELECT products.pid, pname, price, pic, size, color, material, ftype as type FROM products natural join filecabinets";
	private static final String BROWSE_DESKS= "SELECT products.pid, pname, price, pic, size, color, material FROM products natural join desks";
	private static final String BROWSE_LAMPS= "SELECT products.pid, pname, price, pic, ltype as type, lightbulbtype FROM products natural join lamps";
	private static final String BROWSE_MATS= "SELECT products.pid, pname, price, pic, color, material, use FROM products natural join mats";
	private static final String BROWSE_STAPLES= "SELECT products.pid, pname, price, pic, size FROM products natural join staples";
	private static final String BROWSE_RUBBERBANDS= "SELECT products.pid, pname, price, pic, size, color FROM products natural join rubberbands";
	private static final String BROWSE_MARKERS= "SELECT products.pid, pname, price, pic, color, point FROM products natural join markers";
	private static final String BROWSE_PENCILS= "SELECT products.pid, pname, price, pic, point, ptype as type FROM products natural join pencils";
	private static final String BROWSE_PAPERCLIPS= "SELECT products.pid, pname, price, pic, quantity FROM products natural join paperclips";
	private static final String BROWSE_ERASERS= "SELECT products.pid, pname, price, pic, quantitye FROM products natural join erasers";
	private static final String BROWSE_PENS= "SELECT products.pid, pname, price, pic, point, color FROM products natural join pens";
	private static final String BROWSE_STAPLEMACHINES= "SELECT products.pid, pname, price, pic, size, color, smtype as type, nsheets FROM products natural join staplemachines";
	private static final String BROWSE_SANITIZER= "SELECT products.pid, pname, price, pic, volume FROM products natural join sanitizer";
	private static final String BROWSE_TISSUEPAPER= "SELECT products.pid, pname, price, pic, nsheets FROM products natural join tissuepaper";
	private static final String BROWSE_TRASHBAGS= "SELECT products.pid, pname, price, pic, capacity, color FROM products natural join trashbags";
	private static final String BROWSE_SOAP= "SELECT products.pid, pname, price, pic, volume FROM products natural join soap";
	private static final String BROWSE_DISINFECTANT= "SELECT products.pid, pname, price, pic, volume FROM products natural join disinfectant";
	private static final String BROWSE_PAPERTOWEL= "SELECT products.pid, pname, price, pic, size, nsheets FROM products natural join papertowel";
	private static final String BROWSE_INTERNALDISKS= "SELECT products.pid, pname, price, pic, capacity, rpm FROM products natural join internaldisks";
	private static final String BROWSE_INKCARTRIDGES= "SELECT products.pid, pname, price, pic, color, maxyield FROM products natural join inkcartridges";
	private static final String BROWSE_TONER= "SELECT products.pid, pname, price, pic, color, maxyield FROM products natural join toner";
	private static final String BROWSE_EXTERNALDISKS= "SELECT products.pid, pname, price, pic, capacity, rpm FROM products natural join externaldisks";
	private static final String BROWSE_MEMORY= "SELECT products.pid, pname, price, pic, capacity, mtype as type FROM products natural join memory";
	private static final String BROWSE_TABLETS= "SELECT products.pid, pname, price, pic, memory, screensize, os FROM products natural join tablets";
	private static final String BROWSE_LAPTOPS= "SELECT products.pid, pname, price, pic, memory, screensize, os, harddrive, processor FROM products natural join laptops";
	private static final String BROWSE_CALCULATORS= "SELECT products.pid, pname, price, pic, ctype as type FROM products natural join calculators";
	private static final String BROWSE_PRINTERS= "SELECT products.pid, pname, price, pic, ptype as type FROM products natural join printers";
	private static final String BROWSE_DESKTOPS= "SELECT products.pid, pname, price, pic, memory, os, harddrive, processor FROM products natural join desktops";
	private static final String BROWSE_CAMERAS= "SELECT products.pid, pname, price, pic, ctype as type, megapixels,opticalzoom FROM products natural join cameras";
	private static final String BROWSE_COPYPAPER= "SELECT products.pid, pname, price, pic, size, nsheets FROM products natural join copypaper";
	private static final String BROWSE_RESUMEPAPER= "SELECT products.pid, pname, price, pic, size, nsheets FROM products natural join resumepaper";
	private static final String BROWSE_BUSINESSPAPER= "SELECT products.pid, pname, price, pic, size, nsheets FROM products natural join businesspaper";
	private static final String BROWSE_PHOTOPAPER= "SELECT products.pid, pname, price, pic, size, nsheets FROM products natural join photopaper";
	private static final String GET_PRODUCT="SELECT pid, category, subcat, pname, price, pic,model,description,stock,brand FROM products where pid = ?";

//	private static final String ADD_NEW_PRODUCT = "INSERT INTO products values(?,?,?,?,?,?,?,?,?,?) RETURNING pid";
	private static final String ADD_NEW_PRODUCT  ="INSERT INTO products values(?,?,?,?,?,?,?,?,?,CAST ((?) AS money)) RETURNING pid";


	public ProductDAO(){

	}
	public ArrayList<Product> browse(String cat, String subcat) throws DataSourceException{
		Connection conn = null;
		ArrayList<Product> result = new ArrayList<Product>();
		PreparedStatement stmt;
		try {
			conn = DataSource.getInstance().getJDBCConnection();
			if(cat.equalsIgnoreCase(subcat)){
				stmt = conn.prepareStatement(BROWSE_CATEGORY);
				stmt.setString(1, cat);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()){
					Product temp = new Product();
					temp.setPid(rs.getString(1));
					temp.setCategory(rs.getString(2));
					temp.setSubcat(rs.getString(3));
					temp.setPname(rs.getString(4));
					temp.setPrice(rs.getString(5));
					temp.setPicLink(rs.getString(6));
					result.add(temp);
				}
				return result;
			}
			else{
				if(subcat.equalsIgnoreCase("labels")){
					stmt = conn.prepareStatement(BROWSE_LABELS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Labels temp = new Labels();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setType(rs.getString(7));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("boxes")){
					stmt = conn.prepareStatement(BROWSE_BOXES);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Boxes temp = new Boxes();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("filefolders")){
					stmt = conn.prepareStatement(BROWSE_FILEFOLDERS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						FileFolders temp = new FileFolders();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("binders")){
					stmt = conn.prepareStatement(BROWSE_BINDERS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Binders temp = new Binders();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setCapacity(rs.getString(6));
						temp.setColor(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("envelopes")){
					stmt = conn.prepareStatement(BROWSE_ENVELOPES);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Envelopes temp = new Envelopes();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("chairs")){
					stmt = conn.prepareStatement(BROWSE_CHAIRS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Chairs temp = new Chairs();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setColor(rs.getString(5));
						temp.setArms(rs.getString(6));
						temp.setMaterial(rs.getString(7));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("bookshelves")){
					stmt = conn.prepareStatement(BROWSE_BOOKSHELVES);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Bookshelves temp = new Bookshelves();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setMaterial(rs.getString(7));
						temp.setNshelves(rs.getString(8));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("filecabinets")){
					stmt = conn.prepareStatement(BROWSE_FILECABINETS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						FileCabinets temp = new FileCabinets();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setMaterial(rs.getString(7));
						temp.setType(rs.getString(8));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("desks")){
					stmt = conn.prepareStatement(BROWSE_DESKS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Desks temp = new Desks();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setMaterial(rs.getString(7));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("lamps")){
					stmt = conn.prepareStatement(BROWSE_LAMPS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Lamps temp = new Lamps();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setType(rs.getString(5));
						temp.setLightbulbtype(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("mats")){
					stmt = conn.prepareStatement(BROWSE_MATS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Mats temp = new Mats();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setColor(rs.getString(5));
						temp.setMaterial(rs.getString(6));
						temp.setUse(rs.getString(7));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("staples")){
					stmt = conn.prepareStatement(BROWSE_STAPLES);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Staples temp = new Staples();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("printers")){
					stmt = conn.prepareStatement(BROWSE_PRINTERS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Printers temp = new Printers();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setType(rs.getString(5));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("rubberbands")){
					stmt = conn.prepareStatement(BROWSE_RUBBERBANDS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						RubberBands temp = new RubberBands();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("markers")){
					stmt = conn.prepareStatement(BROWSE_MARKERS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Markers temp = new Markers();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setColor(rs.getString(5));
						temp.setPoint(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("pencils")){
					stmt = conn.prepareStatement(BROWSE_PENCILS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Pencils temp = new Pencils();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setPoint(rs.getString(5));
						temp.setType(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("paperclips")){
					stmt = conn.prepareStatement(BROWSE_PAPERCLIPS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						PaperClips temp = new PaperClips();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("erasers")){
					stmt = conn.prepareStatement(BROWSE_ERASERS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Erasers temp = new Erasers();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("pens")){
					stmt = conn.prepareStatement(BROWSE_PENS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Pens temp = new Pens();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setPoint(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("staplemachines")){
					stmt = conn.prepareStatement(BROWSE_STAPLEMACHINES);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						StapleMachines temp = new StapleMachines();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setStaplesize(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setType(rs.getString(7));
						temp.setNsheets(rs.getString(8));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("sanitizer")){
					stmt = conn.prepareStatement(BROWSE_SANITIZER);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Sanitizer temp = new Sanitizer();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setVolume(rs.getString(5));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("tissuepaper")){
					stmt = conn.prepareStatement(BROWSE_TISSUEPAPER);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						TissuePaper temp = new TissuePaper();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setNsheets(rs.getString(5));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("trashbags")){
					stmt = conn.prepareStatement(BROWSE_TRASHBAGS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						TrashBags temp = new TrashBags();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setCapacity(rs.getString(5));
						temp.setColor(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("soap")){
					stmt = conn.prepareStatement(BROWSE_SOAP);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Soap temp = new Soap();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setVolume(rs.getString(5));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("disinfectant")){
					stmt = conn.prepareStatement(BROWSE_DISINFECTANT);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Disinfectant temp = new Disinfectant();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setVolume(rs.getString(5));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("papertowel")){
					stmt = conn.prepareStatement(BROWSE_PAPERTOWEL);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						PaperTowels temp = new PaperTowels();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setNsheets(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("internaldisks")){
					stmt = conn.prepareStatement(BROWSE_INTERNALDISKS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						InternalDisks temp = new InternalDisks();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setCapacity(rs.getString(5));
						temp.setRpm(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("inkcartridges")){
					stmt = conn.prepareStatement(BROWSE_INKCARTRIDGES);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						InkCartridges temp = new InkCartridges();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setColor(rs.getString(5));
						temp.setMaxyield(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("toner")){
					stmt = conn.prepareStatement(BROWSE_TONER);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Toner temp = new Toner();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setColor(rs.getString(5));
						temp.setMaxyield(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("externaldisks")){
					stmt = conn.prepareStatement(BROWSE_EXTERNALDISKS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						ExternalDisks temp = new ExternalDisks();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setCapacity(rs.getString(5));
						temp.setRpm(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("memory")){
					stmt = conn.prepareStatement(BROWSE_MEMORY);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Memory temp = new Memory();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setCapacity(rs.getString(5));
						temp.setType(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("tablets")){
					stmt = conn.prepareStatement(BROWSE_TABLETS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Tablets temp = new Tablets();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setMemory(rs.getString(5));
						temp.setScreensize(rs.getString(6));
						temp.setOs(rs.getString(7));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("laptops")){
					stmt = conn.prepareStatement(BROWSE_LAPTOPS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Laptops temp = new Laptops();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setMemory(rs.getString(5));
						temp.setScreensize(rs.getString(6));
						temp.setOs(rs.getString(7));
						temp.setHarddrive(rs.getString(8));
						temp.setProcessor(rs.getString(9));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("calculators")){
					stmt = conn.prepareStatement(BROWSE_CALCULATORS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Calculators temp = new Calculators();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setType(rs.getString(5));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("desktops")){
					stmt = conn.prepareStatement(BROWSE_DESKTOPS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Desktops temp = new Desktops();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setMemory(rs.getString(5));
						temp.setOs(rs.getString(6));
						temp.setHarddrive(rs.getString(7));
						temp.setProcessor(rs.getString(8));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("cameras")){
					stmt = conn.prepareStatement(BROWSE_CAMERAS);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						Cameras temp = new Cameras();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setType(rs.getString(5));
						temp.setMegapixels(rs.getString(6));
						temp.setOpticalzoom(rs.getString(7));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("copypaper")){
					stmt = conn.prepareStatement(BROWSE_COPYPAPER);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						CopyPaper temp = new CopyPaper();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setNsheets(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("resumepaper")){
					stmt = conn.prepareStatement(BROWSE_RESUMEPAPER);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						ResumePaper temp = new ResumePaper();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setNsheets(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}

				else if(subcat.equalsIgnoreCase("businesspaper")){
					stmt = conn.prepareStatement(BROWSE_BUSINESSPAPER);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						BusinessPaper temp = new BusinessPaper();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setNsheets(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}
				else {//(subcat.equalsIgnoreCase("photopaper"))
					stmt = conn.prepareStatement(BROWSE_PHOTOPAPER);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()){
						PhotoPaper temp = new PhotoPaper();
						temp.setPid(rs.getString(1));
						temp.setPname(rs.getString(2));
						temp.setPrice(rs.getString(3));
						temp.setPicLink(rs.getString(4));
						temp.setSize(rs.getString(5));
						temp.setNsheets(rs.getString(6));
						temp.setSubcat(subcat);
						result.add(temp);
					}
					return result;
				}
			}
		}
		catch(Exception e){
			throw new DataSourceException("Unable to read data from data source. ", e);
		}
		finally {
			if (conn != null){
				try {
					conn.close();
				}
				catch(Exception e2){

				}
			}
		}
	}

	public ArrayList<Product> getSearch(String toSearch) throws DataSourceException{
		Connection conn = null;
		ArrayList<Product> result = new ArrayList<Product>();
		String param = "%"+toSearch.toLowerCase()+"%";
		try {
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(SEARCH);
			stmt.setString(1, param);
			stmt.setString(2, param);
			stmt.setString(3, param);
			stmt.setString(4, param);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()){
				Product temp = new Product();
				temp.setPid(rs.getString(1));
				temp.setCategory(rs.getString(2));
				temp.setSubcat(rs.getString(3));
				temp.setPname(rs.getString(4));
				temp.setPrice(rs.getString(5));
				temp.setPicLink(rs.getString(6));
				result.add(temp);
			}
			return result;
		}
		catch(Exception e){
			throw new DataSourceException("Unable to read data from data source. ", e);
		}
		finally {
			if (conn != null){
				try {
					conn.close();
				}
				catch(Exception e2){

				}
			}
		}
	}
	//pid, category, subcat, pname, price pic,model,description,stock
	public Product getProduct(String pid) throws DataSourceException{
		Connection conn = null;
		Product result = new Product();
		try {
			conn = DataSource.getInstance().getJDBCConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_PRODUCT);
			stmt.setString(1, pid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				result.setPid(rs.getString(1));
				result.setCategory(rs.getString(2));
				result.setSubcat(rs.getString(3));
				result.setPname(rs.getString(4));
				result.setPrice(rs.getString(5));
				result.setModel(rs.getString(7));
				result.setPicLink(rs.getString(6));
				result.setDescription(rs.getString(8));
				result.setStock(rs.getInt(9));
				result.setBrand(rs.getString(10));
				return result;
			}
			return null;
		}
		catch(Exception e){
			throw new DataSourceException("Unable to read data from data source. ", e);
		}
		finally {
			if (conn != null){
				try {
					conn.close();
				}
				catch(Exception e2){

				}
			}
		}
	}
	
	public ProductStatus addProduct(Product product)
			throws DataSourceException {
		Connection conn = null;
		try {
			// first determine if student is valid
			ProductDAO productDAO = new ProductDAO();
			Product prd = productDAO.getProduct(product.getPid());
			if (prd != null){
				return ProductStatus.ProductAlreadyAdded;
			}
			conn = DataSource.getInstance().getJDBCConnection();
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(ADD_NEW_PRODUCT);
			// now the project name and language
			stmt.setString(1, product.getPid());
			stmt.setString(2, product.getSubcat());
			stmt.setString(3, product.getPname());
			stmt.setString(4, product.getPicLink());
			stmt.setString(5, product.getBrand());
			stmt.setString(6, product.getModel());
			stmt.setInt(7, product.getStock());
			stmt.setString(8, product.getDescription());
			stmt.setString(9, product.getCategory());
			stmt.setString(10,product.getPrice());
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()){
				throw new SQLException("Insert row count was not one.");
			}
			// Now get the autogenerated keys
			if (rs!=null){
				String pid = rs.getString(1);
				// use this value to make a second insert,
				// this time to table projectmember
				ArrayList<String> att = product.getSpecificAttributes();
				
				String ADD_NEW_SUBPRODUCT = "INSERT INTO "+product.getSubcat()+" (pid,";
				for(int i=0;i<att.size();i++){
					ADD_NEW_SUBPRODUCT = ADD_NEW_SUBPRODUCT + att.get(i);
					if(i+1==att.size())
						ADD_NEW_SUBPRODUCT = ADD_NEW_SUBPRODUCT+") VALUES(" +"\'"+product.getPid()+"\',";
					else
						ADD_NEW_SUBPRODUCT = ADD_NEW_SUBPRODUCT+",";
				}

				for(int i=0;i<att.size();i++){
					ADD_NEW_SUBPRODUCT = ADD_NEW_SUBPRODUCT+"\'"+product.getAtt(att.get(i))+"\'";
					if(i+1==att.size())
						ADD_NEW_SUBPRODUCT = ADD_NEW_SUBPRODUCT+") RETURNING pid";
					else
						ADD_NEW_SUBPRODUCT = ADD_NEW_SUBPRODUCT+",";
				}
				stmt = conn.prepareStatement(ADD_NEW_SUBPRODUCT);
				rs = stmt.executeQuery();
				if (!rs.next()){//status
					// Something is wrong, second insert failed, so abort whole transaction
					// Roll back the transaction and set the auto-commit behavior back.
					try {
						conn.rollback();
						conn.setAutoCommit(true);
					}
					catch(SQLException e){
					}
					throw new SQLException("Unable to get autogenered Keys");
				}
				else {
					// everything worked!
					// Commit the transaction 
					try {
						conn.commit();
					}
					catch(SQLException e){
						// Ops! Very last minute error. Abort
						try {
							conn.rollback();
							conn.setAutoCommit(true);
						}
						catch(SQLException e2){
							
						}
						throw new SQLException("Unable to commit transaction.", e);
					}
					// Set the auto-commit behavior back.
					try {
						conn.setAutoCommit(true);
					}
					catch(SQLException e){
						
					}

				}
				// We are done!
				return ProductStatus.OK;
			}
			else {
				// Something is wrong because we could not get the project id
				// Roll back the transaction and set the auto-commit behavior back.
				try {
					conn.rollback();
					conn.setAutoCommit(true);
				}
				catch(SQLException e){		
				}
				throw new SQLException("Cannot get autogenerated values.");
			}
		}
		catch(Exception e){
			throw new DataSourceException("Unable to insert data from data source. ", e);
		}
		finally {
			if (conn != null){
				try {
					conn.close();
				}
				catch(Exception e2){
					
				}
			}
		}
	}



}
