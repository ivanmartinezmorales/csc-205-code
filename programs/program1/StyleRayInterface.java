public interface StyleRayInterface {
    public String toString();          // Returns a string representation of the Styled Ray.
    public boolean equals(Object obj); // Tests if the instance of the class and the object are equal
    public boolean isDotted();         // Returns true if rayStyle is a Dotted.
    public boolean isDashed();         // Returns true if rayStyle is a Dashed
    public boolean isDouble();         // Returns true if rayStyle is a Double.
}