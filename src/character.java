	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.image.BufferedImage;

	import javax.imageio.ImageIO;
public class character extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
int upgradePoints;

	
		character(int x, int y, int width, int height){
			
	super(x, y, width, height);
	speed = 10;
	this.upgradePoints = upgradePoints;
	if (needImage) {
	    loadImage ("squid.png");
	}
		}
		void draw(Graphics g) {
			if (gotImage) {
		    	g.drawImage(image, x, y, width, height, null);
		    } else {
		
				g.setColor(Color.white);
				g.fillOval(x, y, width, height);
		    }
		
		}
		public void right() {
			
			x+=speed;
			super.update();
		}
		public void left() {
			x-=speed;
			super.update();
		}
		public void down() {
			y+=speed;
			super.update();
		}
		public void up() {
			y-=speed;
			super.update();
		}
		public character getCharacter() {
			return new character(x+width/2, y, 10, 10);
		}
		  void loadImage(String imageFile) {
		        if (needImage) {
		            try {
		                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    	    gotImage = true;
		            } catch (Exception e) {
		                
		            }
		            needImage = false;
		        }
		    }

	}


