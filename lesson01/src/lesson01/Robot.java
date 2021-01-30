package lesson01;

public class Robot implements Moving {
    private int maxDistance;
    private int maxHeight;
    Robot(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }
    @Override
    public void run(int ivDistance){
        if (ivDistance <= maxDistance)
            System.out.println("IT IS RUNNING " + ivDistance + " M");
        else
            System.out.println(ivDistance + " - SHORT DUMP! MAX LENGTH FOR IT IS " + maxDistance);

    }
    @Override
    public void jump(int ivHeight){
        if (ivHeight <= maxHeight)
            System.out.println("IT IS JUMPING " + ivHeight + " M");
        else
            System.out.println(ivHeight + " - BLUE SCREEN... MAX HEIGHT FOR IT IS " + maxHeight);
    }

    @Override
    public void chooseAction(Rising rising) {
        if (rising instanceof Stone)
            jump(((Stone) rising).getHeight());
        else if (rising instanceof Street)
            run(((Street) rising).getLength());
    };
}
