import processing.core.PApplet;

/**
 * Template for programs with Processing graphics output.
 * @author Your Name
 */

public class Sketch extends PApplet {
    // Tracks what shape is currently selected
    String selectedShape = "none"; 
    // Stores all the x and y values of the drawn shapes
    int[] shapeX = new int[0];
    int[] shapeY = new int[0];
    // Stores the shape type being selected and drawn
    String[] shapeType = new String[0];
    // Counts the current number of shapes
    int shapeCount = 0;
    // UI Variables
    int UIWidth = 80;
    int distBTWBoxes = 45;
    int UIdistance = UIWidth + distBTWBoxes;

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

    @Override
    public void settings() {
        size(800, 600); 
        
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw() {
        background(255);
        drawNotebook(175, 75, 450, 320, 35);
        drawPlacedShapes(); 
        shapesUI(170, 420);
        drawPen();
    }
    /** 
     * Checks what UI is being selected based on mouse coordinates
     */
    public void mousePressed() {
    // Distance between X value of the 
        int distance = UIWidth + distBTWBoxes;
        
        // Checks which shape is being selected in the UI section
        if (mouseY >= 420 && mouseY <= 500) {
            // Selection for rectangle
            if (mouseX >= 170 && mouseX <= 250) {
                selectedShape = "rectangle";
            // Selection for square
            } else if (mouseX >= 170 + distance && mouseX <= 250 + distance) {
                selectedShape = "square";
            // Selection for circle
            } else if (mouseX >= 170 + distance * 2 && mouseX <= 250 + distance * 2) {
                selectedShape = "circle";
            // Selection for triangle
            } else if (mouseX >= 170 + distance * 3 && mouseX <= 250 + distance * 3) {
                selectedShape = "triangle";
            }
        }   
        // Prints out the shape when mouse is pressed on the notebook area and if a shape has been selected
        else if (mouseX >= 175 && mouseX <= 625 && mouseY >= 75 && mouseY <= 395) {
            // If a shape is selected the shape array size will increase by 1
            if (!selectedShape.equals("none")) {
                growArraySize();
                // Store the mouse coordinates and shape type at the current shape count index 
                shapeX[shapeCount] = mouseX;
                shapeY[shapeCount] = mouseY;
                shapeType[shapeCount] = selectedShape;
                // Adds to the number of shapes on the notebook for index value of array
                shapeCount++;          
                
            }
        }
    }


    private void growArraySize() {
        // Calculates the new array size by adding 1 to the old array size
        int newArraySize = shapeX.length + 1;
        // Creates a new array to store the new array values and size
        int[] newShapeX = new int[newArraySize];
        int[] newShapeY = new int[newArraySize];
        String[] newShapeType = new String[newArraySize];
        // Inputs all the old values into the new array
        for (int i = 0; i < shapeCount; i++) {
            newShapeX[i] = shapeX[i];
            newShapeY[i] = shapeY[i];
            newShapeType[i] = shapeType[i];
        }
        // Updates the old array with the new ones
        shapeX = newShapeX;
        shapeY = newShapeY;
        shapeType = newShapeType;
    } 

    // Drawing the actual shapes
    private void drawPlacedShapes() {
        fill(128, 128, 128); 
        stroke(0);
        strokeWeight(1);
        // Loops through all stored values to draw after background() erases all previous
        for (int i = 0; i < shapeCount; i++) {
            if (shapeType[i].equals("rectangle")) {
                rect(shapeX[i] - 30, shapeY[i] - 20, 60, 40); 
            } else if (shapeType[i].equals("square")) {
                rect(shapeX[i] - 25, shapeY[i] - 25, 50, 50);
            } else if (shapeType[i].equals("circle")) {
                circle(shapeX[i], shapeY[i], 55);
            } else if (shapeType[i].equals("triangle")) {
                triangle(shapeX[i], shapeY[i] - 25, shapeX[i] + 25, shapeY[i] + 25, shapeX[i] - 25, shapeY[i] + 25);
            }
        }
    }

    private void drawNotebook(int paperX, int paperY, int paperWidth, int paperHeight, int redLineIndent) {
        // Brown notebook cover
        fill(150, 75, 0);
        noStroke();
        // The roundness of the notebook is 10
        rect(170, 70, 460, 330, 10);

        // Notebook paper
        fill(255);
        rect(paperX, paperY, paperWidth, paperHeight);

        // Blue Lines on the notebook paper
        stroke(200, 220, 255); 
        strokeWeight(1);
        // A loop to change the y value of the lines until the end of the paper with increment of 25
        for (int i = 95; i < paperY + paperHeight; i += 25) {
            line(paperX, i, paperX + paperWidth, i);
        }

        // Red Line on the notebook paper
        stroke(255, 180, 180);
        line(paperX + redLineIndent, paperY, paperX + redLineIndent, paperY + paperHeight);
        line(paperX + redLineIndent + paperWidth / 2, paperY, paperX + redLineIndent + paperWidth / 2, paperY + paperHeight);
        // Notebook spine
        stroke(100, 50, 0);
        strokeWeight(3);
        line(paperX + (paperWidth / 2), paperY, paperX + (paperWidth / 2), paperY + paperHeight);

        // Reset the stroke weight 
        strokeWeight(0);

    }

    private void drawPen() {
        // Pen tip
        strokeWeight(8);
        stroke(156, 153, 152);
        line(mouseX, mouseY, mouseX + 80, mouseY - 120);
        // Pen body
        strokeWeight(15);
        stroke(0);
        line(mouseX + 7, mouseY - 10, mouseX + 80, mouseY - 120);
        // Pen clip
        stroke(3);
        line(mouseX + 54, mouseY - 90, mouseX + 70, mouseY - 120);
        strokeWeight(0);
    }
    
    private void shapesUI(int firstUI_X, int UI_Y) {
        // Boxes
        strokeWeight(2);
        for (int i = 0; i < 4; i++) {
            rect(firstUI_X + UIdistance * i, UI_Y, UIWidth, UIWidth, 10);
        }
        stroke(0); 
        fill(128, 128, 128);
        // Rectangle
        rect(180, 440, 60, 40);
        
        // Square
        square(185 + UIdistance, 435, 50);

        // Circle
        circle(210 + 2 * UIdistance, 460, 55);

        // Triangle
        triangle(585, 435, 620, 485, 550, 485);
        noFill();
    }
    
    
    /** Additional helper methods below */

    
}