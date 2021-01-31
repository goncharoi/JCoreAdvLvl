package lesson02;

public class Main {
    public static final int SIZE = 4;

    public static void main(String[] args) {
        System.out.println("*********************************");
        System.out.println("Тест 1: ругаемся на длину массива");
        System.out.println("*********************************");
        String[][] ltTest01 = {{"0","1","1","5"},{"0","1","1"},{"0","1","1"},{"0","1","1"}};
        checkArrayWithoutEx(ltTest01);

        System.out.println("*********************************");
        System.out.println("Тест 2: ругаемся на неправильный символ");
        System.out.println("*********************************");
        String[][] ltTest02 = {{"0","1","1","5"},{"0","1","3","1"},{"4","0","1","1"},{"Ошибочка","5","6","9"}};
        checkArrayWithoutEx(ltTest02);

        System.out.println("*********************************");
        System.out.println("Тест 3: ни на что не ругаемся");
        System.out.println("*********************************");
        String[][] ltTest03 = {{"0","1","1","5"},{"0","1","3","1"},{"4","0","1","1"},{"0","5","6","9"}};
        checkArrayWithoutEx(ltTest03);
    }
    public static void checkArray(String[][] itArray) throws MyArrayDataException, MyArraySizeException {
        if (itArray.length != SIZE) throw new MyArraySizeException();
        for (int i = 0; i < SIZE; i++) {
            if (itArray[i].length != SIZE) throw new MyArraySizeException();
            for (int j = 0; j < SIZE; j++) {
                try {
                    int lvTest = Integer.parseInt(itArray[i][j]);
                } catch (NumberFormatException loEx){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
    }
    //обертка над checkArray
    public static void checkArrayWithoutEx(String[][] itArray){
        try{
            checkArray(itArray);
        } catch (MyArraySizeException loMASEx){
            loMASEx.printStackTrace(System.out);
        } catch (MyArrayDataException loMADEx) {
            loMADEx.printStackTrace(System.out);
        }
    }
}
