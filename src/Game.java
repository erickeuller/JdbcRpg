import java.sql.ResultSet;
import java.util.Scanner;

public class Game {

	private DataEngine engine = new DataEngine();

	public Game(DataEngine engine) {
		this.engine = engine;
	}

	public void start() {
    	try {
		    showLevelInfo(engine.executeQuery("Select * from RpgEntry WHERE level = 1"));
	    }
	    catch (Exception e){
    		System.out.println("Could not fetch first level");
	    }
    }

    private void nextLevel(int level, int option) {
    	try {
		    showLevelInfo(engine.executeQuery("SELECT * FROM RpgEntry WHERE level = " + level + " AND chosenOption = " + option));
	    }
	    catch (Exception e){
    		e.printStackTrace();
		    System.out.println("Could not fetch level");
	    }
    }

    private ResultSet getLevelOptions(int levelId) {
    	try {
    		return engine.executeQuery("SELECT Options.description " +
				    "FROM Options " +
				    "INNER JOIN Options_RpgEntry ON Options_RpgEntry.optionsId = Options.id " +
				    "INNER JOIN RpgEntry ON Options_RpgEntry.RpgEntryId = RpgEntry.id " +
				    "WHERE RpgEntry.id = " + levelId);
	    }
	    catch (Exception e) {
    		e.printStackTrace();
    		return null;
	    }
    }

    private void showLevelInfo(ResultSet levelInfo) {
    	try {
    		levelInfo.next();
    		System.out.println(levelInfo.getString("description"));
		    int level = levelInfo.getInt("level");
		    if (level == 3) {
			    return;
		    }
		    level++;
    		ResultSet options = getLevelOptions(levelInfo.getInt("id"));
    		showLevelOptions(options);
    		System.out.println("Escolha a opção:");
		    Scanner scanner = new Scanner(System.in);
		    int option = Integer.parseInt(scanner.next());
		    nextLevel(level, option);
	    }
	    catch (Exception e){
    		e.printStackTrace();
	    }
    }

    private int showLevelOptions(ResultSet options) {
    	System.out.println();
    	int count = 0;
    	try {
		    while (options.next()) {
		    	System.out.println(++count + " - " + options.getString("description"));
		    }
		    return count;
	    }
	    catch (Exception e ) {
	    	e.printStackTrace();
	    	return -1;
	    }
    }
}
