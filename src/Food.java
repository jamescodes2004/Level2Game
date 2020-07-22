import java.awt.Color;
import java.awt.Graphics;

public class Food extends GameObject{

	Food(int x, int y, int width, int height){
		super(x,  y,  width,  height);
	}
	
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		super.draw(g);
	}
	
	void update() {
	
		super.update();
	}
}
