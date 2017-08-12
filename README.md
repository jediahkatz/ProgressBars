# ProgressBars for Processing

![ProgressBars for Processing](https://github.com/jediahkatz/ProgressBars-for-Processing/blob/master/assets/progressbars.gif "ProgressBar for Processing") 

### Installation
Download the entire project as a zip file by clicking `Clone or Download > Download ZIP` on GitHub. Go to your Processing libraries folder (by default it's at `C:\Users\YourName\Documents\Processing\libraries`) and extract the zip file you just downloaded into a folder called `ProgressBars`. Finally, you should be able to access the library from your Processing IDE by clicking `Sketch > Import Library > ProgressBars`.

### Tutorial

```java
// Import the library
import jediahkatz.progressbars.*;

// Declare a Line object
Line myLine;

void setup() {
  // Recommended changes to make your sketch look sharp
  noSmooth();
  strokeCap(SQUARE);
  
  // Initialize the Line with endpoints at (10, 50) and (90, 50)
  myLine = new Line(this, 10, 50, 90, 50);
  
  // Set the thickness of the trail and the line
  myLine.trailWeight(2);
  myLine.strokeWeight(10);
  
  // Set the colors of the trail and the line
  myLine.trailColor(#eeeeee);
  myLine.strokeColor(#c70039);
  
  // Set the easing function
  myLine.setEasingFunction(EasingFunctions.QUAD_EASE_IN_OUT);
}

void draw() {
  // Draw the Line and animate it from 0% to 100% over 1500 milliseconds (1.5s)
  myLine.draw();
  myLine.animate(0, 1, 1500);
}
```

### What's next
* Support for more default shapes and even custom PShapes
* Bug fixes for the bounce easing functions

### Contribute

This library is still under construction - I'd really appreciate any bug reports or feature requests you've got. Also, feel free to fork this library and contribute yourself!

### Acknowledgements
Huge thanks to [Robert Penner](https://github.com/robertpenner) for his easing functions and to [Jose Luis Garcia Del Castillo](https://github.com/garciadelcastillo), without whose `dashed-lines-for-processing` library this one could not exist!