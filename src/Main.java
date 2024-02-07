import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String option;
        boolean sent = true;
        ArrayList <String> list = new ArrayList <>(10);
        do {
            option = InputHelper.getRegExString(scan, "\nSelect an option:\nA - Add\nD - Delete\nP - Print\nQ - Quit\n"
                    , "[AaDdPpQq]");
            if (option.equalsIgnoreCase("A"))
                Add(scan, list);
            else if (option.equalsIgnoreCase("D"))
                Delete(scan, list);
            else if (option.equalsIgnoreCase("P"))
                Print(list);
            else
                if(Quit(scan))
                    sent = false;
        } while(sent);
    }
    public static void Add(Scanner scan, ArrayList<String> list){
        String add = InputHelper.getNonZeroLenString(scan, "What would you like to add to your list?");
        list.add(add);
    }
    public static void Delete(Scanner scan, ArrayList<String> list){
        int index = InputHelper.getRangedInt(scan, "Which index do you want to remove?", 0, list.size());
        list.remove(index);
    }
    public static void Print(ArrayList<String> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(i + "- " + list.get(i));
        }
    }
    public static boolean Quit(Scanner scan){
        return InputHelper.getYNConfirm(scan, "Are you sure you want to quit? [Y/N]");
    }
}