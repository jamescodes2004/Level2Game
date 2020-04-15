import javax.swing.JFrame;

public class game {
	   
	private JFrame frame;
	public static final int WIDTH = 1400;
	public static final int HEIGHT = 700;
	private GamePanel panel;
public static void main(String[] args) {
	

	new game().setup();
}
game(){
	panel = new GamePanel();
	frame = new JFrame();
}
void setup() {
	frame.addKeyListener(panel);
	frame.add(panel);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
}
}
