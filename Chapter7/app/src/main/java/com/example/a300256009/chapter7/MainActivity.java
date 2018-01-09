package com.example.a300256009.chapter7;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] animals={R.drawable.eagle,R.drawable.elephant,R.drawable.gorilla,R.drawable.panda,
    R.drawable.panther,R.drawable.polar};
    ImageView pic;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    GridView grid=(GridView)findViewById(R.id.gridView);
    //grid.setAdapter(new ImageAdapter(this));//wont work becoz ts not there ,Therefore create class and extend base adapter
    grid.setAdapter(new ImageAdapter(this));
    final ImageView pic= (ImageView)findViewById(R.id.imgLarge); //final is important
   grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

           Toast.makeText(getBaseContext(), "Selected "+(i+1), Toast.LENGTH_SHORT).show();
           pic.setImageResource(animals[i]);
       }
   });
}

    public class ImageAdapter extends BaseAdapter//alt+ebter to implement class methods
    {
        //create variables
        private Context context;



        public ImageAdapter(Context c) {

            context=c;
        }

        @Override
        public int getCount() {
            return animals.length; //any number if you will specify here ,you will get an error if code for getView isn't there.
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           pic=new ImageView(context);
            pic.setImageResource(animals[i]);
           pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(300,330));
            return pic;
        }
    }

    public void nextPage(View view)
    {
        Toast.makeText(MainActivity.this,"Hey You are getting new Message !!",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,PracticeActivity.class));

    }


}
