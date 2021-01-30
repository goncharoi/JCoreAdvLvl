package lesson01;

public class Human implements Moving {
    private int maxDistance;
    private int maxHeight;
    Human(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }
    @Override
    public void run(int ivDistance){
        if (ivDistance <= maxDistance)
            System.out.println("I'm running " + ivDistance + " meters");
        else
            System.out.println(ivDistance + " is too long for me. My max is " + maxDistance);
    }
    @Override
    public void jump(int ivHeight){
        if (ivHeight <= maxHeight)
            System.out.println("I'm jumping over " + ivHeight + " meters");
        else
            System.out.println(ivHeight + " is too high for me. My max is " + maxHeight);
    }

    @Override
    public void chooseAction(Rising rising) {
        if (rising instanceof Stone)
            jump(((Stone) rising).getHeight());
        else if (rising instanceof Street)
            run(((Street) rising).getLength());
    };

}
