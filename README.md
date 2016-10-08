# ParallaxView
A ParallaxView which binds data with adapter and create parallax cells in ListView.
# Demo
Please download the [demo](https://www.dropbox.com/s/grk14hu8l7hdow1/parallax-view.apk?dl=1). 
#Usage
Simply replace your ListView with a sa.parallax.lib.ParallaxListView
then add 3 optional attributes of it
```xml
activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:arsal="http://schemas.android.com/apk/res-auto"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">

    <sa.parallax.lib.ParallaxListView
        android:id="@+id/custom_listview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        arsal:minimum_item_height="200dp"
        arsal:maximum_item_height="350dp"
        arsal:anim_duration="200">
    </sa.parallax.lib.ParallaxListView>
</LinearLayout>
```
In your MainActivity file, initialize the list variable and an adapter like below

```java
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParallaxListView listView = (ParallaxListView) findViewById(R.id.custom_listview);
        listView.setAdapter(new NormalAdapter(MainActivity.this, new int[]{R.drawable.item_background, R.drawable.item_background, R.drawable.item_background, R.drawable.item_background, R.drawable.item_background, R.drawable.item_background, R.drawable.item_background, R.drawable.item_background, R.drawable.item_background}));
    }
}
```

create an xml for a parallax cell,
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">
<ImageView android:layout_width="match_parent" android:layout_height="match_parent" android:scaleType="centerCrop" android:id="@+id/imgView"/>
</LinearLayout>
```
Create a Java file for for Adapter with a base class of ParallaxBaseAdapter
```java
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
```
#Community
Looking for contributors, feel free to fork !

#Credit
Author: @ArsalImam
