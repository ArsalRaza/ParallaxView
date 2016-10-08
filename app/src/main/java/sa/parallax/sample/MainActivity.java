package sa.parallax.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sa.parallax.lib.ParallaxListView;

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