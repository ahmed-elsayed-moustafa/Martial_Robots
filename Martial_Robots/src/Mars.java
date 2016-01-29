import java.util.ArrayList;

public class Mars {
	private Coordinate axisOfPlanet;
	private ArrayList<Robot> activeRobots;
	private Scent[] scents;
	private int i = 0;

	public Mars(Coordinate axisOfPlanet, ArrayList<Robot> activeRobots) {
		if ((axisOfPlanet.getX() > 50 || axisOfPlanet.getY() > 50)) {
			throw new Error("Coordinates must be less than 50");
		}
		this.axisOfPlanet = axisOfPlanet;
		this.activeRobots = activeRobots;
		scents = new Scent[activeRobots.size()];
		getLocationsOfRobots();
		printRobotFinalLocation();
	}

	public Coordinate getAxisOfPlanet() {
		return axisOfPlanet;
	}

	public void setAreaOfPlanet(Coordinate areaOfPlanet) {
		this.axisOfPlanet = areaOfPlanet;
	}

	public ArrayList<Robot> getActiveRobots() {
		return activeRobots;
	}

	public void addRobots(Robot newRobot) {
		activeRobots.add(newRobot);
	}

	public void addScents(Scent newScent) {
		scents[getI()] = newScent;
		setI(scents[getI()] != null ? ++i : i);
	}

	public Scent[] getScentsArray() {
		return scents;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void printRobotFinalLocation() {
		for (Robot robot : getActiveRobots()) {
			System.out.println(robot.toString(this));
		}
	}

	public void getLocationsOfRobots() {
		for (Robot robot : getActiveRobots()) {
			robot.readInstructions(robot.getInstruct().matches("[l|f|r]*") ? robot.getInstruct() : null, this);
		}
	}

}
