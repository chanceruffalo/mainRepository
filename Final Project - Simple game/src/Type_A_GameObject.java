import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder; 

public class Type_A_GameObject extends GameObject implements KeyListener {
	
	public Type_A_GameObject(int x, int y) {
		super(x,y);
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int  iconHeight   = icon.getIconHeight();
		int  iconWidth    = icon.getIconWidth();
		int  canvasHeight = (int)c.getSize().getHeight();
		int  canvasWidth  = (int)c.getSize().getWidth();
		Border blackLine = new MatteBorder(icon);
		
		if(getActivity()) {
			
			switch(getDirection()) {
			case Direction.UP:
				setY(getY() - getVelocity());
				if(getY() < 0) {
					setY(0);
				}

				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if(getY() + iconHeight > canvasHeight) {
					setY((int)(canvasHeight - iconHeight));
				}
				break;
			default: break;
			}
		}
		else {
			if(getVelocity() * -1 < 0) {
				currentImage = 0;
			}
			else {
				currentImage = 1;
			}
			setY(getY() + getVelocity());
			if(getY() < 0) {
				setY(0);
				setVelocity(-1*getVelocity());
			}
			if(getY() + iconHeight> canvasHeight) {
				setVelocity(-1*getVelocity());
			}
		}
	}
	
	public void setImage() {
		if(getActivity()) {
			switch(getDirection()) {
			case Direction.NONE:
				break;
			case Direction.UP:
				currentImage = 1;
				break;
			case Direction.DOWN:
				currentImage = 0;
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
	  }


	  
	}

