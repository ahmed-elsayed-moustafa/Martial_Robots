import java.awt.Point;
import java.util.ArrayList;

public class Mars {

	private Point areaOfPlanet;
	private ArrayList<Scent> storedScents = new ArrayList<Scent>();
	private ArrayList<Robot> activeRobots = new ArrayList<Robot>();

	public Mars(Point areaOfPlanet) {
			if(!(areaOfPlanet.x>50 || areaOfPlanet.y>50)){
				this.areaOfPlanet = areaOfPlanet;
			}else{
				System.err.println("Area coordinates greater than 50");
				System.exit(0);
			}
		}
	
	public Point getAreaOfPlanet() {
		return areaOfPlanet;
	}

	public void setAreaOfPlanet(Point areaOfPlanet) {
		this.areaOfPlanet = areaOfPlanet;
	}

	public ArrayList<Scent> getStoredScents() {
		return storedScents;
	}

	public void setStoredScents(ArrayList<Scent> storedScents) {
		this.storedScents = storedScents;
	}

	public ArrayList<Robot> getActiveRobots() {
		return activeRobots;
	}

	public void setActiveRobots(ArrayList<Robot> activeRobots) {
		this.activeRobots = activeRobots;
	}
	
	public void addRobots(Robot newRobot){
		activeRobots.add(newRobot);
	}
	
	public void addScents(Scent newScent){
		storedScents.add(newScent);
	}
}
