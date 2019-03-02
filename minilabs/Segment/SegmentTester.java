public class SegmentTester {
    public static void main(String[] args) {
        System.out.println("Creating default constructor...");
        Segment defaultSegment = new Segment();

        System.out.println("Testing toString() method.");
        System.out.println(defaultSegment.toString());

        System.out.println("Testing length() - " + defaultSegment.length());

        System.out.println("Testing translate by moving x=0, x=0");
        
        try {
            defaultSegment.translate(0,0);

        } catch (Exception e) {
            System.out.println(e);
        } 
        
        System.out.println("Now testing translate() with x=1, y=3");
        defaultSegment.translate(1,3);
        System.out.println(defaultSegment.toString());

    }
}