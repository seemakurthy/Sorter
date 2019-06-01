import com.sun.deploy.util.StringUtils;
import model.ZipRange;
import service.ZipSorter;

import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Zip Ranges missing");
            System.exit(1);
        }

        System.out.println("Received Ranges: " + StringUtils.join(Arrays.asList(args), " "));

        // ranges into Objects with sorted upper and lower bounds
        List<ZipRange> ranges = ZipSorter.convertRangetoZipRange(args);

        //Sort and Reduce the ranges
        ZipRange[] sortedranges = ZipSorter.sortandreduceZipCodeRanges(ranges);


        System.out.println("Sorted Ranges: " + Arrays.toString(sortedranges));


    }
}
