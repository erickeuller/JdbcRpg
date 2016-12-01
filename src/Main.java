/**
 * Created by erick on 01/12/16.
 */
public class Main {
	public static void main(String[] args) {
		try {
			DataEngine engine = new DataEngine();
			engine.connect();
			Game game = new Game(engine);
			game.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}
