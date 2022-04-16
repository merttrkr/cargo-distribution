package FileIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import AbstractClasses.Cargo;
import AbstractClasses.Ecommerce;
import CargoTypes.Amazon;
import CargoTypes.HepsiBurada;
import CargoTypes.N11;
import CargoTypes.NormalCargo;
import CargoTypes.Trendyol;
import Exception.CargoCodeNotValidException;
import Exception.IDNotCorrectException;
import Interface.ICsvReader;
import Interface.STATUS;

public class CsvReader implements ICsvReader {

	private int accepted; //number of acceptedcargos
	private int notaccepted; //number of not accepted cargos
	
	public ArrayList<String> getData() { //reading csv file
		final String file = "HW3_PackagesToAccept.csv";
		 ArrayList<String> data = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
           
            String line = br.readLine();
            while(line != null) {
            	data.add(line);
            	line = br.readLine();
            }
           br.close();
          

            } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return data;
       
	}

	public  ArrayList<Cargo> getCargos(){ //initalize object
		
		ArrayList<Cargo> cargos = new ArrayList<Cargo>(); //return array that holds all cargos
		
		//wee need these array to compare their size and cargos daily limits. 
		ArrayList<Trendyol> trendyols = new ArrayList<Trendyol>(); 
		ArrayList<Amazon> amazons = new ArrayList<Amazon>();
		ArrayList<N11> n11s = new ArrayList<N11>();
		ArrayList<HepsiBurada> hepsiBuradas = new ArrayList<HepsiBurada>();
		
	
		try {
			
		accepted = 0;//inital value
		notaccepted = 0;
		for (int i = 0; i < getData().size(); i++) {
			String[] cargoStrings = getData().get(i).split(";"); //parsing
			String firstLine = cargoStrings[0].replaceAll("[\uFEff-\uFFFF]",""); //to avoid invisible chars
			cargoStrings[0] = firstLine;

			String type = cargoStrings[0];
			if (type.equals("Ecommerce")) {
			
				String siteName = cargoStrings[1];
				
				switch (siteName) {
		    		case "Trendyol":{
		    			//initializing object
		    			Integer cargoCode = Integer.parseInt(cargoStrings[2]);
		    			int weight = Integer.parseInt(cargoStrings[3]);
		                int width = Integer.parseInt(cargoStrings[4]);
		                int length = Integer.parseInt(cargoStrings[5]);
		                int height = Integer.parseInt(cargoStrings[6]);
		                
		                Trendyol TrendyolCargo = new Trendyol(siteName, cargoCode, weight, width, length, height);//creating object
		                											//if cargo code is not valid, the cargo wont be accepted
		                if(!TrendyolCargo.CargoCodeValid(cargoCode)) {notaccepted++; throw new CargoCodeNotValidException();} //exception call
		                
		                trendyols.add(TrendyolCargo);//size of trendyols array grows

                        statusSetting(TrendyolCargo, trendyols.size()); //if size of trendyols array > TrendyolCargo.dailylimit() then the status is NOTACCEPTED,else ACCEPTED
                        counter(TrendyolCargo); //updates the number of accepted and not accepted values
		    			cargos.add(TrendyolCargo); //add to return array
		    			break;}
		    		case "Amazon":
		    		{	
		    			Integer cargoCode = Integer.parseInt(cargoStrings[2]);
		    			int weight = Integer.parseInt(cargoStrings[3]);
		                int width = Integer.parseInt(cargoStrings[4]);
		                int length = Integer.parseInt(cargoStrings[5]);
		                int height = Integer.parseInt(cargoStrings[6]);
		                
		                Amazon AmazonCargo = new Amazon(siteName, cargoCode, weight, width, length, height);
		                if(!AmazonCargo.CargoCodeValid(cargoCode)) {notaccepted++; throw new CargoCodeNotValidException();}
		               
		                amazons.add(AmazonCargo);
		                statusSetting(AmazonCargo, amazons.size());
		                counter(AmazonCargo);
		    			cargos.add(AmazonCargo);
		    			break;
		    			}
		    		case "N11":{
		    			
		    			String cargoCode = cargoStrings[2];
		    			int weight = Integer.parseInt(cargoStrings[3]);
		                int width = Integer.parseInt(cargoStrings[4]);
		                int length = Integer.parseInt(cargoStrings[5]);
		                int height = Integer.parseInt(cargoStrings[6]);
		                N11 N11Cargo = new N11(siteName, cargoCode, weight, width, length, height);
		                
		                if(!N11Cargo.CargoCodeValid(cargoCode)) {notaccepted++; throw new CargoCodeNotValidException();}
		                
		               
		                n11s.add(N11Cargo);
                        statusSetting(N11Cargo, n11s.size());
                        counter(N11Cargo);
		    			cargos.add(N11Cargo);
		    			break;}
		    		case "Hepsiburada":{
		    			String cargoCode = cargoStrings[2];
		    			int weight = Integer.parseInt(cargoStrings[3]);
		                int width = Integer.parseInt(cargoStrings[4]);
		                int length = Integer.parseInt(cargoStrings[5]);
		                int height = Integer.parseInt(cargoStrings[6]);
		                HepsiBurada HepsiBuradaCargo = new HepsiBurada(siteName, cargoCode, weight, width, length, height);
		                
		                if(!HepsiBuradaCargo.CargoCodeValid(cargoCode)) {notaccepted++; throw new CargoCodeNotValidException();}
		                
		                hepsiBuradas.add(HepsiBuradaCargo);
                        statusSetting(HepsiBuradaCargo, hepsiBuradas.size());
                        counter(HepsiBuradaCargo);
		    			cargos.add(HepsiBuradaCargo);
		    			
		    			break;
		    		}
		
					default:
						break;
				}
			}
				else if (type.equals("Normal")) {
					
					long senderId = Long.parseLong(cargoStrings[1]);
					String senderName = cargoStrings[2];
					String recipientName = cargoStrings[3];
					String adress = cargoStrings[4];
					int weight = Integer.parseInt(cargoStrings[5]);
		            int width = Integer.parseInt(cargoStrings[6]);
		            int length = Integer.parseInt(cargoStrings[7]);
		            int height = Integer.parseInt(cargoStrings[8]);
					NormalCargo normalCargo = new NormalCargo(senderId,senderName,recipientName,adress,weight,width,length,height); //initialize object
					if(!normalCargo.isIDValid(senderId)) {notaccepted++;throw new IDNotCorrectException();} //exception call and if id is not valid cargo wont be accepted
					cargos.add(normalCargo); //add to return array
					accepted++; // there is no daily limit for normal cargos, so every normal cargo will be accepted
				}
			

			}
			
            

		} catch (CargoCodeNotValidException e) { 
			// TODO: handle exception
			System.out.println(e.getMessage());			
		}catch (IDNotCorrectException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return cargos;

		
	}
	

	private <CodeFormat> void statusSetting(Ecommerce<CodeFormat> ecommerce , int size) { //helper method
		 if (size <= ecommerce.getDailyLimit()) ecommerce.setStatus(STATUS.ACCEPTED); //if size of trendyols array > TrendyolCargo.dailylimit() then the status is NOTACCEPTED,else ACCEPTED
         else {
				ecommerce.setStatus(STATUS.NOTACCEPTED);
			}
	}
	private <CodeFormat> void  counter(Ecommerce<CodeFormat> ecommerce) { //if e commercial cargos status is accepted, increments the value of accepted else increments notaccepted
		 if (ecommerce.getStatus() == STATUS.ACCEPTED) {
				accepted++;
			}else {
				notaccepted++;
			}
          
	}
	
	
	//getters
	public int getAccepted() {
		return accepted;
	}

	
	public int getNotaccepted() {
		return notaccepted;
	}

	
	


}
