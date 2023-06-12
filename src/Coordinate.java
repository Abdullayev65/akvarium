public class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;
    private int z;

    public static Coordinate random() {
        return new Coordinate(
                AquariumUtil.getRandom(Config.AQUARIUM_LENGTH + 1),
                AquariumUtil.getRandom(Config.AQUARIUM_HEIGHT + 1),
                AquariumUtil.getRandom(Config.AQUARIUM_WIDTH + 1)
        );
    }

    public void move() {
        int direction = AquariumUtil.getRandom(7);

        switch (direction) {
            case 0 -> {
                if (y < Config.AQUARIUM_HEIGHT) y++;
            }
            case 1 -> {
                if (x < Config.AQUARIUM_LENGTH) x++;
            }
            case 2 -> {
                if (z < Config.AQUARIUM_WIDTH) z++;
            }
            case 3 -> {
                if (y > 0) y--;
            }
            case 4 -> {
                if (x > 0) x--;
            }
            case 5 -> {
                if (z > 0) z--;
            }
        }
    }

    @Override
    public int compareTo(Coordinate o) {
        return (x - o.x)
                + (y - o.y)
                + (z - o.z);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate that))
            return false;
        return that.x == x && that.y == y && that.z == z;
    }

    @Override
    public int hashCode() {
        return (x << 2)
                + (y << 3)
                + (z << 4);
    }

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
