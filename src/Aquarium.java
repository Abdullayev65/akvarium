import java.util.LinkedList;

public class Aquarium {
    private final LinkedList<Fish> fishLinkedList = new LinkedList<>();

    public void start() {
        int size = AquariumUtil.getRandomBetween(
                Config.MIN_COUNT_INIT_FISHES, Config.MAX_COUNT_INIT_FISHES);

        for (int i = 0; i < size; i++) {
            fishLinkedList.add(
                    FishFactory.createFish(this)
            );
        }

        for (Fish fish : fishLinkedList) {
            fish.start();
        }
    }

    public void checkForCollision(Fish fish) {
        synchronized (fishLinkedList) {
            if (!(fishLinkedList.size() < Config.LIMIT_FISHES)) {
                printDetail();
                return;
            }

            Fish babyFish = null;
            for (Fish f : fishLinkedList) {
                if ((fish.collision(f))) {

                    babyFish = FishFactory.createFish(this);

                    String str = String.format("Collision: Fish1 - {%s}, Fish2 - {%s}, baby - {%s} , female - {%s}",
                            fish.hashCode(), f.hashCode(), babyFish.hashCode(), babyFish.isFemale());
                    System.out.println(str);
                    break;
                }
            }
            if (babyFish != null) {
                babyFish.start();
                fishLinkedList.add(babyFish);
            }

            printDetail();
        }
    }


    public synchronized void printDetail() {

        int totalSize = fishLinkedList.size();
        int m = 0;
        int f = 0;
        for (Fish fish : fishLinkedList) {
            if (fish.isMale()) {
                m++;
            } else {
                f++;
            }
        }
        System.out.println("==============================");
        System.out.println("Total Count:" + totalSize);
        System.out.println("Male:" + m);
        System.out.println("Female:" + f);
        System.out.println("==============================");
    }

    public void removeFish(Fish fish) {
        synchronized (fishLinkedList) {
            fishLinkedList.remove(fish);
            System.out.println("------------------------");
            System.out.println("Fish dead: " + fish);
            System.out.println("------------------------");
            printDetail();
        }
    }
}
