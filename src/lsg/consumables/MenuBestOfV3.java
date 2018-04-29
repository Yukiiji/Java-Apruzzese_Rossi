package lsg.consumables;

public class MenuBestOfV3 extends MenuBestOfV2 {
	
	public MenuBestOfV3() {
		super();
	}
	
	//Methodes
	
	/**
	 * Surchage de toString
	 */
	@Override
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
		System.out.println(new MenuBestOfV3().toString());
	}
}
