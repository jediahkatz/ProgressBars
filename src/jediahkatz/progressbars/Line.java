package jediahkatz.progressbars;
import processing.core.*;
import garciadelcastillo.dashedlines.*;

public class Line {
	private PApplet p;
	private DashedLines d;
	private float x1, y1, x2, y2, dist;
	private float strokeWeight, trailWeight;
	private int strokeColor, trailColor;
	private int easingFunction = 0;
	private float offset = 0;
	private float start = -1;
	private int startTime;
	
	/**
	 * 
	 * @param parent The parent PApplet - in Processing, it will take the argument "this".
	 * @param x1 The x-coordinate of the starting point of the line.
	 * @param y1 The y-coordinate of the starting point of the line.
	 * @param x2 The x-coordinate of the endpoint of the line.
	 * @param y2 The y-coordinate of the endpoint of the line.
	 */
	public Line(PApplet parent, float x1, float y1, float x2, float y2) {
		p = parent;
		d = new DashedLines(p);
		
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		
		dist = PApplet.dist(x1, y1, x2, y2);
		d.pattern(dist, dist);
		d.offset(dist);
		
		strokeWeight = trailWeight = 1;
		strokeColor = trailColor = 0;
	}
	
	public void draw() {
		p.pushStyle();
		
		p.stroke(trailColor);
		p.strokeWeight(trailWeight);
		p.line(x1, y1, x2, y2);
		
		p.stroke(strokeColor);
		p.strokeWeight(strokeWeight);
		d.line(x1, y1, x2, y2);
		
		p.popStyle();
	}
	
	/**
	 * Sets the progress bar to a certain point.
	 * @param fraction A decimal coefficient between 0 and 1.
	 */
	public void set(float fraction) {
		offset = (fraction >= 1 ? 1 : fraction) * dist;
	}
	
	/**
	 * Call this to begin and continue the progress bar animation until it has completed.
	 * @param start The start point, as a decimal coefficient between 0 and 1.
	 * @param end The endpoint, as a decimal coefficient between 0 and 1.
	 * @param duration The duration of the animation in milliseconds.
	 */
	public void animate(float start, float end, int duration) {
		int t = p.millis();
		
		if (this.start == -1) {
			this.start = start;
			offset = start * dist;
			startTime = t;
		}
		
		if (t - startTime >= duration) {
			offset = end * dist;
		} else {
			offset = EasingFunctions.applyFunction(easingFunction, 
					(float) t - startTime, this.start*dist, (end-this.start)*dist,
					duration);
		}
		d.offset(dist + offset);
	}
	
	/**
	 * Reset the animation. This must be called every time you want to re-animate a progress bar.
	 */
	public void reset() {
		start = -1;
	}
	
	/**
	 * Sets the weight of the progress bar.
	 * @param weight The weight in pixels.
	 */
	public void strokeWeight(float weight) {
		strokeWeight = weight;
	}
	
	/**
	 * Sets the color of the progress bar.
	 * @param color The color, as a "color" datatype.
	 */
	public void strokeColor(int color) {
		strokeColor = color;
	}
	
	/**
	 * Sets the weight of the trail.
	 * @param weight The weight in pixels.
	 */
	public void trailWeight(float weight) {
		trailWeight = weight;
	}
	
	/**
	 * Sets the color of the progress bar.
	 * @param color The color, as a "color" datatype.
	 */
	public void trailColor(int color) {
		trailColor = color;
	}
	
	/**
	 * Set the easing function to use for the animation.
	 * @param function An easing function such as EasingFunctions.LINEAR.
	 */
	public void setEasingFunction(int function) {
		easingFunction = function;
	}
	
}