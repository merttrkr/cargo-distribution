package Interface;
import java.util.ArrayList;

import AbstractClasses.Cargo;

public interface ICsvReader {

	public ArrayList<String> getData();
	public ArrayList<Cargo> getCargos();
	public int getAccepted();
	public int getNotaccepted();
}
