import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    private ArrayList<String> instList = new ArrayList<String>();
    private ArrayList<String> modInstList = new ArrayList<String>();
    public ArrayList<ArrayList<String>> listOfinstList = new ArrayList<ArrayList<String>>();

    public void writeInstlist(ArrayList<String> instList){
        try {
            PrintWriter myWriter = new PrintWriter("src\\hexedecimal.txt", "UTF-8");
            myWriter.println("v2.0 raw");
            for (int i = 0; i < instList.size(); i++) {
                myWriter.println(instList.get(i));
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public FileHandler() {

        // read the input file and write it to an arraylist
        try {
            File myObj = new File("src\\instructions.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                getInstList().add(myReader.nextLine());
                i = i + 1;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        for (int i = 0; i < getInstList().size(); i++) {
            getModInstList().add(getInstList().get(i).replace(",", " "));
        }
        instSplitter(getModInstList());
    }

    // split all the elements
    public void instSplitter(ArrayList<String> modInstList) {

        String[] tempLine;

        for (String modInst : modInstList) {
            tempLine = modInst.split(" ");
            ArrayList<String> tempList = new ArrayList<>(Arrays.asList(tempLine));
            listOfinstList.add(tempList);
        }
    }


    public ArrayList<String> getInstList() {
        return instList;
    }

    public ArrayList<String> getModInstList() {
        return modInstList;
    }

    public ArrayList<ArrayList<String>> getListOfInstList() {
        return listOfinstList;
    }
}