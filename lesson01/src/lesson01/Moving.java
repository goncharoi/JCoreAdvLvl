package lesson01;

public interface Moving {
    boolean run(int ivDistance);
    boolean jump(int ivHeight);
    boolean chooseAction(Rising rising);
}
