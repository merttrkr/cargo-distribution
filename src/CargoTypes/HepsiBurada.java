package CargoTypes;
import AbstractClasses.Ecommerce;

public class HepsiBurada extends Ecommerce<String> {

	public HepsiBurada(String siteName, String cargoCode, int weight, int width, int length, int height) {
		super(siteName, cargoCode, weight, width, length, height);
		
	}

	@Override
	public int getDailyLimit() {
		return 7;
	}
	@Override
	public boolean CargoCodeValid(String cargoCode) {
		if (cargoCode.length() == 8) {
            return true;}
        else return false;
	}


}
