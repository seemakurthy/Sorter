package service;

import model.ZipRange;
import utils.ZipComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZipSorter {


    public static List<ZipRange> convertRangetoZipRange(String[] zipranges) {

        List<ZipRange> inputRanges = new ArrayList<ZipRange>();

        for (String range : zipranges) {
            //   Convert the String array to zip objects
            String tokens[] = range.split(",");
            int firstZip = Integer.parseInt(tokens[0].replace("[", ""));
            int secondZip = Integer.parseInt(tokens[1].replace("]", ""));

            //Set upper and lower ranges with in each Zip range
            if (secondZip < firstZip) {
                int temp = firstZip;
                firstZip = secondZip;
                secondZip = temp;
            }
            inputRanges.add(new ZipRange(firstZip, secondZip));
        }


        return inputRanges;
    }


    //Sort ranges using the Comparator Implementation
    public static ZipRange[] sortandreduceZipCodeRanges(List<ZipRange> zipranges) {


        Collections.sort(zipranges, new ZipComparator());


        List<ZipRange> finalRanges = new ArrayList<ZipRange>();

        //first range is lowest
        finalRanges.add(zipranges.get(0));

        //iterate and reduce the  Zip ranges if ranges overlap

        ZipRange firstRange = zipranges.get(0);
        int rangeId = 0;
        for (int i = 1; i < zipranges.size(); i++) {
            ZipRange secondRange = zipranges.get(i);

            if (!firstRange.equals(secondRange)) {

                //Check if the first range upper bound  is bigger than the lower lower of the second rage after sorting
                if (firstRange.getUpperRange() >= secondRange.getLowerRange()) {

                    //merge the two ranges to single range
                    int upperBound = 0;
                    if (firstRange.getLowerRange() > secondRange.getUpperRange()) {
                        upperBound = firstRange.getUpperRange();
                    } else {
                        upperBound = secondRange.getUpperRange();
                    }
                    //Create new Zip range
                    ZipRange mergeZipCodeRange = new ZipRange(firstRange.getLowerRange(), upperBound);
                    firstRange = mergeZipCodeRange;
                    finalRanges.set(rangeId, mergeZipCodeRange);
                } else {
                    firstRange = secondRange;
                    finalRanges.add(secondRange);
                    rangeId = i;
                }
            }
        }

        ZipRange[] arr = new ZipRange[finalRanges.size()];
        arr = finalRanges.toArray(arr);
        return arr;
    }


}


