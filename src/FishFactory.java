public class FishFactory {

    public static Fish createFish(Aquarium aquarium) {
        Coordinate coordinate = Coordinate.random();

        int life = AquariumUtil.getRandomBetween(
                Config.MIN_LIFE_FISH,
                Config.MAX_LIFE_FISH);

        boolean female = AquariumUtil.getRandomBool();

        return new Fish(coordinate, life, female, aquarium);
    }
}
