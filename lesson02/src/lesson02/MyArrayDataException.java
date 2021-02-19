package lesson02;

public class MyArrayDataException extends Exception {
    private int mvI, mvJ;
    public MyArrayDataException(int mvI, int mvJ){
        this.mvI = mvI;
        this.mvJ = mvJ;
    }

    public int getMvI() {
        return mvI;
    }

    public int getMvJ() {
        return mvJ;
    }

    @Override
    public void printStackTrace(java.io.PrintStream printStream){
        printStream.println("Ошибка в строке " + ++mvI + ", столбце " + ++mvJ);
        super.printStackTrace(printStream);
    }
}
