package Interface;
public interface IECommerce<CodeFormat> {
	
	public String getSiteName();
	public int getDailyLimit();
	public STATUS getStatus();
	public CodeFormat getCargoCode();
	public boolean CargoCodeValid(CodeFormat cargoCode);
}
