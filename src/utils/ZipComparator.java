package utils;

import model.ZipRange;

import java.util.Comparator;



public class ZipComparator implements Comparator<ZipRange> {

    @Override
    public int compare(ZipRange o1, ZipRange o2) {

        //compare lower ranger between two input ranges
        int comp = o1.getLowerRange()- o2.getLowerRange();

      // if two ranges have same lower range then check for higher ranges
    if (comp == 0)
    {
        comp =o1.getUpperRange() - o2.getUpperRange();
    }
        return comp;
    }
}
