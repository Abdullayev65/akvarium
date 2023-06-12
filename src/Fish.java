public class Fish extends Thread {
    private final Coordinate coordinate;
    private int life;
    private final boolean female;
    private final Aquarium aquarium;


    public Fish(Coordinate coordinate, int life, boolean female, Aquarium aquarium) {
        this.coordinate = coordinate;
        this.life = life;
        this.female = female;
        this.aquarium = aquarium;
    }

    @Override
    public void run() {
        while (life > 0) {
            move();
            try {
                Thread.sleep(Config.FISH_SLEEP_MILLIS);
                life--;
                aquarium.checkForCollision(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        aquarium.removeFish(this);
    }

    public void move() {
        coordinate.move();
    }

    public boolean collision(Fish f) {
        return this.coordinate.equals(f.coordinate)
                && this.female != f.female;
    }

    public boolean isFemale() {
        return female;
    }
    public boolean isMale() {
        return !female;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "coordinateX=" + coordinate +
                ", life=" + life +
                ", female=" + female +
                '}';
    }
}
