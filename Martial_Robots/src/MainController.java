import java.awt.Point;

public class MainController {

	public static void main(String[] args) {

		Mars planet = new Mars(new Point(5, 3));
		Robot robo1 = new Robot(planet, new Point(1, 1), Direction.East);
		Robot robo2 = new Robot(planet, new Point(3, 2), Direction.North);
		Robot robo3 = new Robot(planet, new Point(0, 3), Direction.West);
		
		robo1.readInstructions("rfrfrfrf");
		robo2.readInstructions("frrfllffrrfll");
		robo3.readInstructions("llffflflfl");
		for (Robot robot : planet.getActiveRobots()) {
			System.out.println(robot.toString());
		}

	}
}
