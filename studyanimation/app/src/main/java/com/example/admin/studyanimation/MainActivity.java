package com.example.admin.studyanimation;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<AllTest> activities = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        final ListView lists = (ListView)(findViewById(R.id.list));
        MyAdapter m = new MyAdapter();
        lists.setAdapter(m);
        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                overLab(activities.get(position).getClzz());
            }
        });

    }

    private void initData() {

        activities = new ArrayList<>();
        activities.add(new AllTest("rotation",SingleRotationAnActivity.class));
        activities.add(new AllTest("alpha",SingleAlphaAnActivity.class));
        activities.add(new AllTest("translateX",SingletranslatexAnActivity.class));
        activities.add(new AllTest("scaleY",SinglescaleYActivity.class));
        activities.add(new AllTest("muti",MultAnActivity.class));
        activities.add(new AllTest("middle",MiddleAnActivity.class));
        activities.add(new AllTest("top",TopAnActivity.class));
        activities.add(new AllTest("my",SelfAnActivity.class));
    }
    void overLab(Class c){
        startActivity(new Intent(this,c));

    }
    static class ViewHolder {
        TextView text;
        ImageView icon;
    }
    private class AllTest
    {
        private String name;
        public AllTest(String name,Class clzz){
            this.clzz = clzz;
            this.name = name;
        }

        public Class getClzz() {
            return clzz;
        }

        public void setClzz(Class clzz) {
            this.clzz = clzz;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private Class clzz;


    }
    private class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater = getLayoutInflater();
        @Override
        public int getCount() {
            return activities.size();
        }

        @Override
        public Object getItem(int position) {
            return activities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.eachitem, null);
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.text);
                holder.icon = (ImageView) convertView.findViewById(
                        R.id.icon);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.text.setText(activities.get(position).getName());
            holder.icon.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
            return convertView;
        }

        @Override
        public boolean isEmpty() {
            return activities.size()>0?false:true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
