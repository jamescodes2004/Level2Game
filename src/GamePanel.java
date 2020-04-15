import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
//Later on will make full on evolution with variable such as - Size, speed, reporduction method, lays eggs, can see, camouflage, acceleration, etc.)
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	private Font titleFont;
	private Font sideFont;
	GameObject character = new GameObject(250,700, 50, 50);
	  final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
		Timer frameDraw;
	    GamePanel(){
	    	sideFont = new Font("Arial", Font.PLAIN,30);
	    	titleFont = new Font("Arial", Font.PLAIN,60);
	    	frameDraw = new Timer(1000/60, this);
	    	frameDraw.start();
	    }
	    public void paintComponent(Graphics g) {
	    	if(currentState == MENU){
	    	    drawMenuState(g);
	    	}else if(currentState == GAME){
	    	    drawGameState(g);
	    	}else if(currentState == END){
	    	    drawEndState(g);
	    	}
	    }
	    void updateMenuState() { 
	    	
	    }
	    void updateGameState() { 

	    }
	    void updateEndState()  {
	    	
	    }
	    void drawMenuState(Graphics g) { 

	    	g.setColor(Color.BLACK);
	    	g.fillRect(0, 0, game.WIDTH, game.HEIGHT);
	    	g.setFont(titleFont);
	    	g.setColor(Color.YELLOW);
	    	g.drawString("The Game of Evolution", 300, 100);
	    	g.setFont(sideFont);
	    	g.drawString("Press ENTER to start", 500, 300);
	    	g.drawString("Press SPACE for instructions", 450, 500);
	    	
	    }
	    void drawGameState(Graphics g) { 
	    	g.setColor(Color.BLACK);
	    	g.fillRect(0, 0, game.WIDTH, game.HEIGHT);

	    }
	    void drawEndState(Graphics g)  { 
	    	g.setColor(Color.RED);
	    	g.fillRect(0, 0, game.WIDTH, game.HEIGHT);
	    	g.setFont(titleFont);
	    	g.setColor(Color.YELLOW);
	    	g.drawString("Game Over", 30, 30);
	    }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			System.out.println("ENTER");
		    if (currentState == END) {
		        currentState = MENU;
		      
		    } 

		    else {
		    	
		    	
		        currentState++;
		    }
		    System.out.println(currentState);
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
