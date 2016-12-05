package main.java;

public class Display
{
    public void mainMenu()
    {
        System.out.println("Type 'E' to modify employee data");
        System.out.println("Type 'D' to modify department data");
        System.out.println("Type 'Q' to quit");
    }

    public void menu(String objName)
    {
        System.out.println("Type 1 to add new " + objName);
        System.out.println("Type 2 to modify " + objName);
        System.out.println("Type 3 to delete " + objName);
        System.out.println("Type 4 to see all " + objName + "s");
        System.out.println("Type 5 to save changes");
        System.out.println("Type 6 to upload data");
        System.out.println("Type 7 to back to main menu");
    }

    public void error()
    {
        System.out.println("Wrong input");
    }

    public void out(String s)
    {
        System.out.println(s);
    }

    public void delete(String objName)
    {
        System.out.println("Choose " + objName + " you want to delete");
    }

    public void modify(String objName)
    {
        System.out.println("Choose " + objName + " you want to modify");
    }
}
