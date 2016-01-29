import java.awt.Point;

public class Scent {

	private Point scentLocation;
	private Direction scentDirection;

	public Scent(Point scentLocation, Direction scentDirection) {

		this.scentDirection = scentDirection;
		this.scentLocation = scentLocation;
	}

	public Point getScentLocation() {
		return scentLocation;
	}

	public void setScentLocation(Point scentLocation) {
		this.scentLocation = scentLocation;
	}

	public Direction getScentDirection() {
		return scentDirection;
	}

	public void setScentDirection(Direction scentDirection) {
		this.scentDirection = scentDirection;
	}

	public boolean equalLocation(Scent randomScent) {
		return this.scentLocation.equals(randomScent.getScentLocation());
	}

	public boolean equalDirection(Scent randomScent) {
		return this.scentDirection.equals(randomScent.getScentDirection());
	}
}
