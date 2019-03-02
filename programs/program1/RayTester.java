// This class will test the Ray class

public class RayTester {
    public static void main(String[] args) {
        // get the arguments for the test
        java.util.Scanner kb = new java.util.Scanner(System.in);
        String test = kb.nextLine();

        // ***************************************************
        // ***************************************************

        if (test.equalsIgnoreCase("testing parameterized constructor") || test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------");
            boolean printDescription = true;
            boolean checkChanges = false;

            // check null endpoint
            try {
                Point thisPoint = null;
                int thisDir = 187;

                if (printDescription)
                    System.out.println("\n==>Testing parameterized constructor/toString(): passing in " + thisPoint
                            + "  and  " + thisDir + "     (translate must work)");

                Ray r0 = new Ray(thisPoint, thisDir);
                System.out.println(r0);
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName()); // just prints name of exception; needed for Hypergrade
                // ex.printStackTrace(); //in case the user wants more information on the
                // exception
            }

            // check various values
            int[] xArray = { -4, 3 };
            int[] yArray = { -1 };
            int[] dirArray = { -34, 0, 34, 359, 360, 819 };

            for (int xIndex = 0; xIndex < xArray.length; xIndex++)
                for (int yIndex = 0; yIndex < yArray.length; yIndex++)
                    for (int dirIndex = 0; dirIndex < dirArray.length; dirIndex++) {
                        try {
                            int thisX = xArray[xIndex];
                            int thisY = yArray[yIndex];
                            int thisDir = dirArray[dirIndex];
                            Point thisPoint = new Point(thisX, thisY);
                            if (printDescription)
                                System.out.println("\n==>Testing parameterized constructor/toString(): passing in "
                                        + thisPoint + "  and  " + thisDir);

                            Ray r0 = new Ray(thisPoint, thisDir);
                            String r0OrigToString = r0.toString();

                            System.out.println(r0);

                            thisPoint.translate(4, 4);
                            if (checkChanges && !r0.toString().equals(r0OrigToString))
                                System.out.println("...but it was initialized with a SHALLOW copy of its endpoint");
                        } catch (Throwable ex) {
                            System.out.println(ex.getClass().getName()); // just prints name of exception; needed for
                                                                         // Hypergrade
                            // ex.printStackTrace(); //in case the user wants more information on the
                            // exception
                        }
                    }
        }

        // ***************************************************
        // ***************************************************

        if (test.equalsIgnoreCase("testing default constructor") || test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------\n");
            boolean printDescription = true;
            boolean checkChanges = true;

            try {
                if (printDescription)
                    System.out.println("==>Testing default constructor/toString()");
                Ray r0 = new Ray();
                System.out.println(r0);
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName()); // just prints name of exception; needed for Hypergrade
                // ex.printStackTrace(); //in case the user wants more information on the
                // exception
            }
        }

        // ***************************************************
        // ***************************************************

        if (test.equalsIgnoreCase("testing copy constructor") || test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------");
            boolean printDescription = true;
            boolean checkChanges = true;

            int[] xArray = { -1, 2 };
            int[] yArray = { -2, 0 };
            int[] dirArray = { 72, 158 };

            // first test if it detects that null was received
            try {
                if (printDescription)
                    System.out.println("\n==>Testing copy constructor/toString(): passing in " + null);
                Ray r0 = new Ray(null);
                System.out.println(r0);
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName()); // just prints name of exception; needed for Hypergrade
                // ex.printStackTrace(); //in case the user wants more information on the
                // exception
            }

            // now check with various Rays (different Points/directions)
            Point argPoint = null; // set later
            Ray argRay = null; // set later
            Ray theRay = null; // set later
            String origToString = "";
            String argToString = "";
            for (int xIndex = 0; xIndex < xArray.length; xIndex++)
                for (int yIndex = 0; yIndex < yArray.length; yIndex++)
                    for (int dirIndex = 0; dirIndex < dirArray.length; dirIndex++) {
                        try {
                            int thisX = xArray[xIndex];
                            int thisY = yArray[yIndex];
                            int thisDir = dirArray[dirIndex];
                            argPoint = new Point(thisX, thisY);
                            argRay = new Ray(argPoint, thisDir);
                            argToString = argRay.toString();

                            if (printDescription)
                                System.out.println("\n==>Testing copy constructor/toString(): passing in " + argRay
                                        + "     (translate must work)");

                            Ray r0 = new Ray(new Point(thisX, thisY), thisDir);
                            theRay = new Ray(argRay);
                            origToString = theRay.toString();
                            System.out.println("Ray created is: " + origToString);
                        } catch (Throwable ex) {
                            System.out.println(ex.getClass().getName()); // just prints name of exception; needed for
                                                                         // Hypergrade
                            // ex.printStackTrace(); //in case the user wants more information on the
                            // exception
                        } finally {
                            // check to be sure that argument Ray did not accidentally change
                            if (checkChanges && !argRay.toString().equals(argToString))
                                System.out.println("...but the argument Ray CHANGED during the operation");

                            // now change argRay on purpose to see if it was a shallow copy
                            else {
                                argRay.translate(3, 2);
                                if (!origToString.equals(theRay.toString()))
                                    System.out.println(
                                            "...but the Ray that was created had a SHALLOW copy of argument Ray's endpoint");
                            }
                        }
                    }
        }

        // ***************************************************
        // ***************************************************

        if (test.equalsIgnoreCase("testing translate") || test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------");
            boolean printDescription = true;
            boolean checkChanges = true;

            int[] xArray = { -7 };
            int[] yArray = { 8 };
            int[] dirArray = { 43, 265 };
            int[] translatexArray = { -4, 0 };
            int[] translateyArray = { 0, 6 };

            try {
                for (int xIndex = 0; xIndex < xArray.length; xIndex++)
                    for (int yIndex = 0; yIndex < yArray.length; yIndex++)
                        for (int dirIndex = 0; dirIndex < dirArray.length; dirIndex++) {
                            int thisX = xArray[xIndex];
                            int thisY = yArray[yIndex];
                            int thisDir = dirArray[dirIndex];

                            for (int translatexIndex = 0; translatexIndex < translatexArray.length; translatexIndex++)
                                for (int translateyIndex = 0; translateyIndex < translateyArray.length; translateyIndex++) {
                                    int thistranslateX = translatexArray[translatexIndex];
                                    int thistranslateY = translateyArray[translateyIndex];

                                    Ray r0 = new Ray(new Point(thisX, thisY), thisDir);

                                    if (printDescription)
                                        System.out.println("\n==>telling  " + r0 + " to translate(" + thistranslateX
                                                + ", " + thistranslateY + ")");

                                    r0.translate(thistranslateX, thistranslateY);
                                    System.out.println("Ray is now: " + r0);
                                }
                        }
            } catch (Throwable ex) {
                System.out.println(ex.getClass().getName()); // just prints name of exception; needed for Hypergrade
                // ex.printStackTrace(); //in case the user wants more information on the
                // exception
            }
        }

        // ***************************************************
        // ***************************************************

        /*
         * if (test.equalsIgnoreCase("testing isParallelTo") ||
         * test.equalsIgnoreCase("testing all")) {
         * System.out.println("\n-----------------------------\n"); boolean
         * printDescription = true; boolean checkChanges = true;
         * 
         * int[ ] xArray = { 6 }; int[ ] yArray = { 9, -8 }; int[ ] dirArray = { 45,
         * 135, 225 };
         * 
         * Ray theRay = null; Ray argRay = null; String origToString = "<empty>"; String
         * argToString = "<empty>";
         * 
         * for (int thisXIndex=0; thisXIndex<xArray.length; thisXIndex++) for (int
         * thisYIndex=0; thisYIndex<yArray.length; thisYIndex++) for (int
         * thisDirIndex=0; thisDirIndex<dirArray.length; thisDirIndex++)
         * 
         * for (int argXIndex=0; argXIndex<xArray.length; argXIndex++) for (int
         * argYIndex=0; argYIndex<yArray.length; argYIndex++) for (int argDirIndex=0;
         * argDirIndex<dirArray.length; argDirIndex++) { try { int thisX =
         * xArray[thisXIndex]; int thisY = yArray[thisYIndex]; int thisDir =
         * dirArray[thisDirIndex];
         * 
         * int argX = xArray[argXIndex]; int argY = yArray[argYIndex]; int argDir =
         * dirArray[argDirIndex];
         * 
         * theRay = new Ray(new Point(thisX, thisY), thisDir); origToString =
         * theRay.toString(); argRay = new Ray(new Point(argX, argY), argDir);
         * argToString = argRay.toString();
         * 
         * if (printDescription) System.out.println("==>asking " + theRay +
         * " if isParallelTo(" + argRay +")");
         * 
         * boolean answer = theRay.isParallelTo(argRay); System.out.println(answer); }
         * catch (Throwable ex) { System.out.println(ex.getClass().getName()); //just
         * prints name of exception; needed for Hypergrade //ex.printStackTrace(); //in
         * case the user wants more information on the exception } finally { if
         * (checkChanges && !theRay.toString().equals(origToString))
         * System.out.println("...but the original Ray CHANGED during the operation");
         * if (checkChanges && argRay!=null && !argRay.toString().equals(argToString))
         * System.out.println("...but the argument Ray CHANGED during the operation"); }
         * } }
         * 
         * //***************************************************
         * //***************************************************
         * 
         * if (test.equalsIgnoreCase("testing isOpposite") ||
         * test.equalsIgnoreCase("testing all")) {
         * System.out.println("\n-----------------------------"); boolean
         * printDescription = true; boolean checkChanges = true;
         * 
         * Ray theRay = null; Ray argRay = null; String origToString = "<empty>"; String
         * argToString = "<empty>";
         * 
         * //first, test the case where the argument Ray is null try { theRay = new
         * Ray(new Point(6, -1), 143); origToString = theRay.toString(); argRay = null;
         * //argToString = argRay.toString();
         * 
         * if (printDescription) System.out.println("\n==>asking " + theRay +
         * " if isOpposite(" + argRay +")");
         * 
         * boolean answer = theRay.isOpposite(argRay); System.out.println(answer); }
         * catch (Throwable ex) { System.out.println(ex.getClass().getName()); //just
         * prints name of exception; needed for Hypergrade //ex.printStackTrace(); //in
         * case the user wants more information on the exception } finally { if
         * (checkChanges && !theRay.toString().equals(origToString))
         * System.out.println("...but the original Ray CHANGED during the operation");
         * if (checkChanges && argRay!=null && !argRay.toString().equals(argToString))
         * System.out.println("...but the argument Ray CHANGED during the operation"); }
         * 
         * 
         * //test many other possibilities - some true, some false int[ ] xArray = { 6
         * }; int[ ] yArray = { 9 }; int[ ] dirArray = { 45, 135, 225, 315 };
         * 
         * for (int thisXIndex=0; thisXIndex<xArray.length; thisXIndex++) for (int
         * thisYIndex=0; thisYIndex<yArray.length; thisYIndex++) for (int
         * thisDirIndex=0; thisDirIndex<dirArray.length; thisDirIndex++)
         * 
         * for (int argXIndex=0; argXIndex<xArray.length; argXIndex++) for (int
         * argYIndex=0; argYIndex<yArray.length; argYIndex++) for (int argDirIndex=0;
         * argDirIndex<dirArray.length; argDirIndex++) { try { int thisX =
         * xArray[thisXIndex]; int thisY = yArray[thisYIndex]; int thisDir =
         * dirArray[thisDirIndex];
         * 
         * int argX = xArray[argXIndex]; int argY = yArray[argYIndex]; int argDir =
         * dirArray[argDirIndex];
         * 
         * theRay = new Ray(new Point(thisX, thisY), thisDir); origToString =
         * theRay.toString(); argRay = new Ray(new Point(argX, argY), argDir);
         * argToString = argRay.toString();
         * 
         * if (printDescription) System.out.println("\n==>asking " + theRay +
         * " if isOpposite(" + argRay +")");
         * 
         * boolean answer = theRay.isOpposite(argRay); System.out.println(answer); }
         * catch (Throwable ex) { System.out.println(ex.getClass().getName()); //just
         * prints name of exception; needed for Hypergrade //ex.printStackTrace(); //in
         * case the user wants more information on the exception } finally { if
         * (checkChanges && !theRay.toString().equals(origToString))
         * System.out.println("...but the original Ray CHANGED during the operation");
         * if (checkChanges && argRay!=null && !argRay.toString().equals(argToString))
         * System.out.println("...but the argument Ray CHANGED during the operation"); }
         * } }
         */
        // ***************************************************
        // ***************************************************
        if (test.equalsIgnoreCase("testing equals") || test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------");
            boolean printDescription = true;
            boolean checkChanges = true;

            Ray theRay = new Ray(new Point(1, 2), 152);
            String origToString = "<empty>";
            Object argObject = null;
            String argOrigToString = "<empty>";

            Object[] argArray = { null, theRay.toString(), new Ray(new Point(1, 2), 143), new Ray(new Point(7, 8), 152),
                    new Ray(new Point(-1, 6), 28), new Ray(new Point(1, 2), 152), // correct one
            };

            for (int argIndex = 0; argIndex < argArray.length; argIndex++) {
                try {
                    theRay = new Ray(new Point(1, 2), 152); // same as above
                    origToString = theRay.toString();

                    argObject = argArray[argIndex];
                    System.out.print("\n==>Testing whether " + theRay + " .equals " + argObject);
                    if (argObject != null && argObject.getClass() == "".getClass()) // String
                        System.out.println(" (as a STRING)");
                    else
                        System.out.println();

                    if (argObject != null)
                        argOrigToString = argObject.toString();

                    boolean result = theRay.equals(argObject);
                    System.out.println(result);
                } catch (Throwable ex) {
                    System.out.println(ex.getClass().getName()); // just prints name of exception; needed for Hypergrade
                    ex.printStackTrace(); // in case the user wants more information on the exception
                } finally {
                    if (checkChanges && !theRay.toString().equals(origToString))
                        System.out.println("...but the original Ray CHANGED during the operation");
                    if (checkChanges && argObject != null && !argObject.toString().equals(argOrigToString))
                        System.out.println("...but the argument Ray CHANGED during the operation");
                }
            }
        }

        // ***************************************************
        // ***************************************************

        if (test.equalsIgnoreCase("testing rotate") || test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------");
            boolean printDescription = true;
            boolean checkChanges = true;

            int[] xArray = { -7 };
            int[] yArray = { 0 };
            int[] dirArray = { 0, 35, 287 };
            int[] rotateArray = { -20, 0, 359, 360, 847 };

            for (int xIndex = 0; xIndex < xArray.length; xIndex++)
                for (int yIndex = 0; yIndex < yArray.length; yIndex++)
                    for (int dirIndex = 0; dirIndex < dirArray.length; dirIndex++)
                        for (int rotateIndex = 0; rotateIndex < rotateArray.length; rotateIndex++) {
                            try {
                                int thisX = xArray[xIndex];
                                int thisY = yArray[yIndex];
                                int thisDir = dirArray[dirIndex];

                                int rotation = rotateArray[rotateIndex];
                                int x = xArray[xIndex];
                                int y = yArray[yIndex];
                                Point thisPoint = new Point(x, y);
                                Ray r0 = new Ray(thisPoint, thisDir);

                                if (printDescription)
                                    System.out.println(
                                            "\n==> create Ray  " + r0 + " and tell it to rotate(" + rotation + ")");
                                r0.rotate(rotation);
                                System.out.println(r0);
                            } catch (Throwable ex) {
                                System.out.println(ex.getClass().getName()); // just prints name of exception; needed
                                                                             // for Hypergrade
                                // ex.printStackTrace(); //in case the user wants more information on the
                                // exception
                            }
                        }
        }

        // ***************************************************
        // ***************************************************

        if (test.equalsIgnoreCase("testing goesAboveXAxis") || test.equalsIgnoreCase("testing all")) {
            System.out.println("\n-----------------------------");
            boolean printDescription = true;
            boolean checkChanges = true;

            int[] xValues = { -4, 3 };
            int[] yValues = { 0, -2, 5 };
            int[] dirValues = { 0, 1, 180, 181 };

            Ray r0 = null;
            String r0OrigtoString = "<empty>";

            for (int xIndex = 0; xIndex < xValues.length; xIndex++)
                for (int yIndex = 0; yIndex < yValues.length; yIndex++)
                    for (int dirIndex = 0; dirIndex < dirValues.length; dirIndex++) {
                        try {
                            int x = xValues[xIndex];
                            int y = yValues[yIndex];
                            int dir = dirValues[dirIndex];
                            r0 = new Ray(new Point(x, y), dir);
                            r0OrigtoString = r0.toString();
                            if (printDescription)
                                System.out.println("\n==> create Ray  " + r0 + " and ask it if it goesAboveXAxis()");

                            boolean answer = r0.goesAboveXAxis();
                            System.out.println(answer);
                        } catch (Throwable ex) {
                            System.out.println(ex.getClass().getName()); // just prints name of exception; needed for
                                                                         // Hypergrade
                            // ex.printStackTrace(); //in case the user wants more information on the
                            // exception
                        } finally {
                            if (checkChanges && !r0.toString().equals(r0OrigtoString))
                                System.out.println("...but the Ray was CHANGED during the operation.");
                        }
                    }
        }

    } // end of main
} // end of class
