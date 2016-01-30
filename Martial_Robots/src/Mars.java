import java.util.ArrayList;

public class Mars {
	private Coordinate axisOfPlanet;
	private ArrayList<Robot> activeRobots;
	private Scent[] scents;
	private int i = 0;

	public Mars(Coordinate axisOfPlanet, ArrayList<Robot> activeRobots) {
		this.axisOfPlanet = axisOfPlanet;
		this.activeRobots = activeRobots;
		arrayValidation();
		scents = new Scent[activeRobots.size()];
		getLocationsOfRobots();
		printRobotFinalLocation();
	}

	public void addScents(Scent newScent) {
		scents[getI()] = newScent;
		setI(scents[getI()] != null ? ++i : i);
	}

	public void printRobotFinalLocation() {
		for (Robot robot : getActiveRobots()) {
			print(checkRobotState(robot));
		}
	}

	public String checkRobotState(Robot robot) {
		String output = "";
		switch (robot.getCheckState()) {
		case 1:
			int index = getI() > 0 ? getI() - 1 : getI();
			output = getScentsArray()[index].getScentLocation().getX() + " "
					+ getScentsArray()[index].getScentLocation().getY() + " "
					+ getScentsArray()[index].getScentDirection().toString() + " LOST";
			break;
		case 0:
			if (robot.getInstructionCheck()) {
				output = "Robot at Coordinate (" + robot.getRobotLocation() + ") failed to meet instruction condition";
			} else {
				output = robot.getRobotLocation().getX() + " " + robot.getRobotLocation().getY() + " "
						+ robot.getRobotDirection().toString();
			}
			break;
		}
		return output;
	}

	public void getLocationsOfRobots() {
		for (Robot robot : getActiveRobots()) {
			robot.readInstructions(robot.getInstruct().matches("[l|f|r|L|F|R]+") ? robot.getInstruct() : null, this);
		}
	}

	public void arrayValidation() {
		if ((activeRobots == null || activeRobots.size() == 0)
				|| (axisOfPlanet.getX() > 50 || axisOfPlanet.getY() > 50)) {
			print("invalid parameters in Mars");
			System.exit(0);
		}
	}

	public void print(String string) {
		System.out.println(string);
	}

	public Coordinate getAxisOfPlanet() {
		return axisOfPlanet;
	}

	public void setAxisOfPlanet(Coordinate axisOfPlanet) {
		this.axisOfPlanet = axisOfPlanet;
	}

	public ArrayList<Robot> getActiveRobots() {
		return activeRobots;
	}

	public void addRobots(Robot newRobot) {
		activeRobots.add(newRobot);
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
}
