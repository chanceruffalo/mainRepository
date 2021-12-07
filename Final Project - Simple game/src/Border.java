import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Border extends GameObject {
	
	public Border(int x, int y) {
		super(x,y);
		setDirection(Direction.NONE);
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/redBox.png"));
	}
	
	public void set( GameObject active) {		
		setY(active.getY());
		setX(active.getX());
	}
	public void setImage() {
		currentImage = 0;
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

	@Override
	public void move(Canvas c) {
		// TODO Auto-generated method stub
		
	}
	
}

	

