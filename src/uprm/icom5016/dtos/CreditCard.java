package uprm.icom5016.dtos;

public class CreditCard {

	private String ccnumber;
	private String cardHolder;
	private String cType;
	private String expMonth;
	private String expYear;
	private String cvv;
	private String username;
	
	

	public CreditCard(String ccnumber, String cardHolder, String cType, String expMonth, String expYear, String cvv, String username) {
		super();
		this.ccnumber = ccnumber;
		this.cardHolder = cardHolder;
		this.cType = cType;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.cvv = cvv;
		this.username = username;
	}


	public CreditCard() {
		// TODO Auto-generated constructor stub
	}


	public String getCardHolder() {
		return cardHolder;
	}


	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}


	public String getExpMonth() {
		return expMonth;
	}


	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}


	public String getExpYear() {
		return expYear;
	}


	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}


	public String getCcnumber() {
		return ccnumber;
	}


	public void setCcnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}


	public String getcType() {
		return cType;
	}


	public void setcType(String cType) {
		this.cType = cType;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	
	public void setUsername(String username){
		this.username = username;
	}
	
	
	public String getUsername() {
		return username;
	}
		
	
}
