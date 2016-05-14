package hu.ait.android.run4it.fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.ait.android.run4it.AddGoalActivity;
import hu.ait.android.run4it.ProfileActivity;
import hu.ait.android.run4it.R;
import hu.ait.android.run4it.adapter.GoalAdapter;
import hu.ait.android.run4it.adapter.TouchHelperCallback;
import hu.ait.android.run4it.data.Goal;
import hu.ait.android.run4it.data.TimePeriod;
import hu.ait.android.run4it.data.WorkoutMeasure;


public class ProfGoalsFragment extends Fragment {

    public static final int ADD_GOAL_CODE = 0;

    GoalAdapter goalRecyclerAdapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prof_goals, null);

        goalRecyclerAdapter = new GoalAdapter(getContext());
        recyclerView = (RecyclerView) rootView.findViewById(R.id.goalsRecyclerView);
        recyclerView.setHasFixedSize(true);
        // RecyclerView layout manager
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(goalRecyclerAdapter);

        ItemTouchHelper.Callback callback = new TouchHelperCallback(goalRecyclerAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabAddGoal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call add city dialog function
                Intent addGoalIntent = new Intent(getContext(), AddGoalActivity.class);
                startActivityForResult(addGoalIntent,ADD_GOAL_CODE);
            }
        });

        goalRecyclerAdapter.removeAllGoals();

        return rootView;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_GOAL_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                // extract data
                int num = data.getIntExtra(AddGoalActivity.KEY_NUM_UNITS,0);
                int time = data.getIntExtra(AddGoalActivity.KEY_TIME,0);
                int typeIndex = data.getIntExtra(AddGoalActivity.KEY_TYPE_IND,0);
                int timeIndex = data.getIntExtra(AddGoalActivity.KEY_TIME_IND,0);

                TimePeriod t;
                WorkoutMeasure m;
                switch (timeIndex) {
                    case 0: t = TimePeriod.DAILY; break;
                    case 1: t = TimePeriod.WEEKLY; break;
                    case 2: t = TimePeriod.MONTHLY; break;
                    default: t = null; break;
                }
                switch (typeIndex) {
                    case 0: m = WorkoutMeasure.MILES; break;
                    case 1: m = WorkoutMeasure.CALORIES; break;
                    default: m = null; break;
                }

                Goal newGoal = new Goal(m,t,num,time);
                goalRecyclerAdapter.addGoal(newGoal);
            }
        }
    }
}
