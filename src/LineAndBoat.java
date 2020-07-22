import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class LineAndBoat extends GameObject{
 Color brown = new Color(165,42,42);
 public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	LineAndBoat(int x, int y, int width, int height){
		super(x,  y,  width,  height);
		if (needImage) {
		    loadImage ("boat.png");
		}
	}

	void draw(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(x+99, y, 2, height);
		if (gotImage) {
	    	g.drawImage(image, x, 50, 200, 50, null);
	    } else {
	
			g.setColor(brown);
			g.fillRect(x, 50, 200, 50);
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
