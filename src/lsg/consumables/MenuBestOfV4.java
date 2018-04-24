package lsg.consumables;

public class MenuBestOfV4 extends MenuBestOfV2 {
	
	public MenuBestOfV4() {
		super();
	}
	
	//Methodes
	
	public String toString() {
		
		String output = "";
		int index = 1;
		for (Consumables consumables : getMenu()) {
			output += index + ": " + consumables.toString() + "\n";
			index++;
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(new MenuBestOfV4().toString());
	}
}
