package maman14;
 
/**
 *
 * @author nicole.vardi
 */
public class TestEx14
{
 
    public static void main(String[] args)
    {
        //Check Q1
        //int [][] what_check = {{1,2,3},{2,3,4},{3,4,5}};
        //int [][] test_check = {{25,10,8},{30,35,40},{40,47,59}};
        //int [][] what_check = {{1,2,3,3},{2,3,5,6},{3,3,7,8},{3,3,9,9}};
        int[][] what_check =
        {
            {
                1, 2, 3, 3
            },
            {
                2, 3, 5, 6
            },
            {
                3, 3, 7, 8
            },
            {
                3, 3, 9, 9
            }
        };
        int[][] test_check =
        {
            {
                25, 10, 8
            },
            {
                30, 35, 40
            },
            {
                40, 47, 59
            }
        };
        int val_check1 = 11;
        int val_check2 = 4;
 
        System.out.println("Checking Question 1:");
        System.out.println("Checking findValWhat:");
 
        for (int[] what1 : what_check)
        {
            for (int i : what1)
            {
                System.out.print(i + ",");
                boolean findValWhat = Ex14.findValWhat(what_check, i);
                System.out.print(" " + findValWhat + " ");
            }
            System.out.println();
 
        }
 
        System.out.println();
        System.out.println("Checking findValTest:");
        for (int[] test1 : test_check)
        {
            for (int i : test1)
            {
                System.out.print(i + ",");
                boolean findValTest = Ex14.findValTest(test_check, i);
                System.out.print(" " + findValTest + " ");
            }
            System.out.println();
 
        }
 
        System.out.println("If you see false, check your solution.");
        System.out.println("\nChecking that " + val_check1 + " is not in the array.");
 
        boolean findValWhatFalse1 = Ex14.findValWhat(what_check, val_check1);
       
        if (findValWhatFalse1 == false)
        {
            System.out.print(findValWhatFalse1 + ". findValWhat passed.");
        }
        else
        {
            System.out.print(findValWhatFalse1 + ". Problem. Check your solution. Output should be false");
        }
 
        System.out.println();
        boolean findValTestFalse1 = Ex14.findValTest(test_check, val_check1);
        if (findValTestFalse1 == false)
        {
            System.out.print(findValTestFalse1 + ". findValTest passed.");
        }
        else
        {
            System.out.print(findValTestFalse1 + ". Problem. Check your solution. Output should be false");
        }
 
        System.out.println();
        System.out.println("\nChecking that " + val_check2 + " is not in the array.");
 
        boolean findValWhatFalse2 = Ex14.findValWhat(what_check, val_check2);
        if (findValWhatFalse2 == false)
        {
            System.out.print(findValWhatFalse2 + ". findValWhat passed.");
        }
        else
        {
            System.out.print(findValWhatFalse2 + ". Problem. Check your solution. Output should be false");
        }
 
        System.out.println();
        boolean findValTestFalse2 = Ex14.findValTest(test_check, val_check2);
        if (findValTestFalse2 == false)
        {
            System.out.print(findValTestFalse2 + ". findValTest passed.");
        }
        else
        {
            System.out.print(findValTestFalse2 + ". Problem. Check your solution. Output should be false");
        }
 
        //Check Q2
        int[] what2_check1 =
        {
            2, 1, 2, 3, 2, 5, 2, 2, 2
        };
        int[] what2_check2 =
        {
            2, 2, 2, 2, 2, 2, 1, 2, 2
        };
        int[] what2_check3 =
        {
            1, 2, 2, 3, -2, 2, 2, 2, -5
        };
        int[] what2_check4 =
        {
            4, 2, 2, 4, 2, 2, 2, 4, 2
        };
        int what2Output1 = Ex14.what(what2_check1);
        int what2Output2 = Ex14.what(what2_check2);
        int what2Output3 = Ex14.what(what2_check3);
        int what2Output4 = Ex14.what(what2_check4);
 
        System.out.println("\n\nChecking Question 2:");
        //Check first array
        for (int i : what2_check1)
        {
            System.out.print(i + "\t");
        }
 
        System.out.println();
 
        if (what2Output1 == 7)
        {
            System.out.println("Result is = " + what2Output1 + ". Passed");
        }
        else
        {
            System.out.println("Result is = " + what2Output1 + ". Failed. Results should be 7. Check your solution.");
        }
 
        //Check second array
        for (int i : what2_check2)
        {
            System.out.print(i + "\t");
        }
 
        System.out.println();
 
        if (what2Output2 == 6)
        {
            System.out.println("Result is = " + what2Output2 + ". Passed");
        }
        else
        {
            System.out.println("Result is = " + what2Output2 + ". Failed. Results should be 6. Check your solution.");
        }
 
        //Check third array
        for (int i : what2_check3)
        {
            System.out.print(i + "\t");
        }
 
        System.out.println();
 
        if (what2Output3 == 8)
        {
            System.out.println("Result is = " + what2Output3 + ". Passed");
        }
        else
        {
            System.out.println("Result is = " + what2Output3 + ". Failed. Results should be 8. Check your solution.");
        }
 
        //Check fourth array
        for (int i : what2_check4)
        {
            System.out.print(i + "\t");
        }
 
        System.out.println();
 
        if (what2Output4 == 9)
        {
            System.out.println("Result is = " + what2Output4 + ". Passed");
        }
        else
        {
            System.out.println("Result is = " + what2Output4 + ". Failed. Results should be 9. Check your solution.");
        }
        //Check Q3a
        int num1 = 0;
        int num2 = 123456781;
        int num3 = 10001;
        int num4 = 102031;
        int num5 = 6;
 
        //Check predefined values
        System.out.println("\nChecking Question 3:");
        String weightOutput = String.format("%d, %d, %d, %d, %d, %d, %d", Ex14.weight(num1, 0), Ex14.weight(num2, 5), Ex14.weight(num2, 2), Ex14.weight(num3, 0),
                Ex14.weight(num4, 2), Ex14.weight(num5, 6), Ex14.weight(num5, 8));
        System.out.println(weightOutput);
        if (Ex14.weight(num1, 0) == 0 && Ex14.weight(num2, 5) == 10000 && Ex14.weight(num2, 2) == 10000000 && Ex14.weight(num3, 0) == 10
                && Ex14.weight(num4, 2) == 1000 && Ex14.weight(num5, 6) == 1 && Ex14.weight(num5, 8) == 0)
        {
            System.out.println("weight Passed.");
        }
        else
        {
            System.out.println("weight Failed. Check your solution. Output should be 0, 10000, 10000000, 10, 1000, 1 ,0");
        }
        System.out.println();
 
        String weightRecOutput = String.format("%d, %d, %d, %d, %d, %d, %d", Ex14.weightRec(num1, 0), Ex14.weightRec(num2, 5), Ex14.weightRec(num2, 2), Ex14.weightRec(num3, 0),
                Ex14.weightRec(num4, 2), Ex14.weightRec(num5, 6), Ex14.weightRec(num5, 8));
        System.out.println(weightRecOutput);
        if (Ex14.weightRec(num1, 0) == 0 && Ex14.weightRec(num2, 5) == 10000 && Ex14.weightRec(num2, 2) == 10000000 && Ex14.weightRec(num3, 0) == 10
                && Ex14.weightRec(num4, 2) == 1000 && Ex14.weightRec(num5, 6) == 1 && Ex14.weightRec(num5, 8) == 0)
        {
            System.out.println("weightRec Passed.");
        }
        else
        {
            System.out.print("weightRec Failed. Check your solution. Output should be 0, 10000, 10000000, 10, 1000, 1 ,0");
        }
 
        //Check Q3b
        String reverseOutput = Ex14.reverse(num1) + ", " + Ex14.reverse(num2) + ", " + Ex14.reverse(num3) + ", " + Ex14.reverse(num4) + ", " + Ex14.reverse(num5);
        String reverseRecOutput = Ex14.reverseRec(num1, 0) + ", " + Ex14.reverseRec(num2,0) + ", " + Ex14.reverseRec(num3,0) + ", " + Ex14.reverseRec(num4,0) + ", " + Ex14.reverseRec(num5,0);
        System.out.println("\nReverse the following numbers: " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5);
        System.out.println(reverseOutput);
        if ("0, 187654321, 10001, 130201, 6".equals(reverseOutput))
        {
            System.out.println("reverse Passed.");
        }
        else
        {
            System.out.println("reverse Failed. Check your solution. Output should be 0, 187654321, 10001, 130201, 656565");
        }
 
        System.out.println(reverseRecOutput);
        if ("0, 187654321, 10001, 130201, 6".equals(reverseRecOutput))
        {
            System.out.println("reverseRec Passed.");
        }
        else
        {
            System.out.println("reverseRec Failed. Check your solution. Output should be 0, 187654321, 10001, 130201, 656565");
        }
 
        //Check Q4
        //int [][] countPaths_check = {{12,22,23,54},{43,35,21,20},{34,21,43,21},{25,30,0,20},{0,22,10,10},{20,13,3,45}};
        int[][] countPaths_check1 =
        {
            {
                12, 22, 23, 54
            },
            {
                43, 35, 21, 20
            },
            {
                34, 21, 43, 21
            },
            {
                25, 30, 0, 20
            },
            {
                0, 22, 10, 10
            },
            {
                20, 13, 3, 45
            }
        };
        int[][] countPaths_check2 =
        {
            {
                12, 22, 23, 54
            },
            {
                43, 35, 21, 20
            },
            {
                34, 11, 43, 21
            },
            {
                25, 30, 0, 20
            },
            {
                0, 22, 10, 10
            },
            {
                20, 13, 3, 45
            }
        };
        int[][] countPaths_check3 =
        {
            {
                22, 7, 35
            },
            {
                3, 9, 49
            },
            {
                7, 82, 93
            }
        };
        int countPaths1 = Ex14.countPaths(countPaths_check1);
        int countPaths2 = Ex14.countPaths(countPaths_check2);
        int countPaths3 = Ex14.countPaths(countPaths_check3);
 
        System.out.println("\nChecking Question 4:");
        for (int[] countPathsP1 : countPaths_check1)
        {
            for (int i : countPathsP1)
            {
                System.out.print(i + "\t");
            }
            System.out.println();
 
        }
        System.out.println("Number of legal pathes found is: " + countPaths1);
        if (countPaths1 == 3)
        {
            System.out.print("countPaths Passed");
        }
        else
        {
            System.out.print("countPaths Failed. Check your solution. Output should be 3 legal pathes.");
        }
        System.out.println();
 
        for (int[] countPathsP2 : countPaths_check2)
        {
            for (int i : countPathsP2)
            {
                System.out.print(i + "\t");
            }
            System.out.println();
 
        }
        System.out.println("Number of legal pathes found is: " + countPaths2);
        if (countPaths2 == 1)
        {
            System.out.print("countPaths Passed");
        }
        else
        {
            System.out.print("countPaths Failed. Check your solution. Output should be 1 legal pathes.");
        }
        System.out.println();
 
        for (int[] countPathsP3 : countPaths_check3)
        {
            for (int i : countPathsP3)
            {
                System.out.print(i + "\t");
            }
            System.out.println();
 
        }
        System.out.println("Number of legal pathes found is: " + countPaths3);
        if (countPaths3 == 1)
        {
            System.out.print("countPaths Passed");
        }
        else
        {
            System.out.print("countPaths Failed. Check your solution. Output should be 1 legal pathes.");
        }
        System.out.println();
 
    }//end main
}//end TestEx14 calss