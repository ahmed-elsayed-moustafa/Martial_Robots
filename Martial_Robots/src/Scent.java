public class Scent {

    private Coordinate scentLocation;
    private Direction scentDirection;

    public Scent(Coordinate point, Direction scentDirection) {

        this.scentDirection = scentDirection;
        this.scentLocation = point;
    }

    public Coordinate getScentLocation() {
        return scentLocation;
    }

    public void setScentLocation(Coordinate scentLocation) {
        this.scentLocation = scentLocation;
    }

    public Direction getScentDirection() {
        return scentDirection;
    }

    public void setScentDirection(Direction scentDirection) {
        this.scentDirection = scentDirection;
    }

    public boolean equalDirection(Scent randomScent) {
        return this.scentDirection.equals(randomScent.getScentDirection());
    }
}
