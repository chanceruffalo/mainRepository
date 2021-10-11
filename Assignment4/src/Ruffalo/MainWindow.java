package Ruffalo;

public class MainWindow {

	public static void main(String[] args) {
		BinarySearchTree storage = new BinarySearchTree();
		//POPULATE TREE WITH args
		for(int i = 0; i < args.length; i ++) {
			//CHECKS FOR
			if(args[i].matches("^[a-zA-Z]*$")) {
				if(args[i].contains(",") || args[i].contains("'")|| args[i].contains("-") || args[i].contains(".") || args[i].contains(":")) {
					args[i] = args[i].substring(0,args[i].length() - 1);
				}
				storage.addNode(args[i].toLowerCase());
			}
		}
		storage.traverseTree();
		System.out.println("---- Dictionary ----");
		System.out.println("--Are these words?--");
		System.out.println("These: " + storage.spellCheck("these"));
		System.out.println("Thesse: " + storage.spellCheck("thesse"));
		System.out.println("are: " + storage.spellCheck("are"));
		System.out.println("areee: " + storage.spellCheck("areee"));
		System.out.println("book: " + storage.spellCheck("book"));
		System.out.println("asdf: " + storage.spellCheck("asdf"));
		System.out.println("about: " + storage.spellCheck("about"));
		System.out.println("headdd: " + storage.spellCheck("headdd"));
		System.out.println("--------------------");
		System.out.println("------Removals------");
		storage.checkWord("these");
		storage.checkWord("are");
		storage.checkWord("book");
		System.out.println("'These' is in library: " + storage.spellCheck("these"));
		System.out.println("'Are' is in library: " + storage.spellCheck("are"));
		System.out.println("'book' is in library: " + storage.spellCheck("book"));
		
		
		
	}

}
