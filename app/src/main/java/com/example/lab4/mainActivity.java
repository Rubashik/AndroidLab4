package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mainActivity extends Activity implements ExpandableListView.OnChildClickListener {

    private List <Group> groups = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGroups();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.DemoListView);
        SimpleExpandableListAdapter expListAdapter =
                new SimpleExpandableListAdapter(
                        this,
                        createGroupList(),
                        R.layout.group_row,
                        new String[] {"Group Item"},
                        new int[] {R.id.row_name},

                        createChildList(),
                        R.layout.child_row,
                        new String[] {"Sub Item"},
                        new int[] {R.id.grp_child}
                );
        listView.setAdapter(expListAdapter);
        listView.setOnChildClickListener(this);

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Group g = groups.get(groupPosition);

        Class<Activity> action = g.actions.get(childPosition);
        if(action != null){
            Intent intent = new Intent(this, action);
            startActivity(intent);
        }
        return true;
    }

    private void createGroups(){
        Group webG = new Group("Web");
        Group mapG = new Group("Map");
        Group telG = new Group("Phone");

        webG.addChild("Molfar Tech", WebActivity.class);
        mapG.addChild("Display Object on Map", MapActivity.class);
        telG.addChild("telephone", PhoneActivity.class);

        groups.add(webG);
        groups.add(mapG);
        groups.add(telG);
    }


    private static class Group {
        String name;
        List<String> children = new ArrayList<String>();
        List<Class<Activity>> actions = new ArrayList<Class<Activity>>();

        private Group (String name) {this.name=name;}

        public void addChild(String name, Class action){
            children.add(name);
            actions.add(action);
        }
    }

    private List<Map<String,String>> createGroupList(){
        List<Map<String,String>> result = new ArrayList<Map<String,String>>();
        for(Group g : groups){
            Map<String,String> m = new HashMap<String,String>();
            m.put("Group Item", g.name);
            result.add(m);
        }
        return result;
    }

    private List<List<Map<String,String>>> createChildList(){
        List<List<Map<String,String>>> result = new ArrayList<List<Map<String,String>>>();
        for (Group g : groups){
            List<Map<String,String>> secList = new ArrayList<Map<String,String>>();
            for (String c : g.children){
                Map<String,String> child = new HashMap<String,String>();
                child.put("Sub Item",c);
                secList.add(child);
            }
            result.add(secList);
        }
        return result;
    }

    public void onContentChanged(){
        System.out.println("onContentChanged");
        super.onContentChanged();
    }
}

