package maman15;

/**
 *
 * @author nicole.vardi
 */
public class TestEx15
{

    public static void main(String[] args)
    {
        String checkLetters = "abcdefghijklmnopqrstuvwxyz";
        String stringToCheck01 = "anything you can do i can do better";
        String stringToCheck02 = " zulu oscar echo india sierra alpha hotel victor uniform foxtrot "
                + "romeo lima whiskey papa juliett tango november delta bravo xray xray kilo charlie yankee mike golf "
                + "quebec alpha foxtrot tango november delta bravo xray zulu ";
        String stringToCheck03 = "hello world this is my first text";
        TextList check_text01 = new TextList(stringToCheck01);
        TextList check_text02 = new TextList(stringToCheck02);
        TextList check_text03 = new TextList("");
//        TextList check_text04 = new TextList(" ");
//        TextList check_text05 = new TextList("  ");
        TextList check_text06 = new TextList();
        TextList check_text07 = new TextList(stringToCheck03);

        System.out.println("Please note: all of the below tests use the toString function to check pass!"
                + "\nif the method isn't correct, all of the test will fail.");
        System.out.println();

        //Check TextList() constructor
        System.out.println("Checking TextList() Constructor:");
        System.out.print("Expected:\n");
        System.out.print("Result:\n" + check_text06.toString());
        if ((check_text06.toString()).equals(""))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        //Check TextList(String text) constructor
        System.out.println("Checking TextList(String text) Constructor - empty string:");
        System.out.print("Expected:\n");
        System.out.print("Result:\n" + check_text03.toString());
        if ((check_text03.toString()).equals(""))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        //Check the given example from the exercise
        System.out.println("Checking TextList(String text) Constructor + toString - example given in the exercise:");
        System.out.println("Expected:\nanything\t1\nbetter\t1\ncan\t2\ndo\t2\ni\t1\nyou\t1\n");

        System.out.println("Result:\n" + check_text01.toString());

        if ((check_text01.toString()).equals("anything\t1\nbetter\t1\ncan\t2\ndo\t2\ni\t1\nyou\t1\n"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        //Check addToData
        System.out.println("Checking addToData:");
        System.out.println("Try to add 'mommy'");
        check_text06.addToData("mommy");
        System.out.print("Expected:\nmommy\t1\n");
        System.out.print("Result:\n" + check_text06.toString());
        if ((check_text06.toString()).equals("mommy\t1\n"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        System.out.println("Try to add 'mommy'");
        check_text06.addToData("mommy");
        System.out.print("Expected:\nmommy\t2\n");
        System.out.print("Result:\n" + check_text06.toString());
        if ((check_text06.toString()).equals("mommy\t2\n"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        System.out.println("Try to add 'ask'");
        check_text06.addToData("ask"); 
        System.out.print("Expected:\nask\t1\nmommy\t2\n");
        System.out.print("Result:\n" + check_text06.toString());
        if ((check_text06.toString()).equals("ask\t1\nmommy\t2\n"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        System.out.println("Try to add 'zebra'");
        check_text06.addToData("zebra"); 
        System.out.print("Expected:\nask\t1\nmommy\t2\nzebra\t1\n");
        System.out.print("Result:\n" + check_text06.toString());
        if ((check_text06.toString()).equals("ask\t1\nmommy\t2\nzebra\t1\n"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        System.out.println("Try to add 'clam'");
        check_text06.addToData("clam"); 
        System.out.print("Expected:\nask\t1\nclam\t1\nmommy\t2\nzebra\t1\n");
        System.out.print("Result:\n" + check_text06.toString());
        if ((check_text06.toString()).equals("ask\t1\nclam\t1\nmommy\t2\nzebra\t1\n"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed. Check your solution.");
        }

        System.out.println();

        //Check howManyWords
        System.out.println("Checking howManyWords:");
        System.out.println("In: '' (an empty list)");
        System.out.print("Result: " + check_text03.howManyWords() + "\n");
        if (check_text03.howManyWords() == 0)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: 0\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck01);
        System.out.print("Result: " + check_text01.howManyWords() + "\n");
        if (check_text01.howManyWords() == 8)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: 8\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck02);
        System.out.print("Result: " + check_text02.howManyWords() + "\n");
        if (check_text02.howManyWords() == 35)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: 35\nFailed. Check your solution.");
        }

        System.out.println();

        //Check howManyDifferentWords
        System.out.println("Checking howManyDifferentWords:");
        System.out.println("In: '' (an empty list)");
        System.out.print("Result: " + check_text03.howManyDifferentWords() + "\n");
        if (check_text03.howManyDifferentWords() == 0)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: 0\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck01);
        System.out.print("Result: " + check_text01.howManyDifferentWords() + "\n");
        if (check_text01.howManyDifferentWords() == 6)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: 6\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck02);
        System.out.print("Result: " + check_text02.howManyDifferentWords() + "\n");
        if (check_text02.howManyDifferentWords() == 26)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: 26\nFailed. Check your solution.");
        }

        System.out.println();

        //Check mostFrequentWord
        System.out.println("Checking mostFrequentWord:");
        System.out.println("In: '' (an empty list)");
        System.out.print("Result: " + check_text03.mostFrequentWord() + "\n");
        if (check_text03.mostFrequentWord().equals(""))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: \nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck01);
        System.out.print("Result: " + check_text01.mostFrequentWord() + "\n");
        if (check_text01.mostFrequentWord().equals("can"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: can\nFailed. Check your solution.");
        }

        System.out.println();
        
        System.out.println("In: " + stringToCheck03);
        System.out.print("Result: " + check_text07.mostFrequentWord() + "\n");
        if (check_text07.mostFrequentWord().equals("first"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: first\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck02);
        System.out.print("Result: " + check_text02.mostFrequentWord() + "\n");
        if (check_text02.mostFrequentWord().equals("xray"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: xray\nFailed. Check your solution.");
        }

        System.out.println();

        //Check mostFrequentStartingLetter
        System.out.println("Checking mostFrequentStartingLetter:");
        System.out.println("In: '' (an empty list)");
        System.out.print("Result: " + check_text03.mostFrequentStartingLetter() + "\n");
        if (check_text03.mostFrequentStartingLetter() == ' ')
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: (space)\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck01);
        System.out.print("Result: " + check_text01.mostFrequentStartingLetter() + "\n");
        if (check_text01.mostFrequentStartingLetter() == 'c')
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: c\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck03);
        System.out.print("Result: " + check_text07.mostFrequentStartingLetter() + "\n");
        if (check_text07.mostFrequentStartingLetter() == 't')
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: t\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck02);
        System.out.print("Result: " + check_text02.mostFrequentStartingLetter() + "\n");
        if (check_text02.mostFrequentStartingLetter() == 'x')
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected: x\nFailed. Check your solution.");
        }

        System.out.println();

        //Check howManyStarting
        System.out.println("Checking howManyStarting:");
        System.out.println("In: '' (an empty list)");
        System.out.println("How many words start with a?");
        System.out.print("Result: " + check_text03.howManyStarting('a') + "\n");
        if (check_text03.howManyStarting('a') == 0)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected:0\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck01);
        System.out.println("How many words start with a?");
        System.out.print("Result: " + check_text01.howManyStarting('a') + "\n");
        if (check_text01.howManyStarting('a') == 1)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected:1\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck01);
        System.out.println("How many words start with d?");
        System.out.print("Result: " + check_text01.howManyStarting('d') + "\n");
        if (check_text01.howManyStarting('d') == 2)
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Expected:2\nFailed. Check your solution.");
        }

        System.out.println();

        System.out.println("In: " + stringToCheck02);
        System.out.println("How many words start with each letter of the alphabet?");
        for (char ch01 : checkLetters.toCharArray())
        {
            System.out.println(ch01 + " : " + check_text02.howManyStarting(ch01));
        }

        System.out.println("There should be no zeros in the list above."
                + "\nThe letters a,b,d,f,n,t,z should show 2."
                + "\nThe letter x should show 3."
                + "\nIf this is not the case for you, check your solution. ");

        System.out.println();
    }//end of main
}//end of TextEx15 class