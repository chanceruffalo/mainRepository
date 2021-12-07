import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon; 

public class Type_B_GameObject extends GameObject implements KeyListener {

		private int automation;
		
	public Type_B_GameObject(int x, int y) {
		super(x,y);
		automation = 0;
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B__Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int  iconHeight   = icon.getIconHeight();
		int  iconWidth    = icon.getIconWidth();
		int  canvasHeight = (int)c.getSize().getHeight();
		int  canvasWidth  = (int)c.getSize().getWidth();

		if(getActivity()) {
			switch(getDirection()) {
			case Direction.UP:
				  setY(getY() - getVelocity());
				  if (getY() < 0) {
					  setY(0);
				  }
				  break;
			  case Direction.DOWN:
				  setY(getY() + getVelocity());
				  if (getY() + iconHeight > canvasHeight) {
					  setY((int)(canvasHeight - iconHeight));
				  }
				  break;
			  case Direction.LEFT:
				  setX(getX() + getVelocity());
				  if (getX() + iconWidth > canvasWidth) {
					  setX((int)(canvasWidth - iconWidth));
				  }
				  break;
			  case Direction.RIGHT:
				  setX(getX() - getVelocity());
				  if (getX() < 0) {
					  setX(0);
				  }
				  break;
			  default:
				  break;
			  }
		  }
		//SELF MOVING
		else {
			switch(automation) {
			case 0: currentImage = 2; 
				setX(getX() + getVelocity());
			  if (getX() + iconWidth > canvasWidth) {
				  setX((int)(canvasWidth - iconWidth));
				  automation++;
			  }break;
			case 1: currentImage = 0;
				setY(getY() - getVelocity());
			  if (getY() < 0) {
				  setY(0);
				  automation++;
			  }break;
			case 2:currentImage = 3;
				setX(getX() - getVelocity());
			  if (getX() < 0) {
				  setX(0);
				  automation++;
			  }
			  break;
			case 3:currentImage = 1;
				setY(getY() + getVelocity());
			  if (getY() + iconHeight > canvasHeight) {
				  setY((int)(canvasHeight - iconHeight));
				  automation = 0;
			  }break;
			}
		}
		
		
	}
		//SPECIFY THE IMAGE TO DISPLAY
	  	//   USED FOR ANIMATION
	  public void setImage() {
		  if(getActivity()) {
			  switch (getDirection()) {
			  case Direction.NONE:
				  break;
			  case Direction.UP:
				  currentImage = 0;
				  break;
			  case Direction.DOWN:
				  currentImage = 1;
				  break;
			  case Direction.LEFT:
				  currentImage = 2;
				  break;
			  case Direction.RIGHT:
				  currentImage = 3;
				  break;
			  }
		  }
	  }
	  public void keyTyped(KeyEvent e) {
	  }

	  public void keyReleased(KeyEvent e) {
	    if (e.getKeyCode() != KeyEvent.VK_TAB) {
	      setDirection(Direction.NONE);
	    }
	  }

	  public void keyPressed(KeyEvent e) {
		  if (e.getKeyCode() == KeyEvent.VK_UP) {
		      setDirection(Direction.UP);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		      setDirection(Direction.DOWN);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		      setDirection(Direction.LEFT);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		      setDirection(Direction.RIGHT);
		    }
		  }
	
}
