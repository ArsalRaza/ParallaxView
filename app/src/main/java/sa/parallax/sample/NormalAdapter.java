package sa.parallax.sample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import sa.parallax.lib.ParallaxBaseAdapter;

/**
 * Created by arsal on 9/13/2016.asd
 */
public class NormalAdapter extends ParallaxBaseAdapter
{
    private final int[] mImgs;
    private final Activity mActivity;
    private final LayoutInflater mInflator;

    public NormalAdapter (Activity activity, int[] imgResIds)
    {
        mActivity = activity;
        mImgs = imgResIds;
        mInflator = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return mImgs.length;
    }

    @Override
    public Object getItem(int position) {
        return mImgs[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
            convertView = mInflator.inflate(R.layout.adapter_normal, parent, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgView);
        imageView.setImageResource(mImgs[position]);

        return convertView;
    }

    @Override
    public int getParallaxViewId(int pos) {
        return R.id.imgView;
    }
}