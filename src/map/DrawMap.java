package map;
//importing classes that are going to be used

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Drawing map class begins here
public class DrawMap {

    String path;

    public DrawMap(String s) {
        path = s;

    }
    
    //Here we are drawing the picture
    public void populateMap(String dataPath) throws FileNotFoundException, IOException {
        double[] ary1;
        double[] ary2;
        HashMap map = new HashMap();
        //Getting cordinates to draw map using latitude and longitude values
        File file = new File(path);
        Scanner scanner = new Scanner(file.getAbsoluteFile());
        double latMin = scanner.nextDouble();
        double longMin = scanner.nextDouble();
        double latMax = scanner.nextDouble();
        double longMax = scanner.nextDouble();
        //Setting the canvas size to 1000 pixels vertically and 500 horizontally

        double xFactor = 400 / (longMax - longMin);
        double yFactor = xFactor * ((-1 * latMin) - (-1 * latMax));
        int zFactor = (int) yFactor;
        StdDraw.setCanvasSize(zFactor, 500);

        File data = new File(dataPath);
        Scanner dataScan = new Scanner(data.getAbsoluteFile());

        //finding the region number to tell the program what map to draw
        int regionNumber = scanner.nextInt();
        //Drawing actual map
        //it has "- 1" and "+ 1" to have a buffer between edge of the screen and the map
        StdDraw.setXscale(latMin - 1, latMax + 1);
        StdDraw.setYscale(longMin - 1, longMax + 1);
        dataScan.nextLine();
        int p = 0;
        ArrayList<String> stringAry = new ArrayList();
        while (dataScan.hasNextLine()) {
            stringAry.add(dataScan.nextLine());
            p++;
        }
        int r = 0;
        int g = 0;
        int b = 0;

        int q = 0;
        for (int x = 0; x < regionNumber; x++) {
            String mainString = null;
            String district = null;
            int pointNumber = 0;
            String state = null;
            while (true) {
                if (scanner.hasNextInt()) {
                    pointNumber = scanner.nextInt();
                    break;
                } else {
                    state = scanner.nextLine();
                    district = scanner.nextLine();
                }
            }

            if (q == 0) {
                map.put(state, stringAry.get(q));
                q++;
                mainString = (String) map.get(state);
            } else {
                if (map.containsKey(state)) {
                    mainString = (String)map.get(state);
                } else {
                    q++;
                    map.put(state, stringAry.get(q));
                    mainString = (String) map.get(state);
                }
            }

            System.out.println(state);
            System.out.println(district);
            System.out.println(pointNumber);
            ary1 = new double[pointNumber];
            ary2 = new double[pointNumber];
            int i = 0;
            while (scanner.hasNextDouble()) {
                ary1[i] = scanner.nextDouble();
                ary2[i] = scanner.nextDouble();
                i++;
            }
            if (mainString != null) {
             String concatString = "";
             int lastIndex = 0;
             for (i = 0; i < mainString.length(); i++) {
             if (mainString.codePointAt(i) <= 57 && mainString.codePointAt(i) >= 48) {
             if (mainString.charAt(i + 1) == ',' && i < mainString.length()) {
             concatString = concatString + mainString.charAt(i);
             lastIndex = i;
             i = mainString.length();
             } else {
             concatString = concatString + mainString.charAt(i);

             }
             }
             }
             r = Integer.parseInt(concatString);
             mainString = mainString.substring(lastIndex + 1);
             }

             if (mainString != null) {
             String concatString = "";
             int lastIndex = 0;
             for (i = 0; i < mainString.length(); i++) {
             if (mainString.codePointAt(i) <= 57 && mainString.codePointAt(i) >= 48) {
             if (mainString.charAt(i + 1) == ',' && i < mainString.length()) {
             concatString = concatString + mainString.charAt(i);
             lastIndex = i;
             i = mainString.length();
             } else {
             concatString = concatString + mainString.charAt(i);

             }
             }
             }
             b = Integer.parseInt(concatString);
             mainString = mainString.substring(lastIndex + 1);
             }

             if (mainString != null) {
             String concatString = "";
             int lastIndex = 0;
             for (i = 0; i < mainString.length(); i++) {
             if (mainString.codePointAt(i) <= 57 && mainString.codePointAt(i) >= 48) {
             if (mainString.charAt(i + 1) == ',' && i < mainString.length()) {
             concatString = concatString + mainString.charAt(i);
             lastIndex = i;
             i = mainString.length();
             } else {
             concatString = concatString + mainString.charAt(i);

             }
             }
             }
             g = Integer.parseInt(concatString);
             mainString = mainString.substring(lastIndex + 1);
             }


             double sum = r + g + b;
             System.out.println(r);
             System.out.println(g);
             System.out.println(b);
             System.out.println(" ");

            //if else statement to set colors of maps and draws the polygons
            if (x < regionNumber - 1) {
                Color color = new Color((float) (r / sum), (float) (g / sum), (float) (b / sum));
                //Drawing in color
                StdDraw.setPenColor(color);
                StdDraw.filledPolygon(ary1, ary2);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.polygon(ary1, ary2);

            } else {
                Color color = new Color((float) (r / sum), (float) (g / sum), (float) (b / sum));
                StdDraw.setPenColor(color);
                StdDraw.filledPolygon(ary1, ary2);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.polygon(ary1, ary2);
                x = regionNumber;
            }
            
        }
    }
    
    
    
    public void inputParsing(String mainString, int x) {

    }
}
