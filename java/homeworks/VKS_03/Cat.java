package homeworks.VKS_03;

public class Cat extends Animal {
    public static int counter;

    public Cat() {
        counter++;
    }

    @Override
    public void run(int range) {
        if (range <= 200 && range > 0) {
            System.out.println("The cat ran" + range + "meters");
        } else {
            System.out.println("The cat can't run this distance");
        }
    }
}
