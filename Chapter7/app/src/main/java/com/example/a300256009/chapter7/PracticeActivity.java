package com.example.a300256009.chapter7;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class PracticeActivity extends AppCompatActivity {

    Integer[] animals={R.drawable.eagle,R.drawable.elephant,R.drawable.gorilla,R.drawable.panda,R.drawable.panther,R.drawable.polar};
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        GridView grid =(GridView)findViewById(R.id.grid2);
        grid.setAdapter(new ImageAdapterr(this));
        final ImageView pic= (ImageView)findViewById(R.id.imageView); //final is important
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getBaseContext(), "Selected "+(i+1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(animals[i]);
            }
        });
    }

 class ImageAdapterr extends BaseAdapter
{
    private Context context;

    public ImageAdapterr(Context c) {

        context=c;
    }

    @Override
    public int getCount() {
        return animals.length;
    }

    @Override
    public Object getItem(int i) {
        return  null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        pic=new ImageView(context);
        pic.setImageResource(animals[i]);
        pic.setScaleType(ImageView.ScaleType.FIT_XY);
        pic.setLayoutParams(new GridView.LayoutParams(300,330));
        return pic;
    }
}

}