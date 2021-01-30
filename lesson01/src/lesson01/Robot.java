package lesson01;

public class Robot implements Moving {
    private int maxDistance;
    private int maxHeight;
    Robot(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }
    @Override
    public boolean run(int ivDistance){
        if (ivDistance <= maxDistance) {
            System.out.println("IT IS RUNNING " + ivDistance + " M");
            return true;
        }
        else {
            System.out.println(ivDistance + " - SHORT DUMP! MAX LENGTH FOR IT IS " + maxDistance);
            return false;
        }

    }
    @Override
    public boolean jump(int ivHeight){
        if (ivHeight <= maxHeight) {
            System.out.println("IT IS JUMPING " + ivHeight + " M");
            return true;
        }
        else {
            System.out.println(ivHeight + " - BLUE SCREEN... MAX HEIGHT FOR IT IS " + maxHeight);
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
