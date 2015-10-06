
package projecttwo;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ben Reining
 */
public class ProjectTwo {

    private int[][] original;
    private int[][] blurred;
    private int row;
    private int col;

    public ProjectTwo(int[][] original) {
        this.original = original;
        row = original.length;
        col = original[0].length;
        blurred = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                blurred[i][j] = original[i][j];
            }
        }
    }

    
    private int averageNeighbors(int rowIndex, int colIndex) {
        int average = 0;
        int sum = 0;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                sum = sum + original[rowIndex + i][colIndex + j];
                
            }
        }
         average = sum / 9;
        return average;
    }

    private void blurImage() {
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                blurred[i][j] = (int) averageNeighbors(i, j);
            }
        }
    }
    private void copyImage(){ //copying the results back into the original
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                blurred[i][j] = original[i][j];
            }
        }
    }
    
    private int[][] darkenImage(int param){
        for (int i = 0; i<original.length; i ++)
            for (int j =0; j < original[i].length; j ++){
                blurred[i][j]= original[i+param][j+param];
            }
        return blurred;
    }
    private int[][] lightenImage(int param){
        for (int i = 0; i<original.length; i ++)
            for (int j =0; j < original[i].length; j ++){
                blurred[i][j]= original[i-param][j-param];
            }
        return blurred;
    }
    
    private void invertImage(){
        for (int i = 0; i<original.length; i ++)
            for (int j =0; j < original[i].length; j ++){
                blurred[i][j]= original[255-i][255-j];
            }
    }
    
    private void flipImage(){
        for (int i = 0; i<original.length; i ++)
            for (int j =0; j < original[i].length; j ++){
                blurred[i][j]= original[j][i];
            }
    }
    private void thresholdImage (int param){
        for (int i = 0; i<original.length; i ++)
            for (int j =0; j < original[i].length; j ++){
                if (original[i][j]<param)
                    blurred[i][j] = 0;
                else blurred[i][j] = 255;
            }
    }

    
    
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * First step is to read in image data from an external file.
         * This is what I need the most help with.
         * What does he mean by: The input and output names are to be taken from the command line.
         */
        if (args.length < 2) {
            System.out.println("Usage: java TestFiles <infilename> <outfilename>");
            System.exit(0);
        }
        
        int row = 0;
        int col = 0;
        File inFile = new File(args[0]);        
        Scanner reader = null;
        int [][] picture = null;
        try {
            reader = new Scanner(inFile);
            
        while(inFile.hasNextLine()){
            row++;
            inFile.next();
        }
        while(inFile.hasNextInt()){
            col++;
            inFile.next();
        }
        picture = new int [row][col];
        
        for (int i = 0; i < picture.length; i++){
            for (int j = 0; j < picture[i].length; j++)
            picture[i][j] = inFile.nextInt();
        }
        
            
        }
        catch(FileNotFoundException e) {
            System.out.println("Input file " + args[0] + " does not exist.");
            System.exit(0);
        }
        ProjectTwo image = new ProjectTwo(picture);
        
        //End reading in.
        
        //Executing Methods and Copying Results into original
        image.blurImage();
        image.copyImage();
        
        image.darkenImage(5);
        image.copyImage();
        
        image.lightenImage(7);
        image.copyImage();
        
        image.invertImage();
        image.copyImage();
        
        image.flipImage();
        image.copyImage();
        
        image.thresholdImage(150);
        image.copyImage();
        
        
        // Write the result to an output file.
        PrintWriter output = null;
        try {
            output = new PrintWriter(args[1]);
        }
        catch(FileNotFoundException e) {
            System.out.println("Unknown error opening " + args[1]);
            System.exit(0);
        }
        double total = 0.0;
        double value = 0.0;
        while (reader.hasNextInt()) {
            value = reader.nextInt();
            output.printf("%15.2f\n", value);
            total = total + value;
        }
        output.printf("Total: %8.2f\n", total);
        
        reader.close();
        output.close();
        
        
        
        
    }
    
}
