import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Robot one = new Robot(new Coordinate(1, 1), Direction.East, "rfrfrfrf");
		Robot two = new Robot( new Coordinate(3, 2), Direction.North, "frrfllffrrfll");
		Robot three = new Robot(new Coordinate(0, 3), Direction.West, "llffflflfl");
		ArrayList<Robot> robots = new ArrayList<Robot>();
		robots.add(one);
		robots.add(two);
		robots.add(three);
	    new Mars(new Coordinate(5, 3),robots);
	}
}
