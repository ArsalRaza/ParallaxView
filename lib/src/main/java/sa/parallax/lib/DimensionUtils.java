package sa.parallax.lib;

import android.view.View;

/**
 * Created by arsal on 9/13/2016.
 */
public final class DimensionUtils {

    private static boolean isInitialised = false;
    private static float pixelsPerOneDp;

    // Suppress default constructor for noninstantiability.
    private DimensionUtils() {
        throw new AssertionError();
    }

    private static void initialise(View view) {
        pixelsPerOneDp = view.getResources().getDisplayMetrics().densityDpi / 160f;
        isInitialised = true;
    }

    public static float pxToDp(View view, float px) {
        if (!isInitialised) {
            initialise(view);
        }

        return px / pixelsPerOneDp;
    }

    public static float dpToPx(View view, float dp) {
        if (!isInitialised) {
            initialise(view);
        }

        return dp * pixelsPerOneDp;
    }
}
