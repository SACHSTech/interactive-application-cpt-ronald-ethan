import processing.core.PApplet;

/**
 * Template for programs with Processing graphics output.
 * @author Your Name
 */
public class Sketch extends PApplet {
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
        drawNotebook(175, 75, 450, 320);
        shapesUI();
        drawPen();
    }

    private void drawNotebook(int paperX, int paperY, int paperWidth, int paperHeight) {
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
        for (int i = 95; i < 75 + paperHeight; i += 25) {
            line(175, i, 175 + paperWidth, i);
        }

        // Red Line on the notebook paper
        stroke(255, 180, 180);
        line(210, 75, 210, 75 + paperHeight);
        line(210 + paperWidth / 2, 75, 210 + paperWidth / 2, 75 + paperHeight);
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
    
    private void shapesUI() {

        // Boxes
        strokeWeight(2);
        int distance = 125;
        for (int i = 0; i < 4; i++) {
            rect(170 + distance * i, 420, 80, 80, 10);
        }
        stroke(0); 
        fill(128, 128, 128);
        // Rectangle
        rect(180, 440, 60, 40);
        
        // Square
        square(185 + distance, 435, 50);

        // Circle
        circle(210 + 2 * distance, 460, 55);

        // Triangle
        triangle(585, 435, 620, 485, 550, 485);
    }
    
   

    /** Additional helper methods below */

    
}