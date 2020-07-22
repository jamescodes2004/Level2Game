import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Enemy extends GameObject{
int spawn;
public static BufferedImage[] pictures;
boolean gotten;
public static boolean needImage = true;
public static boolean gotImage = false;	
Enemy(int x, int y, int width, int height, int spawn){
	super(x, y, width, height);
	gotten=false;
	speed = 5;
	if (needImage) {
		loadImage();
	}
	this.spawn=spawn;
}
void draw(Graphics g){
	   if (gotImage) {
		   if(this.width<10) {
	    	g.drawImage(pictures[0], x, y, width, height, null);
		   }
		   else if(this.width<20) {
		    	g.drawImage(pictures[1], x, y, width, height, null);
			   }
		   else if(this.width<30) {
		    	g.drawImage(pictures[2], x, y, width, height, null);
			   }
		   else if(this.width<40) {
		    	g.drawImage(pictures[3], x, y, width, height, null);
			   }
		   else if(this.width<50) {
		    	g.drawImage(pictures[4], x, y, width, height, null);
			   }
		   else if(this.width<60) {
		    	g.drawImage(pictures[5], x, y, width, height, null);
			   }
		   else if(this.width<70) {
		    	g.drawImage(pictures[6], x, y, width, height, null);
			   }
		   else if(this.width<80) {
		    	g.drawImage(pictures[7], x, y, width, height, null);
			   }
		   else  {
		    	g.drawImage(pictures[8], x, y, width, height, null);
			   }
	    } else {
	    	g.setColor(Color.BLACK);
	    	g.fillRect(x, y, width, height);
	    }

    
    
 }
    void update() {
    	
    	
    		y+=speed;
    	
    	
    	super.update();
    	
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
	 void loadImage() {
	        if (needImage) {
String[] images = {"smallFishOne.png", "smallFishTwo.png", "smallFishThree.png"
		, "bigFishOne.png", "bigFishTwo.png", "bigFishThree.gif", "sharkOne.png",
		"sharkTwo.png","sharkThree.png"};
pictures=new BufferedImage[images.length];
int index=0;
	            try {
	            	for(String imageFile:images) {
	            		pictures[index] = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    	    	    index++;
	            	}
	            	gotImage = true;
	            } catch (Exception e) {
	                System.out.println("didn't load" + index);
	            }
	            needImage = false;
	        }
	    }
}