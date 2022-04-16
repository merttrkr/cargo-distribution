package Interface;

public interface INormalCargo extends ICargo{
    public double price();
    public long getID() ;
    public String getSenderName();
    public String getRecipientName();
    public String getAdress() ;
    public boolean isIDValid(long ID);
    public double discountedPrice(double discount); 

}