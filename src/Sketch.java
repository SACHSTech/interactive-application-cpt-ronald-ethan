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
        size(600, 400); 
        
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw() {
        background(255);
        drawNotebook();
        drawPen();
    }

    private void drawNotebook() {
        fill(150, 75, 0); // Brown notebook cover
        rect(60, 40, 450, 320);
        fill(255); // White paper 
        rect(82, 50, 200, 300);
        rect(288, 50, 200, 300);

    }

    private void drawPen() {
        strokeWeight(10);
        line(mouseX, mouseY, mouseX + 80, mouseY - 120);
        strokeWeight(0);
    }

    /** Additional helper methods below */

}
