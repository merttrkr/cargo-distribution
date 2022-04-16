package App;
import java.util.ArrayList;

import AbstractClasses.Cargo;
import FileIO.CsvReader;

public class Main {

    public static void main(String[] args) {



       CsvReader fileCsvReader = new CsvReader();
       ArrayList<Cargo> cargos = fileCsvReader.getCargos();
       

        System.out.println("Welcome!");
        System.out.println("Number of Accepted Cargo: " + fileCsvReader.getAccepted());
        System.out.println("Number of Not Accepted Cargo:" + fileCsvReader.getNotaccepted());
        System.out.println("Here are the details:");
        System.out.println("Normal Cargo packages:");
        System.out.println("No    Cargo Code    Sender ID      Sender Name    Recepient Name      Recipient Address       Size     Price    Delivery Day");
        int i  = 0;
        for (Cargo cargo : cargos) {
        	
           if (cargo.getType().equals("Normal")) {
        	   
        	   i++;
			System.out.println(String.valueOf(i) +"	"+ cargo);
		}
       	
         }
        System.out.println("No  E-Commerce Site     Cargo Code     Status    Size      Delivery Day");
        int x  = 0;
        for (Cargo cargo : cargos) {
            if (cargo.getType().equals("Ecommerce")) {
            	x++;
            	System.out.println(String.valueOf(x) +"	"+ cargo);
 		}
        	
          }
      
          

    }

}