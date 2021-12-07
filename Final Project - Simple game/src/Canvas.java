import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private Timer gameLoopTimer;
	private List<GameObject> gameObjectList;
	private int highlighted = 0;
	private GameObject border;

	
	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<GameObject>();
		border = new Border(0,0);
		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		setFocusTraversalKeysEnabled(false);
	    addKeyListener(this);
		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);

	}
	public synchronized void addGameObject(GameObject sprite) {
		
		if(gameObjectList.size() <1) {
			sprite.setActivity(true);
		}
		gameObjectList.add(sprite);
	}

	public synchronized void paint(Graphics g) {
		border.draw(this, g);
		for (GameObject s : gameObjectList) {
			s.draw(this, g);
		}
	}

	// ****************************************************
	// Canvas must implement the inherited abstract method
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			if(gameObject.getActivity() == true) {
				border.set(gameObject);
				border.setImage();
			}
			gameObject.setImage();
		}
		repaint();
	}

	// ****************************************************
	// Canvas must implement the inherited abstract methods
	// for KeyListener
	
	  public void keyTyped(KeyEvent e) {
	  }

	  public void keyPressed(KeyEvent e) {
	  }

	  public void keyReleased(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_TAB) {
	    	GameObject t = gameObjectList.get(highlighted);
	    	t.setActivity(false);
	      highlighted = highlighted + 1;
	      if (highlighted == gameObjectList.size()) {
	        highlighted = 0;
	      }
	    }
	    GameObject s = gameObjectList.get(highlighted);
	    s.setActivity(true);
	  }

}