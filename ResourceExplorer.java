package com.quietretreat.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quietretreat.WHOOPEE.R;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class ResourceExplorer extends ListActivity
{ 
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploredrawableresources);

        // define the list which holds the information of the list
        List<Map<String, Object>> resourceNames =
            new ArrayList<Map<String, Object>>();

        // define the map which will hold the information for each row
        Map<String, Object> data;

        // hard coded numbers retrieved from
        // http://code.google.com/android/reference/android/R.drawable.html
        for ( int idx = 17301504; idx <= 17301655; idx++ )
        {
            data = new HashMap<String, Object>();

            try
            {
                String stg = Resources.getSystem().getResourceName(idx);

                data.put("line1", stg );
                data.put("line2", idx );
                data.put("img", idx );
                resourceNames.add(data);
            }

            catch (Resources.NotFoundException nfe )
            {
                // noop ignore
            }
        }

        SimpleAdapter notes = new SimpleAdapter(
            this,
            resourceNames,
            R.layout.row,
            new String[] { "line1","line2", "img" },
            new int[] { R.id.text1, R.id.text2, R.id.img } );

        setListAdapter(notes);
    }
}