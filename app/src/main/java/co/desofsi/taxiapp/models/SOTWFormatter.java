package co.desofsi.taxiapp.models;
import android.content.Context;
import co.desofsi.taxiapp.*;
/**
 * SOTW is short Side Of The World
 * The class helps to convert azimuth degrees to human readable
 * label like "242° SW" or "0° N"
 * This is a task of finding the closest element in the array.
 * Binary search is used to save some CPU.
 * Copied with modifications from
 * https://www.geeksforgeeks.org/find-closest-number-array/
 */

/**
 * Created by om on 4/10/2019.
 */
public class SOTWFormatter {
    private static final int[] sides = {0, 45, 90, 135, 180, 225, 270, 315, 360}; //9
    private static String[] names = null;

    public SOTWFormatter(Context context) {
        initLocalizedNames(context);
    }

    public String format(float azimuth) {
        int iAzimuth = (int)azimuth;
        int index = findClosestIndex(iAzimuth);
        return iAzimuth + "° " + names[index];
    }

    private void initLocalizedNames(Context context) {
        // it will be localized version of
        // {"N", "NE", "E", "SE", "S", "SW", "W", "NW", "N"} // 9
        // Here, N is twice, for 0 and for 360

        if (names == null) {
            names = new String[]{context.getString(R.string.sotw_north),
                    context.getString(R.string.sotw_northeast),
                    context.getString(R.string.sotw_east),
                    context.getString(R.string.sotw_southeast),
                    context.getString(R.string.sotw_south),
                    context.getString(R.string.sotw_southwest),
                    context.getString(R.string.sotw_west),
                    context.getString(R.string.sotw_northwest),
                    context.getString(R.string.sotw_north)
            };
        }
    }

    /**
     * Finds index of the closest element to identify Side Of The World label
     * @param target
     * @return index of the closest element
     */
    private static int findClosestIndex(int target) {

        int i = 0, j = sides.length, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;


            if (target < sides[mid]) {

                if (mid > 0 && target > sides[mid - 1]) {
                    return getClosest(mid - 1, mid, target);
                }


                j = mid;
            } else {
                if (mid < sides.length-1 && target < sides[mid + 1]) {
                    return getClosest(mid, mid + 1, target);
                }
                i = mid + 1; // update i
            }
        }

        return mid;
    }


    private static int getClosest(int index1, int index2, int target) {
        if (target - sides[index1] >= sides[index2] - target) {
            return index2;
        }
        return index1;
    }
}