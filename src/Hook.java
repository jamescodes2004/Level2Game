import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Hook extends GameObject{
 Color brown = new Color(165,42,42);
 public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	Hook(int x, int y, int width, int height){
		super(x,  y,  width,  height);
		if (needImage) {
		    loadImage ("hookie.png");
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		if (gotImage) {
	    	g.drawImage(image, x, y, width, height, null);
	    } else {
	
	    	g.setColor(Color.GRAY);
			g.fillRect(x, y, width, height);
	    }

	}

	
	void update() {
	
		super.update();
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