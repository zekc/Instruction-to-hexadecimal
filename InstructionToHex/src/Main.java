import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileHandler file=new FileHandler();

        InstructionAssembler instructionAssembler = new InstructionAssembler();
        BinaryToHex binaryToHex =  new BinaryToHex();

        instructionAssembler.instructionToBinary(file.getListOfInstList());
        ArrayList<String> binaryInstructions = instructionAssembler.getBinaryInstructions();
        FileHandler fileHandler = new FileHandler();
        fileHandler.writeInstlist(binaryToHex.convertToHex(binaryInstructions));
    }
}