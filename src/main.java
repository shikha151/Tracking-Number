/**
 * Created by test on 7/27/2015.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class main {


    public static void readFile(String fileName, List<TrackingRange> constraints) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/test/Desktop/TrackingRange/src/input.txt"));
            String constraint = " ";

            while (!constraint.equals("END")) {
                try {
                    constraint = reader.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                TrackingRange constraintObject = new TrackingRange();
                String rangeAttributes[] = constraint.split(" ");
                constraintObject.range.lo = Integer.parseInt(rangeAttributes[0]);
                constraintObject.range.hi = Integer.parseInt(rangeAttributes[1]);
                constraintObject.statusCode = rangeAttributes[2];
                constraintObject.transferCode = rangeAttributes[3];
                constraints.add(constraintObject);
                //}
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void main(String args[]) {


        List<TrackingRange> constraints = new ArrayList<TrackingRange>();



        readFile("input.txt", constraints);


        for (TrackingRange constraint : constraints) {

        }

        System.out.println(constraints);


    }
}
