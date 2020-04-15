import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;
	Rectangle collisionBox;
	GameObject(int x, int y, int width, int height){
		this.x =x;
		this.y=y;
		this.width=width;
		this.height = height;
		speed =15;
		isActive = true;
		this.collisionBox =  new Rectangle(x,y,width,height);
		
	}
	void draw(Graphics g) {
		//g.setColor(Color.RED);
		//g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.width);
	}
	void update() {
		
		collisionBox.setBounds(x, y, width, height);
	  
	}
}
