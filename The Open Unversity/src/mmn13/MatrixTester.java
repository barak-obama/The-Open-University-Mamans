package mmn13;

public class MatrixTester
{
    public static void main(String[] args) {
        int a[][] = new int[][] {{1}};
        Matrix m1 = new Matrix(a);
        System.out.println("\n"+ m1 + "Should print 1x1 matrix of 1\n");
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println(m1.makeNegative() + "Should print 1x1 matrix of 254\n");
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println(m1.imageFilterAverage() + "Should print 1x1 matrix of 1");
        System.out.println("\n----------------------------------------------------------------------\n");
        int b[][] = new int[5][5];
        Matrix m2 = new Matrix(b);
        System.out.println(m2 + "Should print 5x5 matrix of 0\n");
        System.out.println("\n----------------------------------------------------------------------\n");
        System.out.println(m2.makeNegative() + "Should print 5x5 matrix of 255\n");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(m2.imageFilterAverage() + "Should print 5x5 matrix of 0");
        System.out.println("\n----------------------------------------------------------------------\n");
        int c[][] = new int[][]{{19,124,28,35,38},{115,22,25,230,31},{9,21,22,249,230},{0,6,9,232,255},{2,5,10,116,129}};
        String res = "70\t55\t77\t64\t83\n51\t42\t84\t98\t135\n28\t25\t90\t142\t204\n7\t9\t74\t139\t201\n3\t5\t63\t125\t183";
        String neg = "236\t131\t227\t220\t217\n140\t233\t230\t25\t224\n246\t234\t233\t6\t25\n255\t249\t246\t23\t0\n253\t250\t245\t139\t126";
        Matrix m3 = new Matrix(c);
        System.out.println(m3 + "Should print 5x5 matrix like the example shows\n");
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println(m3.makeNegative() + "Should print this exact matrix:\n" + neg);
        System.out.println("\n----------------------------------------------------------------------\n");
        System.out.println(m3.imageFilterAverage() + "Should print this exact matrix:\n" + res);
    }
}