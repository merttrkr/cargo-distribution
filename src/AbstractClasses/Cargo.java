package AbstractClasses;
import java.lang.Math;
import java.util.Date;

import Interface.ICargo;

//Abstract class which has all the common attributes of cargos.

public abstract class Cargo implements ICargo {
	
	private int weight;
	private int width;
	private int length;
	private int height;
	private String type;
	

	
	public Cargo() {// no arg constructor
		
		weight = 0;
		width = 0;
		length = 0;
		height = 0;
		
		
	}
	
	public Cargo(  String type,int weight,int width,int length ,int height ) {// full arg constructor
		this.type = type;
		this.weight = weight;
		this.width = width;
		this.length = length;
		this.height = height;
		
		
	}
	
	
	public int deci() {
		return  width*length*height/3000;
	}
	
	public int size() {
		int deci = deci();
		return  Math.max(deci, weight);
	}
	
	 @SuppressWarnings("deprecation")
	public DAYS deliveryday() {
			Date date=new Date();
			
			DAYS currentDay = DAYS.values()[date.getDay()];//gets the system date
			DAYS deliveryDay = DAYS.values()[(date.getDay()+2)%7];//calculates the delivery day
			//there is no action on Sundays
			switch (currentDay) {
			case FRIDAY:
				deliveryDay = DAYS.values()[(date.getDay()+3)%7];  //special cases which includes sunday 
				break;
			case SATURDAY:
				deliveryDay = DAYS.values()[(date.getDay()+3)%7];
				break;
			case SUNDAY:
				deliveryDay = DAYS.values()[(date.getDay()+3)%7];
				break;
			default:
				deliveryDay = DAYS.values()[(date.getDay()+2)%7];
				break;
			}
			
	        return deliveryDay ;
	    }
	

	//getters setters
	 public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	

	public void setHeight(int height) {
		this.height = height;
	}
}

	