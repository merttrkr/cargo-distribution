package CargoTypes;
import AbstractClasses.Ecommerce;

public class Amazon extends Ecommerce<Integer>  {
	
	
	
	
	public Amazon(String siteName, Integer cargoCode, int weight, int width, int length, int height) {
		super(siteName, cargoCode, weight, width, length, height);
		
	}
	
	
	@Override
	public int getDailyLimit() {
		return 5;
	}
	
	@Override //checks if the Cargo code is properly written.
	public boolean CargoCodeValid(Integer cargoCode) {
		  if (String.valueOf(cargoCode).matches("[0-9]+") && String.valueOf(cargoCode) .length() == 7) {
	            return true;}
	        else return false;
	}

}
