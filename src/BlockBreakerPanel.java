import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BlockBreakerPanel extends JPanel implements KeyListener {
	
	ArrayList<Block> blocks = new ArrayList<Block>();
	Block ball = new Block(237, 435, 25, 25, "ball.png");
	Block paddle = new Block(175,480,150,25, "paddle.png");
	
	
	public BlockBreakerPanel(){
		
		addKeyListener(this);
		setFocusable(true);
		
	}
	public void paintComponent(Graphics g) {
		paddle.draw(g,this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_ENTER) {

			new Thread(() -> {
				while (true) {
					update();
					
					try {
						Thread.sleep(10);
					} catch(InterruptedException err) {
						err.printStackTrace();
					}
				}
				
			}).start(); 
				
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth()- paddle.width)) {
		paddle.x+= 15;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x >0) {
			paddle.x-= 15;
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		repaint();
		
	}

}
