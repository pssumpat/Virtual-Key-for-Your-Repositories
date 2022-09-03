import java.io.File;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//    1. Code to display the welcome screen. It should display:
//    Application name and the developer details
//    The details of the user interface such as options displaying the user interaction information
//        Features to accept the user input to select one of the options listed
//
//    2.The first option should return the current file names in ascending order. The root directory can
//    be either empty or contain few files or folders in it
//
//    3. There should be a third option to close the application
public class Main
{
    public static void main(String[] args)
    {
        UserInteraction1 display = new UserInteraction1();
        display.displayDetailsApp();
        display.displayDetailsUserIntraction();
        while(true)
        {
            Main m = new Main();
            int input = m.optionsInput(display);
            if(input == 1)
            {
                m.option1(m,display);
            }
            if(input == 2)
            {

            }
            if(input == 3)
            {
                m.option3(m,display);
            }
        }
    }

    int optionsInput(UserInteraction1 display)
    {
        int i;
        while(true)
        {
            try
            {
                display.displayDetailsOptions();
                Scanner sc = new Scanner(System.in);
                i = sc.nextInt();
                if(i == 1 || i == 2 || i ==3)
                {
                    break;
                }
                else
                {
                    throw new MyExceptions();
                }
            }
            catch (InputMismatchException a)
            {
                System.out.println("Please Enter a valid input\n");
            }
            catch(MyExceptions a)
            {
                System.out.println(a+"\n");
            }
        }
        return i;
    }


    void option1(Main m, UserInteraction1 display)
    {
        File f =new File("F:\\Virtual_Key_For_Your_Repositories");
        File[] files = f.listFiles();
        if(files.length == 0)
        {
            System.out.println("No files Found in Directory");
        }
        else
        {
            int fileCounter = 0;
            int directoryCounter = 0;
            String[] Names = new String[files.length];
            for(int i =1 ; i<files.length;i++)
            {
                if(files[i].isFile())
                {
                    fileCounter++;
                    Names[i] = files[i].getName();
                }
                else if (files[i].isDirectory())
                {
                    directoryCounter++;
                    Names[i] =files[i].getName();
                }
            }
            System.out.println(Arrays.toString(Names));
            System.out.println("\nThe root directory contains "+fileCounter+" files and "+directoryCounter+" directories\n");
        }
    }

    void option3(Main m, UserInteraction1 display)
    {
        while(true)
        {
            try
            {
                System.out.println("Are you sure :\nSelect Y for yes\nSelect N for no");
                Scanner sc = new Scanner(System.in);
                char conf = sc.next().trim().charAt(0);
                if(conf == 'y' || conf == 'Y' || conf == 'n' || conf == 'N')
                {
                    if(conf == 'y' || conf == 'Y')
                    {
                        System.out.println("Thanks for using the application...\nComeback soon..");
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("\n");
                        return;
                    }
                }
                else
                {
                    throw new MyExceptions();
                }
            }
            catch (MyExceptions a)
            {
                System.out.println(a);
            }
        }
    }
}
