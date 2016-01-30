public class Robot {

    private Coordinate robotLocation;
    private Direction robotDirection;
    private int checkState = 0;
    private String instruct,alias;
    private boolean instructionCheck = false;
    
    public Robot(String alias,Coordinate point, Direction robotDirection, String InstructionsString) {
        this.robotLocation = point;
        this.robotDirection = robotDirection;
        this.instruct = InstructionsString;
        this.alias=alias;
    }

   
	public void readInstructions(String instructions, Mars mars) {
        /**
         * make sure instructions String is less than 100;
         */
        if (instructions == null || instructions.length() >= 100) {
            instructionCheck = true;
            return;
        }
        char[] instructionsChars = instructions.toUpperCase().toCharArray();
        for (char letters : instructionsChars) {

            if (checkState == 1 || instructionCheck) {
                break;
            }

            switch (letters) {
                case 'L':
                    turnLeft();
                    System.out.println("Left:" + this.getRobotLocation().toString() + " " + getRobotDirection());
                    break;
                case 'F':
                    moveStraight(mars);
                    System.out.println("forward:" + this.getRobotLocation().toString() + " " + getRobotDirection());
                    break;
                case 'R':
                    turnRight();
                    System.out.println("right:" + this.getRobotLocation().toString() + " " + getRobotDirection());
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

    private void moveStraight(Mars mars) {
        Scent tempScent = new Scent(new Coordinate(this.getRobotLocation()), this.getRobotDirection());
        if (matchesStoredScent(tempScent, mars)) {
            return;
        } else {
            moveForward(tempScent, mars);
        }
    }

    public void moveForward(Scent tempScent, Mars mars) {
        switch (robotDirection) {
            case North:
                int getY_North = this.getRobotLocation().getY();
                this.getRobotLocation().setLocation(robotLocation.getX(), ++getY_North);
                break;
            case East:
                int getX_East = this.getRobotLocation().getX();
                this.getRobotLocation().setLocation(++getX_East, robotLocation.getY());
                break;
            case South:
                int getY_South = this.getRobotLocation().getY();
                this.getRobotLocation().setLocation(robotLocation.getX(), --getY_South);
                break;
            case West:
                int getX_West = this.getRobotLocation().getX();
                this.getRobotLocation().setLocation(--getX_West, robotLocation.getY());
                break;
        }
        if (checkState(mars) == 1) {
            mars.addScents(tempScent);
            return;
        }
    }

    private boolean matchesStoredScent(Scent tempScent, Mars mars) {
        for (Scent storedScent : mars.getScentsArray()) {
            if (storedScent == null) {
                break;
            } else {
                if (storedScent.getScentLocation().equals(tempScent.getScentLocation())
                        && storedScent.getScentDirection().equals(tempScent.getScentDirection())) {
                    return true;
                }
            }

        }
        return false;
    }

    public int checkState(Mars mars) {
        int checkX = this.getRobotLocation().getX() > mars.getAxisOfPlanet().getX() ? 1 : 0;
        int checkY = this.getRobotLocation().getY() > mars.getAxisOfPlanet().getY() ? 1 : 0;
        int checkNegativeX = this.getRobotLocation().getX() < 0 ? 1 : 0;
        int checkNegativeY = this.getRobotLocation().getY() < 0 ? 1 : 0;

        if (checkX == 1 || checkY == 1 || checkNegativeX == 1 || checkNegativeY == 1) {
            setCheckState(1);
        }

        return checkState;
    }

    public Coordinate getRobotLocation() {
        return robotLocation;
    }

    public boolean getInstructionCheck() {
        return instructionCheck;
    }

    public void setInstructionCheck(boolean instructionCheck) {
        this.instructionCheck = instructionCheck;
    }

    public void setRobotLocation(Coordinate robotLocation) {
        this.robotLocation = robotLocation;
    }

    public Direction getRobotDirection() {
        return robotDirection;
    }

    public void setRobotDirection(Direction robotDirection) {
        this.robotDirection = robotDirection;
    }

    public String getInstruct() {
        return instruct;
    }

    public int getCheckState() {
        return checkState;
    }

    public void setCheckState(int checkState) {
        this.checkState = checkState;
    }

    public String getAlias() {
		return alias;
	}

}
