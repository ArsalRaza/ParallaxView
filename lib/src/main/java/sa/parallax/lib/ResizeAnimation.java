package sa.parallax.lib;

/**
 * Created by imac on 02/10/16.
 */

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ResizeAnimation extends Animation
{
    private View mView;
    private int mTargetHeight;
    private int mStartHeight;
    private View mNextView;
    private int mNextStart;
    private int mNextTarget;
    private int mMaxItemHeight;

    public ResizeAnimation(View v, int target, int start, View nextView, int nextStart, int nextTarget, int maxHeight)
    {
        this.mView = v;
        mTargetHeight = target;
        mStartHeight = start;
        mNextView = nextView;
        mNextStart = nextStart;
        mNextTarget = nextTarget;
        mMaxItemHeight = maxHeight;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        if (mNextView == null) return;
        //!-- View1 animation
        int newHeight = (int) (mStartHeight + (mTargetHeight - mStartHeight) * interpolatedTime);
        mView.getLayoutParams().height = newHeight;
        mView.requestLayout();

        //!--View2 animation
        try {
            int mNextItemHeight = mNextView.getLayoutParams().height;

            float mNextScrollTop = mNextView.getTop();
            float mRestrictedArea = (2 * mNextScrollTop) - mNextItemHeight;

            if (mRestrictedArea <= mMaxItemHeight) {
                Log.e(ParallaxListView.TAG, "Restricted area = " + mRestrictedArea);
                int mNextScroll = (int) (mNextStart + (mNextTarget - mNextStart) * interpolatedTime);
                if (mNextScroll == mMaxItemHeight) {
                    return;
                } else if (mNextScroll > mMaxItemHeight) {
                    mNextScroll = mMaxItemHeight;
                }
                mNextView.getLayoutParams().height = Math.round(mNextScroll);
                mNextView.requestLayout();
            } else {
                Log.e(ParallaxListView.TAG, "Restricted area = " + mRestrictedArea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}

