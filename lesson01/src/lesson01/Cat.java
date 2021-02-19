package lesson01;

public class Cat implements Moving {
    private int maxDistance;
    private int maxHeight;
    Cat(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }
    @Override
    public boolean run(int ivDistance){
        if (ivDistance <= maxDistance) {
            System.out.println("Myau Myau " + ivDistance + " meters");
            return true;
        }
        else {
            System.out.println(ivDistance + " - fsssssss! Myau " + maxDistance);
            return false;
        }
    }
    @Override
    public boolean jump(int ivHeight){
        if (ivHeight <= maxHeight) {
            System.out.println("Myau Myau " + ivHeight + " meters");
            return true;
        }
        else {
            System.out.println(ivHeight + " - phsssssss! Myau " + maxHeight);
            return false;
        }
    }

    @Override
    public boolean chooseAction(Rising rising) {
        if (rising instanceof Stone)
            return jump(((Stone) rising).getHeight());
        else if (rising instanceof Street)
            return run(((Street) rising).getLength());
        else
            return false;
    };
}
