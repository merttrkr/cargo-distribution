package CargoTypes;
import AbstractClasses.Ecommerce;

public class N11 extends Ecommerce<String>{

	public N11(String siteName, String cargoCode, int weight, int width, int length, int height) {
		super(siteName, cargoCode, weight, width, length, height);
		
	}

	@Override
	public int getDailyLimit() {
		return 6;
	}
	
	@Override
	public boolean CargoCodeValid(String cargoCode) {
		 if (cargoCode.length() == 7) {
	            return true;}
	        else return false;
		}


}
