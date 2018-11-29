package com.bignerdranch.android.sovt_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.ArrayList;


public class GeneralSchedule extends Fragment {

    public GeneralSchedule(){

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_general_schedule, container, false);

        ListViewForScrollView mListView = (ListViewForScrollView) view.findViewById(R.id.listView);
        ListViewForScrollView mListView2 = (ListViewForScrollView) view.findViewById(R.id.listView2);
        ListViewForScrollView mListView3 = (ListViewForScrollView) view.findViewById(R.id.listView3);

        Activity d1e1 = new Activity("4:30 - 6:00pm","Delegation Check-In Ticket Center at Pico Mountain\n（Sunday night dinner is on your own. Pico Mountain’s Slopeside Pizzeria will be offering specials: $10 cheese pizza and $12 one-topping pizzas from 4pm-8pm. Call ahead orders are accepted.)");
        Activity d1e2 = new Activity("6:35pm", "Line-up for the Parade of Athletes");
        Activity d1e3 = new Activity("6:45pm", "Parade of Athletes- procession through Pico Mountain base area");
        Activity d1e4 = new Activity("7:00 – 7:30pm", "Opening Ceremonies- outside at Pico Map- can be seen from Base Lodge");
        Activity d2e1 = new Activity("7:00am","Shuttle Leaves Killington Grand Hotel");
        Activity d2e2 = new Activity("7:10am","Shuttle Leaves Pinnacle Condos, Trail Creek Condos (Shuttles will run until 7:50AM)");
        Activity d2e3 = new Activity("7:50am","Last Shuttle Pick-Up to Venues");
        Activity d2e4 = new Activity("7:30 – 8:30am","Breakfast at Pico");
        Activity d2e5 = new Activity("8:00 – 8:30am","Delegation Check-In (late check-ins only) at Pico Ticket Counter");
        Activity d2e6 = new Activity("7:45 – 8:10am","Volunteer Check-in- Pico Ski Club");
        Activity d2e7 = new Activity("8:15am","Shuttle departs Pico for XC Venue");
        Activity d2e8 = new Activity("8:15 – 8:40am","Volunteer Training Alpine/Snowboard – Pico Ski Club (see map) \nCross-Country Skiing- Mountain Meadows XC Center \nSnowshoeing – Start line of snowshoe course (Base of Exhibition)");
        Activity d2e9 = new Activity("(see venue for time)","Coaches Meeting at each venue: \n8:45am\t Cross Country Skiing – @ Finish Line of venue\n 8:45am\t Snowshoeing – @ Finish Line of venue\n 9:00am\t Alpine/Snowboard – @ base of Advanced Alpine Ski venue");
        Activity d2e10 = new Activity("9:15am – 3:00pm","Competition (various): see competition schedule");
        Activity d2e11 = new Activity("9:30am","Alpine/Snowboard athletes meet with Mountain Guides \nMeet at Pico Mountain Map (Site of Opening Ceremonies)");
        Activity d2e12 = new Activity("10:00 – 2:00pm","Olympic Town- Outside Main Lodge");
        Activity d2e13 = new Activity("12:00-1:30pm","Lunch served at Pico Base Lodge (Shuttle will run from XC Venue to Pico for lunch)");
        Activity d2e14 = new Activity("4:00pm (end of day)","Alpine/Snowboard Coaches Meeting @ Main Lodge");
        Activity d2e15 = new Activity("5:45 – 7:00pm","Banquet – Oscar Wilde Ballroom @ Killington Grand Hotel \n(Delegation/Credentialed members only)");
        Activity d2e16 = new Activity("7:00 – 8:30pm","Dance – “GALAXY” – Oscar Wilde Ballroom @ Killington Grand Hotel \n(Family & Friends welcome)");
        Activity d2e17 = new Activity(" ","Shuttle will run between lodging and Killington Grand for arrival to and departure from dinner and dance");
        Activity d3e1 = new Activity("8:00am","Shuttle leaves Killington Grand Hotel");
        Activity d3e2 = new Activity("8:10am","Shuttle leaves Pinnacle Condos, Trail Creek Condos");
        Activity d3e3 = new Activity("8:30 – 9:30am","Breakfast at Pico");
        Activity d3e4 = new Activity("9:15am ","Shuttle leaves Pico for XC Venue");
        Activity d3e5 = new Activity("8:30 – 9:25am","Volunteer Check-in @ Pico Ski Club (Tuesday only volunteers)");
        Activity d3e6 = new Activity("9:00 – 9:25am","Volunteer Training\n" +
                "\tAlpine/Snowboard – Pico Ski Club (see map – pg. 18)\n" +
                "\tCross-Country Skiing- Mountain Meadows XC Center\n" +
                "\tSnowshoeing – Start line of snowshoe course (Base of Exhibition)");
        Activity d3e7 = new Activity("9:30am ","Coaches meetings at each venue:\n" +
                "\tAlpine/Snowboard – @ Finish line of Advanced Alpine Ski venue\n" +
                "\tCross-Country – @ Finish Line of venue\n" +
                "\tSnowshoeing – @ Finish Line of Venue");
        Activity d3e8 = new Activity("9:45am","Alpine/Snowboard athletes meet with Mountain Guides\n" +
                "Meet at Pico Mountain Map (Site of Opening Ceremonies)");
        Activity d3e9 = new Activity("9:45am – 1:00pm","Competition (various): see competition schedule");
        Activity d3e10 = new Activity("10:00am – 12:00pm","Olympic Town- Outside Main Lodge");
        Activity d3e11 = new Activity("11:30 – 1:30pm ","BBQ Lunch – (Delegation/Credentialed members only)\n" +
                "Please remember to thank the Killington Pico Community for their\n" +
                "support!");

        ArrayList<Activity> activityList = new ArrayList<>();
        ArrayList<Activity> activityList2 = new ArrayList<>();
        ArrayList<Activity> activityList3 = new ArrayList<>();

        activityList.add(d1e1);
        activityList.add(d1e2);
        activityList.add(d1e3);
        activityList.add(d1e4);
        activityList2.add(d2e1);
        activityList2.add(d2e2);
        activityList2.add(d2e3);
        activityList2.add(d2e4);
        activityList2.add(d2e5);
        activityList2.add(d2e6);
        activityList2.add(d2e7);
        activityList2.add(d2e8);
        activityList2.add(d2e9);
        activityList2.add(d2e10);
        activityList2.add(d2e11);
        activityList2.add(d2e12);
        activityList2.add(d2e13);
        activityList2.add(d2e14);
        activityList2.add(d2e15);
        activityList2.add(d2e16);
        activityList2.add(d2e17);
        activityList3.add(d3e1);
        activityList3.add(d3e2);
        activityList3.add(d3e3);
        activityList3.add(d3e4);
        activityList3.add(d3e5);
        activityList3.add(d3e6);
        activityList3.add(d3e7);
        activityList3.add(d3e8);
        activityList3.add(d3e9);
        activityList3.add(d3e10);
        activityList3.add(d3e11);

        ActivityListAdapter adapter = new ActivityListAdapter(getActivity(),R.layout.adapter_view_layout,activityList);
        ActivityListAdapter adapter2 = new ActivityListAdapter(getActivity(),R.layout.adapter_view_layout,activityList2);
        ActivityListAdapter adapter3 = new ActivityListAdapter(getActivity(),R.layout.adapter_view_layout,activityList3);

        mListView.setAdapter(adapter);
        mListView2.setAdapter(adapter2);
        mListView3.setAdapter(adapter3);

        ScrollView sv = (ScrollView) view.findViewById(R.id.scrollView);
        sv.smoothScrollTo(0, 0);
        return view;
    }

}
