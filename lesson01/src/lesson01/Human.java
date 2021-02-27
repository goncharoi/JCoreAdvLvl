package lesson01;

public class Human implements Moving {
    private int maxDistance;
    private int maxHeight;
    Human(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }
    @Override
    public boolean run(int ivDistance){
        if (ivDistance <= maxDistance) {
            System.out.println("I'm running " + ivDistance + " meters");
            return true;
        }
        else {
            System.out.println(ivDistance + " is too long for me. My max is " + maxDistance);
            return false;
        }
    }
    @Override
    public boolean jump(int ivHeight){
        if (ivHeight <= maxHeight){
            System.out.println("I'm jumping over " + ivHeight + " meters");
            return true;
        }
        else {
            System.out.println(ivHeight + " is too high for me. My max is " + maxHeight);
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
