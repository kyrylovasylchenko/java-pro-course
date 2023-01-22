package homeworks.VKS_03;

public abstract class Animal{
    public static int counter;

    public Animal() {
        counter++;
    }

    public abstract void run(int range);
}
