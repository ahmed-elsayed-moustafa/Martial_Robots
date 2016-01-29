import java.awt.Point;

public class Robot {

	private Mars mars;
	private Point robotLocation;
	private Direction robotDirection;
	private int checkState = 0;
	private String scentOutpUt = "";

	public Robot(Mars mars, Point robotLocation, Direction robotDirecton) {
		this.mars = mars;
		this.robotLocation = robotLocation;
		this.robotDirection = robotDirecton;
		mars.addRobots(this);
	}

	public void readInstructions(String instructions) {

		/**
		 * make sure instructions is less than 100;
		 */
		if (instructions.length() >= 100) {
			System.err.println("instructions length is bigger than 100");
			System.exit(0);
		}
		char[] instructionsChars = instructions.toUpperCase().toCharArray();
		for (char letters : instructionsChars) {

			if (checkState == 1) {
				break;
			}

			switch (letters) {
			case 'L':
				turnLeft();
				System.out.println("Left:" + this.getRobotLocation() + " " + getRobotDirection());
				break;
			case 'F':
				moveStraight();
				System.out.println("forward:" + this.getRobotLocation() + " " + getRobotDirection());
				break;
			case 'R':
				turnRight();
				System.out.println("right:" + this.getRobotLocation() + " " + getRobotDirection());
				break;
			}

		}
		System.out.println();

	}

	private void turnRight() {
		switch (robotDirection) {
		case North:
			this.setRobotDirection(Direction.East);
			break;
		case East:
			this.setRobotDirection(Direction.South);
			break;
		case South:
			this.setRobotDirection(Direction.West);
			break;
		case West:
			this.setRobotDirection(Direction.North);
			break;
		}

	}

	private void turnLeft() {
		switch (robotDirection) {
		case North:
			this.setRobotDirection(Direction.West);
			break;
		case East:
			this.setRobotDirection(Direction.North);
			break;
		case South:
			this.setRobotDirection(Direction.East);
			break;
		case West:
			this.setRobotDirection(Direction.South);
			break;
		}
	}

	private void moveStraight() {
		Scent tempScent = new Scent(this.getRobotLocation(), this.getRobotDirection());
		moveForward(matchesStoredScent(tempScent));
		if (checkState() == 1) {
			if (matchesStoredScent(tempScent)) {
				checkState = 0;
			}
			mars.addScents(tempScent);
			scentOutpUt = tempScent.getScentLocation().getX() + " " + tempScent.getScentLocation().getY() + " "
					+ tempScent.getScentDirection().toString() + " LOST";
			return;
		}
	}

	public void moveForward(boolean check) {
		if (check) {
			return;
		} else {
			switch (robotDirection) {
			case North:
				int getY_North = this.getRobotLocation().y;
				this.getRobotLocation().setLocation(robotLocation.x, ++getY_North);
				break;
			case East:
				int getX_East = this.getRobotLocation().x;
				this.getRobotLocation().setLocation(++getX_East, robotLocation.y);
				break;
			case South:
				int getY_South = this.getRobotLocation().y;
				this.getRobotLocation().setLocation(robotLocation.x, --getY_South);
				break;
			case West:
				int getX_West = this.getRobotLocation().x;
				this.getRobotLocation().setLocation(--getX_West, robotLocation.y);
				break;
			}
		}
	}

	private boolean matchesStoredScent(Scent tempScent) {
		for (Scent storedScent : mars.getStoredScents()) {
			if (tempScent.equalLocation(storedScent) && tempScent.equalDirection(storedScent)) {
				return true;
			}
		}
		return false;
	}

	public int checkState() {
		int checkX = this.getRobotLocation().getX() > mars.getAreaOfPlanet().getX() ? 1 : 0;
		int checkY = this.getRobotLocation().getY() > mars.getAreaOfPlanet().getY() ? 1 : 0;
		int checkNegativeX = this.getRobotLocation().getX() < 0 ? 1 : 0;
		int checkNegativeY = this.getRobotLocation().getY() < 0 ? 1 : 0;

		if (checkX == 1 || checkY == 1 || checkNegativeX == 1 || checkNegativeY == 1) {
			checkState = 1;
		}

		return checkState;
	}

	@Override
	public String toString() {
		String output = "";
		switch (checkState) {
		case 1:
			output = scentOutpUt;
			break;
		case 0:
			output = this.getRobotLocation().getX() + " " + this.getRobotLocation().getY() + " "
					+ this.getRobotDirection().toString();
			break;
		}
		return output;
	}

	public Point getRobotLocation() {
		return robotLocation;
	}

	public void setRobotLocation(Point robotLocation) {
		this.robotLocation = robotLocation;
	}

	public Direction getRobotDirection() {
		return robotDirection;
	}

	public void setRobotDirection(Direction robotDirection) {
		this.robotDirection = robotDirection;
	}
}
