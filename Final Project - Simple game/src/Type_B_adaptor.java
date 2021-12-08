
public class Type_B_adaptor implements Type_B_object {
	Type_B_GameObject object;
	
	Type_B_adaptor(Type_B_GameObject object){
		this.object = object;
	}
	
	public static void move(){
		System.out.println("Can move up and down, left and right");
	}
	
	
}
