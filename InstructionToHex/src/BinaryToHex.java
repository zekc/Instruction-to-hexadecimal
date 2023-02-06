import java.util.ArrayList;

public class BinaryToHex {
    private ArrayList<String> instructionsToHex =new ArrayList<>();
    public ArrayList<String> convertToHex(ArrayList<String> binaryValue){
        StringBuilder sb = new StringBuilder();

        for (String s : binaryValue) {

            sb.append(convertToDecimal(s.substring(0, 4)));
            sb.append(convertToDecimal(s.substring(4, 8)));
            sb.append(convertToDecimal(s.substring(8, 12)));
            sb.append(convertToDecimal(s.substring(12, 16)));
            sb.append(convertToDecimal(s.substring(16, 20)));

            sb= new StringBuilder("");
        }
        return getInstructionsToHex();
    }
    public String convertToDecimal (String binary){

        switch (binary){
            case "0000":
                return "0";
            case "0001":
                return "1";
            case "0010":
                return "2";
            case "0011":
                return "3";
            case "0100":
                return "4";
            case "0101":
                return "5";
            case "0110":
                return "6";
            case "0111":
                return "7";
            case "1000":
                return "8";
            case "1001":
                return "9";
            case "1010":
                return "A";
            case "1011":
                return "B";
            case "1100":
                return "C";
            case "1101":
                return "D";
            case "1110":
                return "E";
            case "1111":
                return "F";
            default:
                System.out.println("Unexpected instruction");
        }
        return "";
    }

    public ArrayList<String> getInstructionsToHex() {
        return instructionsToHex;
    }

    public void setInstructionsToHex(ArrayList<String> instructionsToHex) {
        this.instructionsToHex = instructionsToHex;
    }
}
