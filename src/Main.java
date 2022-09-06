
import java.io.*;
import java.util.*;

public class Main
{
    static String fileAddress = "F:\\FilesExample\\" ;
    public static void main(String[] args)
    {
        UserInteraction1 display = new UserInteraction1();
        display.displayDetailsApp();
        display.displayDetailsUserIntraction();
        while(true)
        {
            Main m = new Main();
            int input = m.optionsInputMain(display);
            if(input == 1)
            {
                m.option1();
            }
            if(input == 2)
            {
               m.option2(display);
            }
            if(input == 3)
            {
                m.option3();
            }
        }
    }

    int optionsInputMain(UserInteraction1 display)
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



    int optionsInputBusiness(UserInteraction1 display)
    {
        int i;
        while(true)
        {
            try
            {
                display.displayDetailsOption2();
                Scanner sc = new Scanner(System.in);
                i = sc.nextInt();
                if(i == 1 || i == 2 || i ==3 || i==4 || i==5)
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


    void option1()
    {
        File f =new File(fileAddress);
        File[] files = f.listFiles();
        if(files.length == 0)
        {
            System.out.println("No files Found in Directory\n");
        }
        else
        {
            int fileCounter = 0;
            int directoryCounter = 0;
            String[] Names = new String[files.length];
            for(int i =0 ; i<files.length;i++)
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
            List<String> l = Arrays.asList(Names);
            l.sort(String.CASE_INSENSITIVE_ORDER);
            System.out.println("\nThe root directory contains "+fileCounter+" files and "+directoryCounter+" directories\n");
            int i=1;
            for (String s : l) {
                System.out.println(i+". "+s);
                i++;
            }
            System.out.println(" ");

        }
    }

    void option2(UserInteraction1 display) {
        Main mainBusiness = new Main();
        while(true)
        {
            int a = mainBusiness.optionsInputBusiness(display);
            switch (a) {
                case 1 -> {
                    System.out.println("Enter file name to create new file :" );
                    Scanner sc = new Scanner(System.in);
                    String fileName = sc.nextLine();
                    String fileData="";
                    System.out.println("Enter data for the file : Press 'Y' and enter to add");
                    while(sc.hasNextLine())
                    {
                        String temp = sc.nextLine();
                        if(temp.trim().equals("y") || temp.trim().equals("Y"))
                        {
                            break;
                        }
                        fileData = fileData +" "+ temp;
                    }
                    try
                    {
                        File newFile = new File(fileAddress);
                        FileWriter writeFile = new FileWriter(fileAddress+fileName);
                        writeFile.write(fileData);
                        writeFile.close();
                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Your file has been added successfully\n");
                }
                case 2 -> {
                    System.out.println("Enter file name to search and display :");
                    Scanner sc = new Scanner(System.in);
                    String fileName = sc.nextLine();
                   File searchFile = new File(fileAddress+fileName);
                    try
                    {
                       Scanner obj = new Scanner(searchFile);
                       while(obj.hasNextLine())
                       {
                           String line = obj.nextLine();
                           System.out.println(line+"\n");
                       }
                       obj.close();
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println("File not found:\n");
                    }

                }

                case 3 -> {
                    System.out.println("Enter file name to delete:");
                    Scanner sc = new Scanner(System.in);
                    String filename = sc.nextLine();
                    File dltFile = new File(fileAddress+"\\"+filename);
                    boolean fileDelete = dltFile.delete();
                    if(fileDelete)
                    {
                        System.out.println("File deleted successfully\n");
                    }
                    else
                    {
                        System.out.println("File not found\n");
                    }
                }

                case 4 -> {
                    return;
                }

                case 5 -> {
                    mainBusiness.option3();
                }
            }
        }

    }


    void option3()
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
                        System.out.println(" ");
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
class MyExceptions extends Exception
{
    @Override
    public String toString() {
        return "Please enter a valid option";
    }
}

class UserInteraction1
{
    void displayDetailsApp()
    {
        System.out.println("Application Name    :   LOCKED_ME.COM ");
        System.out.println("Developed By        :   SUMIT PATIDAR ");
        System.out.println("E-mail ID           :   sumitpatidar1941@gmail.com");
        System.out.println("");
    }
    void displayDetailsUserIntraction()
    {
        System.out.println("Welcome to LOCKED_ME.COM");
        System.out.println("========================\n");
        System.out.println("This is a "+"Command Line Interface"+". Please read instructions carefully and select the appropriate option");
        System.out.println(" ");
    }
    void displayDetailsOptions()
    {
        System.out.println("PLEASE SELECT YOUR OPTION");
        System.out.println("1 - Display current file names in directory");
        System.out.println("2 - Business level operations");
        System.out.println("3 - Close Application");
        System.out.println(" ");
    }
    void displayDetailsOption2()
    {
        System.out.println("SELECT BUSINESS LEVEL OPERATIONS TO PERFORM ON CURRENT DIRECTORY\n");
        System.out.println("1 - Add file");
        System.out.println("2 - Search file");
        System.out.println("3 - Delete file");
        System.out.println("4 - Go Back to context menu");
        System.out.println("5 - Close Application");
    }

}


