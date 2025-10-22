class Lab1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Лабараторная работа №1 з Java\n Виконавець: Чулiй Михайло\n Варiант №24\n");

        try{
            MatrixAction task1 = new MatrixAction(5);
            System.out.println("Завдання С5: \n");
            task1.Action1();

            System.out.println("\nЗавдання С11: ");
            task1.Action2();
        }
        catch(Exception e){
            System.out.println("Виникла помилка: " + e.getMessage());
        }
       
    }
}

class MatrixAction {
    private int _size;

    public MatrixAction(int size) {
        _size = size;
    }

    public void Action1() { // C5 = 24 % 5 = 4 тому дія - C = A x B де x - матричний добуток
        int [][] matrixA = GenerateMatrix();
        int [][] matrixB = GenerateMatrix();

        System.out.println("Матриця A:");
        PrintMatrix(matrixA);

        System.out.println("\nМатриця B:");
        PrintMatrix(matrixB);

        int [][] matrixC = new int[_size][_size];

        for (int i = 0; i < _size; i++) {
            for (int j = 0; j < _size; j++) {
                matrixC[i][j] = 0;
                for (int k = 0; k < _size; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        System.out.println("\nРезультат добутку матриця С: ");
        PrintMatrix(matrixC);
    }

    public void Action2() { // С11 = 24 % 11 = 2 тому дія - Обчислити суму найбільших елементів кожного стовпця матриці 
        int [][] matrixC11 = GenerateMatrix();
        int sum = 0;

        System.out.println("\nПочаткова матриця С11: ");
        PrintMatrix(matrixC11);

        for(int i = 0; i < _size; i++){
            int max = matrixC11[0][i];
            for(int j = 0; j < _size; j++){
                if(matrixC11[j][i] > max){
                    max = matrixC11[j][i];
                }
            }
            sum += max;
        }
        System.out.println("\nСума найбiльших елементiв кожного стовпця: " + sum);
    }

    public void PrintMatrix(int [][] matrix) {  // Допоміжний метод аби не виводити матрицю в кожному методі окремо
        for (int i = 0; i < _size; i++) {
            for (int j = 0; j < _size; j++) {
                System.out.print(matrix[i][j] + " " );
            }
            System.out.println();
        }
    }

    public int [][] GenerateMatrix() {
        int[][] matrix = new int[_size][_size];
        for (int i = 0; i < _size; i++) {
            for (int j = 0; j < _size; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }
        return matrix;
    }
}

