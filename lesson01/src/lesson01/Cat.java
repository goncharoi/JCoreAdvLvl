package lesson01;

public class Cat implements Moving {
    private int maxDistance;
    private int maxHeight;
    Cat(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }
    @Override
    public void run(int ivDistance){
        if (ivDistance <= maxDistance)
            System.out.println("Myau Myau " + ivDistance + " meters");
        else
            System.out.println(ivDistance + " - fsssssss! Myau " + maxDistance);
    }
    @Override
    public void jump(int ivHeight){
        if (ivHeight <= maxHeight)
            System.out.println("Myau Myau " + ivHeight + " meters");
        else
            System.out.println(ivHeight + " - phsssssss! Myau " + maxHeight);
    }

    @Override
    public void chooseAction(Rising rising) {
        if (rising instanceof Stone)
            jump(((Stone) rising).getHeight());
        else if (rising instanceof Street)
            run(((Street) rising).getLength());
    };
}
