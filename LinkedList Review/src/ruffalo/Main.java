package ruffalo;

public class Main {

	public static void main(String[] args) {
		System.out.println("Everything works");
		LinkedL ourList = new LinkedL();
		
		for(int i = 0; i < args.length ; i ++) {
			ourList.addNode((args[i]));
		}
		
		System.out.println(ourList.toStringReverse());
		System.out.println(ourList.toStringOrdered());
		while(ourList.getHead() != null) {
			ourList.pop();
			System.out.println(ourList.toStringOrdered());

		}
	}

}
