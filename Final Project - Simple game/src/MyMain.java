
public class MyMain {

	public static void main(String[] args) {
		// TASK 1: CREATE A CANVAS FOR ANIMATION
				Canvas canvas = new Canvas();
				canvas.requestFocus();
				
				//TASK 2:  ADD A USER GAME OBJECT
				Type_A_GameObject userA= new Type_A_GameObject(600,100);
				Type_B_GameObject userB = new Type_B_GameObject(200, 100);
				Type_C_GameObject userC = new Type_C_GameObject(100,400);
				Type_D_GameObject userD = new Type_D_GameObject(600, 600);
				userA.setVelocity(10);
				userB.setVelocity(10);
				userC.setVelocity(10);
				userD.setVelocity(10);
				canvas.addKeyListener(userA);
				canvas.addGameObject(userA);
				canvas.addKeyListener(userB);
				canvas.addGameObject(userB);
				canvas.addKeyListener(userC);
				canvas.addGameObject(userC);				
				canvas.addKeyListener(userD);
				canvas.addGameObject(userD);
	}

}
