package sa.parallax.lib;

import android.widget.BaseAdapter;

/**
 * Created by arsal on 9/18/2016.
 */
public abstract class ParallaxBaseAdapter extends BaseAdapter
{
    public abstract int getParallaxViewId(int pos);
}