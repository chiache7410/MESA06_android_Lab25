package tw.org.iii.lab25;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private MyAdapter myAdapter;
    private MyAdapter2 myAdapter2;
    private int[] balls = {R.drawable.ball1, R.drawable.ball2, R.drawable.ball3,
                        R.drawable.ball4, R.drawable.ball5, R.drawable.ball6,
                        R.drawable.ball7, R.drawable.ballpoke, R.drawable.ballgreat,
                        R.drawable.ballultra, R.drawable.ballsafari, R.drawable.ballpremier,
                        R.drawable.ballcherish, R.drawable.ballmaster};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridView);
        initGridView();
    }
    private void initGridView() {
        myAdapter = new MyAdapter(this);
        myAdapter2 = new MyAdapter2(this);
        gridView.setAdapter(myAdapter2);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("brad", "i = " + position);
            }
        });
    }
    private class MyAdapter extends BaseAdapter {
        private Context context;
        MyAdapter(Context context){this.context = context;}
        @Override
        public int getCount() {
            return balls.length;
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
            ImageView img;
            if (convertView == null) {
                img = new ImageView(context);
                img.setLayoutParams(new GridView.LayoutParams(256, 256));
                img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }else {
                img = (ImageView)convertView;
            }
            img.setImageResource(balls[position]);
            return img;
        }
    }
    private class MyAdapter2 extends BaseAdapter {
        private Context context;
        MyAdapter2(Context context) {this.context = context;}
        @Override
        public int getCount() {
            return balls.length;
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
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
            }
            ImageView img = (ImageView)convertView.findViewById(R.id.item_img);
            TextView title = (TextView)convertView.findViewById(R.id.item_title);
            img.setImageResource(balls[position]);
            //img.setLayoutParams(new GridView.LayoutParams(256, 256));
            title.setText("Ball " + position);
            if (position%2 == 0) {
                convertView.setBackgroundColor(Color.YELLOW);
            }
            return convertView;
        }
    }
}
