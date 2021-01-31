package lesson02;

public class Main {
    public static final int SIZE = 4;

    public static void main(String[] args) {
        System.out.println("*********************************");
        System.out.println("Тест 1: ругаемся на длину массива");
        System.out.println("*********************************");
        String[][] ltTest01 = {{"0","1","1","5"},{"0","1","1"},{"0","1","1"},{"0","1","1"}};
        printSumArray(ltTest01);

        System.out.println("*********************************");
        System.out.println("Тест 2: ругаемся на неправильный символ");
        System.out.println("*********************************");
        String[][] ltTest02 = {{"0","1","1","5"},{"0","1","3","1"},{"4","0","1","1"},{"Ошибочка","5","6","9"}};
        printSumArray(ltTest02);

        System.out.println("*********************************");
        System.out.println("Тест 3: ни на что не ругаемся");
        System.out.println("*********************************");
        String[][] ltTest03 = {{"0","1","1","5"},{"0","1","3","1"},{"4","0","1","1"},{"0","5","6","9"}};
        printSumArray(ltTest03);
    }
    public static int getSumArray(String[][] itArray) throws MyArrayDataException, MyArraySizeException {
        int rvSumm = 0;
        if (itArray.length != SIZE) throw new MyArraySizeException();
        for (int i = 0; i < SIZE; i++) {
            if (itArray[i].length != SIZE) throw new MyArraySizeException();
            for (int j = 0; j < SIZE; j++) {
                try {
                    rvSumm += Integer.parseInt(itArray[i][j]);
                } catch (NumberFormatException loEx){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return rvSumm;
    }
    //обертка над checkArray
    public static void printSumArray(String[][] itArray){
        try{
            System.out.println("Сумма элементов массива = " + getSumArray(itArray));
        } catch (MyArraySizeException loMASEx){
            loMASEx.printStackTrace(System.out);
        } catch (MyArrayDataException loMADEx) {
            loMADEx.printStackTrace(System.out);
        }
    }
}
