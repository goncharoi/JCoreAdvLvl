package lesson01;

public class Street implements Rising{
    private int length;
    Street(int length){
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void riseMoving(Moving ioMoving) {
        ioMoving.run(length);
    }
}
