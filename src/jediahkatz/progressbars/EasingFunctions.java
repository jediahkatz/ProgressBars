package jediahkatz.progressbars;

/**
 * A class containing the Penner easing functions.
 * Each function takes the same four parameters.
 * 
 * t: the current elapsed time,
 * b: the starting point,
 * c: the desired change (i.e., the difference between ending and starting points),
 * d: the duration in milliseconds
 */
public abstract class EasingFunctions {
	public final static int LINEAR = 0;
	public final static int QUAD_EASE_IN = 1;
	public final static int QUAD_EASE_OUT = 2;
	public final static int QUAD_EASE_IN_OUT = 3;
	public final static int CUBIC_EASE_IN = 4;
	public final static int CUBIC_EASE_OUT = 5;
	public final static int CUBIC_EASE_IN_OUT = 6;
	public final static int QUART_EASE_IN = 7;
	public final static int QUART_EASE_OUT = 8;
	public final static int QUART_EASE_IN_OUT = 9;
	public final static int QUINT_EASE_IN = 10;
	public final static int QUINT_EASE_OUT = 11;
	public final static int QUINT_EASE_IN_OUT = 12;
	public final static int SINE_EASE_IN = 13;
	public final static int SINE_EASE_OUT = 14;
	public final static int SINE_EASE_IN_OUT = 15;
	public final static int EXP_EASE_IN = 16;
	public final static int EXP_EASE_OUT = 17;
	public final static int EXP_EASE_IN_OUT = 18;
	public final static int CIRC_EASE_IN = 19;
	public final static int CIRC_EASE_OUT = 20;
	public final static int CIRC_EASE_IN_OUT = 21;
	public final static int BOUNCE_EASE_IN = 22;
	public final static int BOUNCE_EASE_OUT = 23;
	public final static int BOUNCE_EASE_IN_OUT = 24;

	
	protected static float applyFunction(int function, float t, float b, float c, float d) {
		switch(function) {
		case LINEAR:
			return linear(t, b, c, d);
		case QUAD_EASE_IN:
			return quadEaseIn(t, b, c, d);
		case QUAD_EASE_OUT:
			return quadEaseOut(t, b, c, d);
		case QUAD_EASE_IN_OUT:
			return quadEaseInOut(t, b, c, d);
		case CUBIC_EASE_IN:
			return cubicEaseIn(t, b, c, d);
		case CUBIC_EASE_OUT:
			return cubicEaseOut(t, b, c, d);
		case CUBIC_EASE_IN_OUT:
			return cubicEaseInOut(t, b, c, d);
		case QUART_EASE_IN:
			return quartEaseIn(t, b, c, d);
		case QUART_EASE_OUT:
			return quartEaseOut(t, b, c, d);
		case QUART_EASE_IN_OUT:
			return quartEaseInOut(t, b, c, d);
		case QUINT_EASE_IN:
			return quintEaseIn(t, b, c, d);
		case QUINT_EASE_OUT:
			return quintEaseOut(t, b, c, d);
		case QUINT_EASE_IN_OUT:
			return quintEaseInOut(t, b, c, d);
		case SINE_EASE_IN:
			return sineEaseIn(t, b, c, d);
		case SINE_EASE_OUT:
			return sineEaseOut(t, b, c, d);
		case SINE_EASE_IN_OUT:
			return sineEaseInOut(t, b, c, d);
		case EXP_EASE_IN:
			return expEaseIn(t, b, c, d);
		case EXP_EASE_OUT:
			return expEaseOut(t, b, c, d);
		case EXP_EASE_IN_OUT:
			return expEaseInOut(t, b, c, d);
		case CIRC_EASE_IN:
			return circEaseIn(t, b, c, d);
		case CIRC_EASE_OUT:
			return circEaseOut(t, b, c, d);
		case CIRC_EASE_IN_OUT:
			return circEaseInOut(t, b, c, d);
		case BOUNCE_EASE_IN:
			return bounceEaseIn(t, b, c, d);
		case BOUNCE_EASE_OUT:
			return quadEaseOut(t, b, c, d);
		case BOUNCE_EASE_IN_OUT:
			return bounceEaseInOut(t, b, c, d);
		default:
			return 0;
		}
	}
	
	//Thanks to Robert Penner for the easing functions!
	private static float linear(float t, float b, float c, float d) {
		return c*t/d + b;
	}
	
	private static float quadEaseIn(float t,float b , float c, float d) {
		return c*(t/=d)*t + b;
	}
	
	private static float quadEaseOut(float t,float b , float c, float d) {
		return -c *(t/=d)*(t-2) + b;
	}
	
	private static float quadEaseInOut(float t,float b , float c, float d) {
		if ((t/=d/2) < 1) return c/2*t*t + b;
		return -c/2 * ((--t)*(t-2) - 1) + b;
	}
	
	private static float cubicEaseIn (float t,float b , float c, float d) {
		return c*(t/=d)*t*t + b;
	}
	
	private static float cubicEaseOut (float t,float b , float c, float d) {
		return c*((t=t/d-1)*t*t + 1) + b;
	}
	
	private static float cubicEaseInOut (float t,float b , float c, float d) {
		if ((t/=d/2) < 1) return c/2*t*t*t + b;
		return c/2*((t-=2)*t*t + 2) + b;
	}
	
	private static float quartEaseIn(float t,float b , float c, float d) {
		return c*(t/=d)*t*t*t + b;
	}
	
	private static float quartEaseOut(float t,float b , float c, float d) {
		return -c * ((t=t/d-1)*t*t*t - 1) + b;
	}
	
	private static float quartEaseInOut(float t,float b , float c, float d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
		return -c/2 * ((t-=2)*t*t*t - 2) + b;
	}
	
	private static float quintEaseIn (float t,float b , float c, float d) {
		return c*(t/=d)*t*t*t*t + b;
	}
	
	private static float quintEaseOut (float t,float b , float c, float d) {
		return c*((t=t/d-1)*t*t*t*t + 1) + b;
	}
	
	private static float quintEaseInOut (float t,float b , float c, float d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
		return c/2*((t-=2)*t*t*t*t + 2) + b;
	}
	
	private static float sineEaseIn(float t,float b , float c, float d) {
		return -c * (float)Math.cos(t/d * (Math.PI/2)) + c + b;
	}
	
	private static float sineEaseOut(float t,float b , float c, float d) {
		return c * (float)Math.sin(t/d * (Math.PI/2)) + b;	
	}
	
	private static float sineEaseInOut(float t,float b , float c, float d) {
		return -c/2 * ((float)Math.cos(Math.PI*t/d) - 1) + b;
	}
	
	private static float expEaseIn(float t,float b , float c, float d) {
		return (t==0) ? b : c * (float)Math.pow(2, 10 * (t/d - 1)) + b;
	}
	
	private static float expEaseOut(float t,float b , float c, float d) {
		return (t==d) ? b+c : c * (-(float)Math.pow(2, -10 * t/d) + 1) + b;	
	}
	
	private static float expEaseInOut(float t,float b , float c, float d) {
		if (t==0) return b;
		if (t==d) return b+c;
		if ((t/=d/2) < 1) return c/2 * (float)Math.pow(2, 10 * (t - 1)) + b;
		return c/2 * (-(float)Math.pow(2, -10 * --t) + 2) + b;
	}
	
	private static float circEaseIn(float t,float b , float c, float d) {
		return -c * ((float)Math.sqrt(1 - (t/=d)*t) - 1) + b;
	}
	
	private static float circEaseOut(float t,float b , float c, float d) {
		return c * (float)Math.sqrt(1 - (t=t/d-1)*t) + b;
	}
	
	private static float circEaseInOut(float t,float b , float c, float d) {
		if ((t/=d/2) < 1) return -c/2 * ((float)Math.sqrt(1 - t*t) - 1) + b;
		return c/2 * ((float)Math.sqrt(1 - (t-=2)*t) + 1) + b;
	}
	
	private static float bounceEaseIn(float t,float b , float c, float d) {
		return c - bounceEaseOut (d-t, 0, c, d) + b;
	}
	
	private static float bounceEaseOut(float t,float b , float c, float d) {
		if ((t/=d) < (1/2.75f)) {
			return c*(7.5625f*t*t) + b;
		} else if (t < (2/2.75f)) {
			return c*(7.5625f*(t-=(1.5f/2.75f))*t + .75f) + b;
		} else if (t < (2.5/2.75)) {
			return c*(7.5625f*(t-=(2.25f/2.75f))*t + .9375f) + b;
		} else {
			return c*(7.5625f*(t-=(2.625f/2.75f))*t + .984375f) + b;
		}
	}
	
	private static float bounceEaseInOut(float t,float b , float c, float d) {
		if (t < d/2) return bounceEaseIn (t*2, 0, c, d) * .5f + b;
		else return bounceEaseOut (t*2-d, 0, c, d) * .5f + c*.5f + b;
	}

}