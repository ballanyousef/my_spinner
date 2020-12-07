package com.it.yb.my_spinner;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity2 extends Activity {
    Spinner spinner2;
    //TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner2=findViewById(R.id.spinner2);

        OurAdapter myAdapter=new OurAdapter(this,R.layout.spinner_layout);
        spinner2.setAdapter(myAdapter);
              // for(int i=0;i<myAdapter.getCount();i++){
              //  myAdapter.getView(i,--)
              // }
    }

    //use inner class

    public class OurAdapter extends BaseAdapter {


        Context ctx;
        int resourceId;
        String []names;

        public OurAdapter(Context ctx, int resourceId){
            this.ctx=ctx;
            this.resourceId=resourceId;

            AssetManager am = this.ctx.getAssets();
            try {
                this.names = am.list("pics");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getCount() {
            return this.names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater ll=(LayoutInflater) this.ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
            View v=ll.inflate(resourceId,null);
            ImageView iv=v.findViewById(R.id.imageView);

            AssetManager assets = getAssets();//
            InputStream stream; //
            try {
                stream = assets.open("pics/"+names[position]);
                Drawable myImg = Drawable.createFromStream(stream, null);
                iv.setImageDrawable(myImg);
            }
            catch (Exception e) {

            }


            TextView tv=v.findViewById(R.id.textView_1);
            tv.setText(names[position]);


            return v;
        }
    }


}