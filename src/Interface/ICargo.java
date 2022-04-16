package Interface;

public interface ICargo{
	enum DAYS {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY , SUNDAY}
	public DAYS deliveryday();//calculates delivery day with system date
	public int deci();
	public int size();
	public int getWeight();
	public int getWidth() ;
	public int getLength() ;
	public int getHeight();
	public String getType();
	
	
	
}
