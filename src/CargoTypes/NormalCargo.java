package CargoTypes;
import java.util.Random;

import AbstractClasses.Cargo;
import Interface.INormalCargo;



//normal cargo class
public class NormalCargo extends Cargo implements INormalCargo{
	private long ID ;
    private String senderName;
    private String recipientName;
    private String adress;
    private final long cargoCode = new Random().nextInt(9000000) + 1000000 ;
    
    
    public NormalCargo() {
    	super();
    	ID = 00000000000;
    	senderName = "";
    	recipientName= "";
    	adress = "";
    	
	} 
    
    public NormalCargo( long ID,String senderName,String recipientName, String adress, int weight,int width,int length ,int height ){ // full arg constructor
        super("Normal",weight,width,length,height);
        this.ID = ID;
        this.senderName =senderName;
        this.recipientName = recipientName;
        this.adress = adress;        
    }
    
    public double price() {
		return 18.5+3*size();
	}
    
    public double discountedPrice(double discount) { //in the future The cargo company may define a discount for a group of customers.
        double discountedPrice = price()-(discount*price());

        return discountedPrice;
    }


    @Override
    public String toString() {
    	
    	return cargoCode +"     "+  ID + "   " + senderName + "     " + recipientName + "     " +adress + "    " +size() +"   " + price() +"   " + deliveryday();
    }
    
  //checks if the ID is properly written.
    public boolean isIDValid(long ID){

        if (String.valueOf(ID).matches("[0-9]+") && String.valueOf(ID).length() == 11) {
            return true;}
        else return false;
    }
	
   
    //getters setters

    public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}


	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	


}