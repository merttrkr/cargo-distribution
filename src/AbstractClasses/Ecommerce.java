package AbstractClasses;
import Interface.IECommerce;
import Interface.STATUS;
//Abstract class which has all the common attributes of E-commerce cargos.
public abstract class Ecommerce<CodeFormat> extends Cargo implements IECommerce<CodeFormat> {

	private String siteName;
	
	private int dailyLimit;
	private STATUS status;
	private CodeFormat cargoCode;

	public Ecommerce(String siteName,CodeFormat cargoCode, int weight,int width,int length ,int height) {
		
		super("Ecommerce" ,weight,width,length,height );
		this.siteName = siteName;
		this.cargoCode = cargoCode;
		   
	}
	
	@Override
	public String toString() {
		
		
		return siteName + "    " + cargoCode  +"       " +  status +"      " +  size() +"      " +  deliveryday();
	}
	//this method will be overridden in subclasses
	public boolean CargoCodeValid(CodeFormat cargoCode){
		return false;
    }
	
	
	
	//getter setters
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public int getDailyLimit() {
		return dailyLimit;
	}


	public void setDailyLimit(int dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}
	public CodeFormat getCargoCode() {
		return cargoCode;
	}

	public void setCargoCode(CodeFormat cargoCode) {
		this.cargoCode = cargoCode;
	}


}
