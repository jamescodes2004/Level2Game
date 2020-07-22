import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;
//Later on will make full on evolution with variable such as - Size, speed, reporduction method, lays eggs, can see, camouflage, acceleration, etc.)
public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	private Font titleFont;
	private Font sideFont;
	private Font BIG;
	Timer enemySpawn;
	character guy;
 	

	Hook hookie = new Hook (145,400,10,10);
	LineAndBoat thingy = new LineAndBoat(50,100,10,300);
ObjectManager manager;
	  final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    final int INS = 3;
	    int currentState = MENU;
		Timer frameDraw;
		int time;
		
		
	    GamePanel(){
	    	addMouseListener(this);
	    	sideFont = new Font("Arial", Font.PLAIN,30);
	    	titleFont = new Font("Arial", Font.PLAIN,60);
	    	BIG = new Font("Dialog", Font.BOLD,150);
	    	frameDraw = new Timer(5000/60, this);
	    	frameDraw.start();
	    }
	    public void startGame() {
	    	 guy = new character(250,500, 50, 50);
 	    	
	    	 manager = new ObjectManager(guy,hookie,thingy);
	    	enemySpawn = new Timer(1000, manager);
	    	if (currentState==END) {
	    		enemySpawn.stop();
	    	}
	    	else {
	    	enemySpawn.start();
	    	System.out.println("timer started");
	    	}
	    }
	    public void paintComponent(Graphics g) {
	    	if(currentState == MENU){
	    	    drawMenuState(g);
	    	}else if(currentState == GAME){
	    	    drawGameState(g);
	    	}else if(currentState == END){
	    	    drawEndState(g);
	    	}
	    	else if(currentState == INS){
	    	    drawInsState(g);
	    	}
	    }
	    void updateMenuState() { 
	    	
	    }
	    void updateGameState() { 
	    	manager.update();
	    	if(guy.isActive==false) {
	    	currentState=END;	
	    	}
	    	if(guy.width>80) {
	    		currentState=END;
	    	}
	    	
	    }
	    void updateEndState()  {
	    	
	    }
	    void updateInsState()  {
	    	
	    }
	    void drawMenuState(Graphics g) { 

	    	g.setColor(Color.LIGHT_GRAY);
	    	g.fillRect(0, 0, game.WIDTH, game.HEIGHT);
	    	g.setFont(titleFont);
	    	g.setColor(Color.YELLOW);
	    	g.drawString("The Game of Evolution", 300, 100);
	    	g.setFont(sideFont);
	    	g.drawString("Press ENTER to start", 500, 300);
	    	g.drawString("Press SPACE for instructions", 450, 500);
	    	
	    }
	    void drawGameState(Graphics g) { 

	    	g.setColor(Color.BLUE);
	    	g.fillRect(0, 100, game.WIDTH, game.HEIGHT);
	    	g.setColor(Color.cyan);
	    	g.fillRect(0, 0, game.WIDTH, 100);
	    	manager.draw(g);
	    	
	    
	
	    }
	    void drawEndState(Graphics g)  { 
	    	if(guy.width>80) {
	    		g.setColor(Color.GREEN);
	    		g.fillRect(0, 0, game.WIDTH, game.HEIGHT);
	    		g.setColor(Color.BLACK);
	    		g.setFont(BIG);
	    		g.drawString("YOU", 460, 300);
		    	g.drawString("WIN", 460, 500);
		    	g.setFont(titleFont);
		    	g.drawString("You reached a large enough size to eat the boat!", 50, 650);
		    	g.drawString("Click ENTER to restart", 375, 800);
	    	}
	    	else {
	    	g.setColor(Color.RED);
	    	g.fillRect(0, 0, game.WIDTH, game.HEIGHT);
	    	g.setFont(BIG);
	    	g.setColor(Color.YELLOW);
	    	g.drawString("GAME", 450, 300);
	    	g.drawString("OVER", 450, 500);
	    	g.setFont(titleFont);
	    	g.drawString("Click ENTER to restart", 375, 600);
	    	}
	    }
	    void drawInsState(Graphics g)  { 
	    	g.setColor(Color.BLACK);
	    	g.setFont(sideFont);
	    	g.drawString("Collect Green Blobs to enlarge yourself, and collecdt purple ones to get faster", 150, 100);
	    	g.drawString("Watch out though, other fish are also trying to ", 330, 250);
	    	g.drawString("collect green blobs and if they are bigger they'll eat you for them!", 225, 300);
	    	g.drawString("As you progress through the levels, your max size will get bigger", 225, 500);
	    	g.drawString("One you are big enough to eat the boat, you win!", 285, 650);
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

		    if(currentState==GAME) {
		    	
		    }
		    else {
		    	
		    	 
		    	    	
		    	    	
		    	       
		    	    	 currentState++;
		    	    	 startGame();
		     
		
		    }
	  
		    System.out.println(currentState);
		} 
		if(currentState==MENU && e.getKeyCode()==KeyEvent.VK_SPACE) {
			currentState = INS;
			System.out.println("space");
		}
		else if(currentState==INS && e.getKeyCode()==KeyEvent.VK_SPACE) {
			currentState = MENU;
			System.out.println("space");
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			
		    System.out.println("UP");
		    if (guy.y-100>0) {
		    guy.up(); 
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    if (guy.y<game.HEIGHT-guy.height-20) {
		    guy.down();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    if (guy.x>0) {
		    guy.left();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    if (guy.x<game.WIDTH-guy.width) {
		    guy.right();
		    }
		}
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

			if(currentState == MENU){
			    updateMenuState();
			    
			}else if(currentState == GAME){
			    updateGameState();
			    
			}else if(currentState == END){
			    updateEndState();
			}
		repaint();
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	//	if(e.getX() <game.WIDTH-50 && e.getX()> game.WIDTH-100 && e.getY() >25 && e.getY() <75 && manager.upgradePoints>0) {
	//		guy.speed = guy.speed+1;
	//		System.out.println("clicked");
	//		manager.upgradePoints--;
	//	}
		System.out.println(e.getX());
//Next should get rid of collision box for 30 secs
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}


