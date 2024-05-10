// imports
import processing.core.PApplet;

/**
 * Description: processing with inputs
 * @author EdricLai
*/
public class Sketch extends PApplet {
  /*
   * global variables
   * called once
   */
  boolean boolUp;
  boolean boolDown;
  boolean boolRight;
  boolean boolLeft;
  float fltScale;
  float fltSpeed;
  float fltPosX;
  float fltPosY;
  float fltDiameter;
  float fltStrokeWeight;

  /**
   * settings function
   * called once
   */
  public void settings() {
    size(1000, 700);
  }

  /** 
   * setup function
   * called once
   */
  public void setup() {
    // general
    background(0, 0, 0);

    // initialize variables
    fltPosX = width / 2;
    fltPosY = height / 2;
    fltScale = width * height;
    fltSpeed = fltScale / 40000;
    fltDiameter = fltScale / 20000;
    fltStrokeWeight = fltScale / 200000;
  }

  /**
   * draw function
   * called repeatedly
   */
  public void draw() {
    disintegrate();
    noStroke();
    blueAsteroid();
    redAsteroid();
  }

  /**
   * disintegration effect
   * called on command
   */
  private void disintegrate() {
    // customizes lines
    stroke(0, 0, 0);
    strokeWeight(fltStrokeWeight);

    // erases visuals with random lines
    for (int i = 0; i <= 30; i++) {
      line(random(width), random(height), random(width), random(height));
    }
  }

  /**
   * blue asteroid code
   * called on command
   */
  private void blueAsteroid() {
    // called on mouse hold
    if (mousePressed) {
      // blue asteroid visual
      fill(0, 255, 255);
      ellipse(mouseX, mouseY, fltDiameter, fltDiameter);
    }
  }

  /**
   * mouse released function
   * called on mouse release
   */
  public void mouseReleased() {
    // blue explosion visual
    fill(0, 100, 255);
    ellipse(mouseX, mouseY, fltDiameter * 5, fltDiameter * 5);
  }

  /**
   * red asteroid code
   * called on command
  */
  private void redAsteroid() {
    // called on keyboard hold
    if (keyPressed) {
      // red asteroid visual
      fill(255, 0, 0);
      ellipse(fltPosX, fltPosY, fltDiameter, fltDiameter);    
    }

    // movement
    if (boolUp) {
      fltPosY -= fltSpeed;
    }
    if (boolDown) {
      fltPosY += fltSpeed;
    }
    if (boolRight) {
      fltPosX += fltSpeed;
    }
    if (boolLeft) {
      fltPosX -= fltSpeed;
    }
  }

  /**
   * keyboard pressed function
   * called on keyboard pressed 
  */
  public void keyPressed() {
    // wasd key pressed
    if (key == 'w' || keyCode == UP) {
      boolUp = true;
    }
    else if (key == 's' || keyCode == DOWN) {
      boolDown = true;
    }
    else if (key == 'd' || keyCode == RIGHT) {
      boolRight = true;
    }
    else if (key == 'a' || keyCode == LEFT) {
      boolLeft = true;
    }
  }
  
  /**
   * keyboard released function
   * called on keyboard release
  */
  public void keyReleased() {
    // wasd key released
    if (key == 'w' || keyCode == UP) {
      boolUp = false;
    }
    else if (key == 's' || keyCode == DOWN) {
      boolDown = false;
    }
    else if (key == 'd' || keyCode == RIGHT) {
      boolRight = false;
    }
    else if (key == 'a' || keyCode == LEFT) {
      boolLeft = false;
    }

    // red explosion visual
    fill(255, 100, 0);
    ellipse(fltPosX, fltPosY, fltDiameter * 3, fltDiameter * 3);
  }
}