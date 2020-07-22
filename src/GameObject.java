import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	double speed;
	boolean isActive;
	boolean isMoving;
	Rectangle collisionBox;
	GameObject(int x, int y, int width, int height){
		this.x =x;
		this.y=y;
		this.width=width;
		this.height = height;
		double speed =15;
		isActive = true;
		isMoving=true;
		this.collisionBox =  new Rectangle(x,y,width,height);
		
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.width);
	}
	void update() {
		
		collisionBox.setBounds(this.x, this.y, this.width, this.height);
	  
	}
}
