package lesson01;

public class Stone implements Rising{
    private int height;
    Stone(int height){
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void riseMoving(Moving ioMoving) {
        ioMoving.jump(height);
    }
}
