import jediahkatz.progressbars.*;

Line l, l2, l3;

void setup() {
  size(400, 200);
  noSmooth();
  strokeCap(SQUARE);
  frameRate(500);

  l = new Line(this, 50, 50, 350, 50);
  l.strokeColor(#ffc30f);
  l.strokeWeight(12);
  l.trailColor(#eeeeee);
  l.trailWeight(3);
  l.setEasingFunction(EasingFunctions.QUAD_EASE_IN_OUT);

  l2 = new Line(this, 50, 100, 350, 100);
  l2.strokeColor(#c70039);
  l2.strokeWeight(12);
  l2.trailColor(#eeeeee);
  l2.trailWeight(3);
  l2.setEasingFunction(EasingFunctions.QUAD_EASE_IN_OUT);

  l3 = new Line(this, 50, 150, 350, 150);
  l3.strokeColor(#581845);
  l3.strokeWeight(12);
  l3.trailColor(#eeeeee);
  l3.trailWeight(3);
  l3.setEasingFunction(EasingFunctions.QUAD_EASE_IN_OUT);
}

void draw() {
  background(#ffffff);
  l.draw();
  l2.draw();
  l3.draw();
  if (millis() > 1000) {
    l.animate(0, 0.5, 2000);
    l2.animate(0, 0.75, 2000);
    l3.animate(0, 1, 2000);
  }
}