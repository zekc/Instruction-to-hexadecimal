import java.util.ArrayList;

public class InstructionAssembler {

    //    FileHandler fileHandler =new FileHandler();
    private String instruction;

    public ArrayList<String> getBinaryInstructions() {
        return binaryInstructions;
    }

    private ArrayList<String> binaryInstructions;

    public InstructionAssembler() {
        binaryInstructions = new ArrayList<>();
    }

    public void instructionToBinary(ArrayList<ArrayList<String>> listOfInstructions) {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<String> instruction : listOfInstructions) {
            for (String parameter : instruction) {
                sb.append(parameterToBinary(parameter));
            }

            if (isInstructionStOrLd(sb.toString())) {
                String temp = sb.substring(9);
                temp = String.format("%011d", Integer.parseInt(temp));
                sb.replace(9, sb.length(), temp);
            } else if (isInstructionPushOrPop(sb.toString())) {
                sb.insert(8, "00000000000");
            } else if (isInstructionJump(sb.toString())) {
                String temp = sb.substring(5);
                temp = String.format("%015d", Integer.parseInt(temp));
                sb.replace(5, sb.length(), temp);
            } else if (!isInstructionImmediate(sb.toString())) {
                sb.insert(12, "000");
            }

            if (sb.length() != 20)
                System.out.println("Instruction length is not 20");
            binaryInstructions.add(sb.toString());
            sb.setLength(0);
        }
    }

    private boolean isInstructionImmediate(String instruction) {
        return String.valueOf(instruction.charAt(4)).equals("1");
    }

    private boolean isInstructionPushOrPop(String instruction) {
        return instruction.startsWith("10000") || instruction.startsWith("10010");
    }

    private boolean isInstructionStOrLd(String instruction) {
        return instruction.startsWith("01010") || instruction.startsWith("01100");
    }

    private boolean isInstructionJump(String instruction) {
        return instruction.startsWith("01110");
    }


    public String parameterToBinary(String parameter) {
        switch (parameter) {
            case "R0":
                return "0000";
            case "R1":
                return "0001";
            case "R2":
                return "0010";
            case "R3":
                return "0011";
            case "R4":
                return "0100";
            case "R5":
                return "0101";
            case "R6":
                return "0110";
            case "R7":
                return "0111";
            case "R8":
                return "1000";
            case "R9":
                return "1001";
            case "R10":
                return "1010";
            case "R11":
                return "1011";
            case "R12":
                return "1100";
            case "R13":
                return "1101";
            case "R14":
                return "1110";
            case "R15":
                return "1111";

            case "ADD":
                return "00000";
            case "ADDI":
                return "00001";
            case "SUB":
                return "00010";
            case "SUBI":
                return "00011";
            case "AND":
                return "00100";
            case "ANDI":
                return "00101";
            case "OR":
                return "00110";
            case "ORI":
                return "00111";
            case "XOR":
                return "01000";
            case "XORI":
                return "01001";
            case "LD":
                return "01010";
            case "ST":
                return "01100";
            case "JUMP":
                return "01110";
            case "PUSH":
                return "10000";
            case "POP":
                return "10010";
            case "BE":
                return "10100";
            case "BNE":
                return "10110";
            case "12":
                return "0001100";
            case "13":
                return "0001101";
            case "14":
                return "0001110";
            case "15":
                return "0001111";
            default:
                System.out.println("Unexpected instruction");

        }
        return "";
    }
}
