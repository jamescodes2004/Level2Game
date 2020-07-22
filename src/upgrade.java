import java.awt.Color;
import java.awt.Graphics;

public class upgrade extends GameObject{

	upgrade(int x, int y, int width, int height){
		super(x,  y,  width,  height);
	}
	
	void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, width, height);
		super.draw(g);
	}
	
	void update() {
	
		super.update();
	}
}