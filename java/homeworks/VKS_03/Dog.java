package homeworks.VKS_03;

public class Dog extends Animal implements Swimming{
    public static int counter;

    public Dog() {
        counter++;
    }

    @Override
    public void run(int range) {
        if(range <= 500 && range > 0){
            System.out.println("The dog ran" + range + "meters");
        }else{
            System.out.println("The dog can't run this distance");
        }
    }

    @Override
    public void swim(int range) {
        if(range <= 10 && range > 0){
            System.out.println("The dog swim" + range + "meters");
        }else{
            System.out.println("The dog can't swim this distance");
        }
    }
}
