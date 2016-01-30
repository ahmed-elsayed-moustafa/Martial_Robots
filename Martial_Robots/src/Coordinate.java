public class Coordinate {

	private int x, y;

	public  Coordinate( Coordinate c) {
		this(c.x, c.y);
	}

	public  Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public  Coordinate getLocation() {
		return new Coordinate(x, y);
	}

	public void setLocation(Coordinate p) {
		this.x = p.x;
		this.y = p.y;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object object) {
		if (object instanceof  Coordinate) {
			 Coordinate pt = (Coordinate) object;
			return (x == pt.x) && (y == pt.y);
		}
		return super.equals(object);
	}

	@Override
	public String toString() {
		return x + "," + y;
	}
}
