/**
 * Program Name: StyleRay.java Program Author: Ivan Martinez Morales Program Due
 * Date: 28 February 2019 Program Description: StyleRay is a class that is a
 * subclass of Ray. It applies style to the Ray, either a dotted, dashed, or
 * double Ray.
 */

public class StyleRay extends Ray implements StyleRayInterface {

    // DATA
    private String rayStyle;

    // CONSTRUCTORS
    /**
     * Default Constructor - Creates a StyleRay with the coordinates: (3,4) and the
     * direction of 135. Sets the style to "double"
     */
    public StyleRay() {
        super();
        this.rayStyle = "double";
    }

    /**
     * Parameterized Constructor - Created a StyleArray with the following:
     * 
     * @param  Point  aPoint - a new point that will create our endPoint
     * @param  int direction - Direction that the Ray will point.
     * @param  String style - String with the styling (i.e. dotted, double, or
     *               dashed.)
     */
    public StyleRay(Point aPoint, int direction, String style) {
        
        // CASE 0: aPoint is null
        if (aPoint == null) {
            throw new IllegalArgumentException("Illegal operation.  Cannot create a StyleRay with a null point.  ");
        }
        // CASE 1: Style is null
        if (style == null) {
            throw new IllegalArgumentException("Style cannot be left null.");
        }

        
        // CASE 2: Direciton is greater than less than 0 or greater than 359
        else if ((direction < 0) || (direction >= 360)) {
            throw new IllegalArgumentException("Illegal direction parameters.  Direction must be between 0 and 359 degrees.");
        }

        // CASE 3: Style is not dotted, dashed, or double
        else if (!style.matches("dotted|dashed|double")) {
            throw new IllegalArgumentException("Style invalid.  Has to be dotted, dashed, or double.  ");
        }
        
        else {

            this.endPoint = aPoint;
            this.direction = direction;
            this.rayStyle = style;
        }
    }

    /**
     * Copy Constructor - Create a copy of the styled Ray with the following
     * stipulations: If the StyledRay is null, throw a IAE... otherwise proceed and
     * copy the Ray over.
     * 
     * @param  StyleRay a StyleRay that we would like to copy
     */
    public StyleRay(StyleRay another) {
        if (another == null) {
            throw new IllegalArgumentException("Cannot create a null copy. ");
        }

        this.endPoint = new Point(another.endPoint);
        this.direction = another.direction;
        this.rayStyle = another.rayStyle;
    }


    // METHODS

    /**
     * @return a String representation of the class.
     * If the rayStyle is a double, return "endPoint=====>Direction"
     * If the rayStyle is dashed, return "endPoint----->Direction" (from the parent class)
     * If the rayStyle is dotted, return "endPoint.....>Direction"
     * In any instance, return five middle-man characters.
     * 
     * 
     */
    @Override
    public String toString() {

        String result = null;

        switch(this.rayStyle.toLowerCase()) {

            case "dotted":
                result = this.endPoint + ".....>" + this.direction;
                break;

            case "dashed":
                result = this.endPoint + "- - ->" + this.direction;
                break;

            case "double":
                result = this.endPoint + "=====>" + this.direction;
                break;
            
            default:
                break;
        }
        return result;
    }
    /**
     * @return True if rayStyle is dotted. Calls .equalsIgnoreCase.
     */
    @Override
    public boolean isDotted() {
        return this.rayStyle.equalsIgnoreCase("dotted");
    }

    /**
     * @return True if rayStyle is dashed. Calls .equalsIgnoreCase.
     */
    @Override
    public boolean isDashed() {
        return this.rayStyle.equalsIgnoreCase("dashed");
    }

    /**
     * @return True if rayStyle is double. Calls .equalsIgnoreCase.
     */
    @Override
    public boolean isDouble() {
        return this.rayStyle.equalsIgnoreCase("double");
    }

}