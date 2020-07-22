import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Random rand = new Random();
	Random location = new Random();
	character chara;
	Hook hookie;
	LineAndBoat thingy;
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Food> foods = new ArrayList<Food>();
	ArrayList<upgrade> upgrades = new ArrayList<upgrade>();
	int score = 0;
	double speeds = 0;
	int upgradePoints = 0;
	int speedValue = 10;
	public int level = 0;
	boolean intersected=false;
	String pointsMessage = "hi";
	int gottenNum=0;
	boolean gotten=false;
	boolean gameWon;
	boolean leftOrRight=true;
	boolean level1Removed = false;
	boolean level2Removed= false;
	
	

	ObjectManager(character chara,Hook hookie, LineAndBoat thingy) {
this.hookie=hookie;
this.thingy=thingy;
		this.chara = chara;
		this.upgradePoints = upgradePoints;
	}

	int getScore() {
		return score;
	}

	void addUpgrade() {
		int chance = rand.nextInt(10);
		if (chance == 0) {
			upgrades.add(new upgrade(rand.nextInt(game.WIDTH), 100+ rand.nextInt(game.HEIGHT-100), 5, 5));
			System.out.println("Upgrade added");
		}
	}

	void addEnemy() {
		int loc = location.nextInt(4);
		//if (loc == 0) {
		//enemies.add(new Enemy(rand.nextInt(game.WIDTH), 0, 50, 50));
		//System.out.println("added top");}
		if (loc == 0) {if (level==0) {
			int big = rand.nextInt(60);}
		else if (level==1 ) {
			int big = rand.nextInt(80);
		}
		else {
			int big = rand.nextInt(120);
		
		enemies.add(new Enemy(game.WIDTH, 100+ rand.nextInt(game.HEIGHT-100), big, big, 0));
		
		System.out.println("added right");}}
		//else if (loc == 2) {
		//enemies.add(new Enemy(rand.nextInt(game.WIDTH), game.HEIGHT, 50, 50, 1));
		//System.out.println("added bottom");}
		else if (loc == 3) {		
			if (loc == 1) {if (level==0) {
		}
			int big = rand.nextInt(60);}
		else if (level==1 ) {
			int big = rand.nextInt(80);
		}
		else {
			int big = rand.nextInt(120);
		
			
		enemies.add(new Enemy(0, 100+ rand.nextInt(game.HEIGHT-100), big, big, 1));
		System.out.println("added left");}}
	}

	void addFood() {

		foods.add(new Food(rand.nextInt(game.WIDTH), 100+ rand.nextInt(game.HEIGHT-100), 10, 10));
	}

	void update() {
intersected= false;
hookie.update();
thingy.update();
		chara.update();
		if (chara.width>60 && level==0) {
for (int i = 0; i < enemies.size(); i++) {
			if(level1Removed=false) {
				enemies.get(i).isActive=false;	
				level1Removed=true;
				}
			level=1;
			chara.width=20;
			chara.height=20;}

		}
		if (chara.width>70 && level ==1) {
	for (int i = 0; i < enemies.size(); i++) {
				if(level2Removed=false) {
		enemies.get(i).isActive=false;		
				
				}
			level=2;
			chara.width=20;
			chara.height=20;
	}
		}

		for (Enemy enemy : enemies) {
			// enemy.update();
			if (enemy.y > game.HEIGHT + 10) {
				enemy.isActive = false;
			} else if (enemy.y < -10) {
				enemy.isActive = false;
			} else if (enemy.x > game.WIDTH + 10) {
				enemy.isActive = false;
			} else if (enemy.x < -10) {
				enemy.isActive = false;
			}

		}

		for (int j = 0; j < enemies.size(); j++) {

			ArrayList<Integer> foodX = new ArrayList<Integer>();
			ArrayList<Integer> foodY = new ArrayList<Integer>();

			for (int i = 0; i < foods.size(); i++) {
				boolean rightTrue = false;
				boolean leftTrue = false;
				boolean downTrue = false;
				boolean upTrue = false;

				foodX.add(foods.get(i).x - enemies.get(j).x);

				foodY.add(enemies.get(j).y - foods.get(i).y);

			}
			int min = 2000;
			int Xmin = 2000;
			int minXY = 0;
			int lowestValue = 0;
			int leftOrRight = 0;
			int upOrDown = 0;
			for (int i = 0; i < foods.size(); i++) {
				if (min > Math.abs(foodX.get(i)) + Math.abs(foodY.get(i)))
					minXY = i;
				min = Math.abs(foodX.get(i) + Math.abs(foodY.get(i)));

				if (Math.abs(foodX.get(i)) < Xmin) {
					Xmin = foodX.get(i);

				}

			}
			leftOrRight = foodX.get(minXY);
			upOrDown = foodY.get(minXY);
if(enemies.get(j).isMoving==true) {
			if (leftOrRight > 0) {
				enemies.get(j).right();
			}

			if (leftOrRight < 0) {
				enemies.get(j).left();
			}

			if (upOrDown > 0) {
				enemies.get(j).up();
			}

			if (upOrDown < 0) {
				enemies.get(j).down();
			}
		}
else {
	
}
		}

		checkCollision();
		purgeObjects();

	}

	public void draw(Graphics g) {
		chara.draw(g);
		hookie.draw(g);
		thingy.draw(g);
		
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);

		}
		for (int i = 0; i < foods.size(); i++) {
			foods.get(i).draw(g);

		}
		for (int i = 0; i < upgrades.size(); i++) {
			upgrades.get(i).draw(g);
		}
		g.setColor(Color.GRAY);
		Font titleFont = new Font("Arial", Font.PLAIN, 20);
		g.setFont(titleFont);

		g.drawString("Speed: " + chara.speed, 950, 25);
		Font sideFont = new Font("Arial", Font.PLAIN, 10);
		g.drawString("Score: " + score, 700, 25);
		if(level==0) {
		g.drawString("Small fish", 500, 25);
		}
		if(level==1) {
			g.drawString("Big fish" , 500, 25);
			
		
			}
			
		if(level==2) {
			g.drawString("Shark", 500, 25);
			
		
			}
		g.setFont(sideFont);
		if (speeds < chara.speed) {
			speeds = chara.speed;
			speedValue++;
		}
		
	}

	public void purgeObjects() {
		for (int i = 0; i < enemies.size(); i++) {
			if (!enemies.get(i).isActive) {
				enemies.remove(i);
			}

		}

		for (int i = 0; i < foods.size(); i++) {
			if (!foods.get(i).isActive) {
				foods.remove(i);
			}

		}
		for (int i = 0; i < upgrades.size(); i++) {
			if (!upgrades.get(i).isActive) {
				upgrades.remove(i);
			}

		}
	}

	void checkCollision() {
		//if(level==2 && chara.x>100 & chara.collisionBox.intersects(LineAndBoat.collisionBox)) {
		//	
		//=}
if(chara.collisionBox.intersects(hookie.collisionBox)) {
	chara.isActive=false;
	System.out.println("Guy died");
}

		for (int i = 0; i < enemies.size(); i++) {

			if(hookie.collisionBox.intersects(enemies.get(i).collisionBox)) {
				
			
				gottenNum=i;
				enemies.get(i).isActive=false;
			
				
				break;
			}
			if (chara.collisionBox.intersects(enemies.get(i).collisionBox) && enemies.get(i).width > chara.width) {
				chara.isActive = false;
				break;
			}
			if (chara.collisionBox.intersects(enemies.get(i).collisionBox) && enemies.get(i).width < chara.width) {
				enemies.get(i).isActive = false;
				chara.width = chara.width + 2;
				chara.height = chara.height + 2;
				score=score+2;
				break;
			}
			for (int j = 0; j < enemies.size(); j++) {
				if (enemies.get(i).collisionBox.intersects(enemies.get(j).collisionBox)) {
					if (enemies.get(i).width > enemies.get(j).width) {
						enemies.get(j).isActive = false;
						enemies.get(i).width = enemies.get(i).width + 2;
						enemies.get(i).height = enemies.get(i).height + 2;
						if(j==gottenNum && gotten == true) {
							gottenNum=i;
							enemies.get(i).isMoving=false;
						}
					}
					if (enemies.get(i).width < enemies.get(j).width) {
						enemies.get(i).isActive = false;
						enemies.get(j).width = enemies.get(j).width + 2;
						enemies.get(j).height = enemies.get(j).height + 2;
						if(i==gottenNum && gotten==true) {
							gottenNum=j;
							enemies.get(j).isMoving=false;
						}
					}
				}
			}
			for (int e = 0; e < foods.size(); e++) {

				if (foods.get(e).collisionBox.intersects(enemies.get(i).collisionBox)) {
					enemies.get(i).width = enemies.get(i).width + 1;
					enemies.get(i).height = enemies.get(i).height + 1;
					foods.get(e).isActive = false;

				}
				if (foods.get(e).collisionBox.intersects(chara.collisionBox) && intersected==false) {
					chara.width = chara.width + 1;
					chara.height = chara.height + 1;
					foods.get(e).isActive = false;
					score=score+1;
					intersected=true;
				}
			}

		}
		for (int e = 0; e < upgrades.size(); e++) {
			if (upgrades.get(e).collisionBox.intersects(chara.collisionBox)) {
				upgrades.get(e).isActive = false;
				chara.speed++;
				//this.upgradePoints++;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(level==2 && chara.width>100) {
			chara.isActive=false;
		}
		// TODO Auto-generated method stub
		Random rand = new Random(); int cool = rand.nextInt(2); int upOrDown=rand.nextInt(2);
	
	
			
		if(leftOrRight) {
			if(thingy.x<1200) {
			hookie.x=hookie.x+20;
			thingy.x=thingy.x+20;
			}
			else {
			leftOrRight=false;	
			}
		}
		if(!leftOrRight) {
			if(thingy.x>100) {
			hookie.x=hookie.x-20;
			thingy.x=thingy.x-20;
			}
			else {
				leftOrRight=true;
			}
		}
		if(upOrDown==0) {
			if(thingy.height>0) {
			hookie.y=hookie.y+10;
			thingy.height=thingy.height+10;
			}
			else {
				
			}
			
		}
		if(upOrDown==1) {
			if(thingy.height<600) {
			hookie.y=hookie.y-10;
			thingy.height=thingy.height-10;
			}
			else {
				
			}
		}
		
		addUpgrade();
		addEnemy();
		addFood();
		System.out.println("Enemy added");

	}
}