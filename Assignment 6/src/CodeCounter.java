import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CodeCounter {
	private File file;
	private Scanner pt;
	private ArrayList<String> list;
	private static int linesOfCode;
	private static BiSearchTree library;
	//CONSTRUCTOR - GIVEN A FILE DESTINATION SINCE WE WILL ALWAYS HAVE ONE
	public CodeCounter(String file) {
		this.file = new File(file);
		try {
			pt = new Scanner(this.file);
			linesOfCode = 0;
			library = new BiSearchTree();
			//createArrayListMCS WILL DO WORK OF ANALYZING 
			list= createArrayListMCS(pt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(pt != null) {
				pt.close();
			}
		}
	}

	public static ArrayList<String> createArrayListMCS(Scanner pt) {
		// create stack to identify MCS
		Stack <String> myStack = new Stack<String>();
		String currentCodeLine = "";
		String previousCodeLine = "";

		ArrayList<String> list = new ArrayList<String>();

		while(pt.hasNextLine()) {
			//LOOKS FOR '{' & '}' AND IGNORES COMMENT LINES
			currentCodeLine = pt.nextLine();
			currentCodeLine = currentCodeLine.trim();

			if(currentCodeLine.length()>0) {
				if(!currentCodeLine.equals("{") && !currentCodeLine.equals("}")&& !currentCodeLine.contains("//")&&!currentCodeLine.contains("*/") && !currentCodeLine.contains("/*")) {
					previousCodeLine = currentCodeLine;
					linesOfCode ++;
				}
				else if (currentCodeLine.equals("{")) {
					//library IS CALLED TO ADD METHOD AND UPDATE COUNTS
					library.addNode(previousCodeLine);
					myStack.push(previousCodeLine);
					linesOfCode ++;
				}

				else if(!currentCodeLine.contains("*/") && !currentCodeLine.contains("/*")&&!currentCodeLine.contains ("//")){
					list.add(0,myStack.pop());
					linesOfCode ++;
				}
			}
		}
		return list;

	}
	//GETTERS FOR ANSWER VARIABLES
	public ArrayList getList() {
		return list;
	}
	public int getLinesOfCode() {
		return linesOfCode;
	}
	public static String getCounts() {
		return library.traverseTree();
	}

}
