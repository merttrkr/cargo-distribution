package CargoTypes;
import AbstractClasses.Ecommerce;

public class Trendyol extends Ecommerce<Integer> {
	
	public Trendyol(String siteName, Integer cargoCode, int weight, int width, int length, int height) {
		super(siteName, cargoCode, weight, width, length, height);
		
	}

	@Override
	public int getDailyLimit() {
		return 9;
	}
	
	@Override
	public boolean CargoCodeValid(Integer cargoCode) {
		if (String.valueOf(cargoCode).matches("[0-9]+") &&String.valueOf(cargoCode).length() == 8) {
            return true;
		}else {
			return false;
		}
		}
}
