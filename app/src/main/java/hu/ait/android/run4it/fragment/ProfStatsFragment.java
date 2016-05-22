package hu.ait.android.run4it.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hu.ait.android.run4it.R;

public class ProfStatsFragment extends Fragment {

    Button btnDaily;
    Button btnWeekly;
    Button btnMonthly;
    TextView tvHeader;
    TextView tvCalsBurned;
    TextView tvMilesRun;
    TextView tvObjectivesComplete;
    TextView tvPointsEarned;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prof_stats, null);

        btnDaily = (Button) rootView.findViewById(R.id.btnDailyStats);
        btnWeekly = (Button) rootView.findViewById(R.id.btnWeeklyStats);
        btnMonthly = (Button) rootView.findViewById(R.id.btnMonthlyStats);
        tvHeader = (TextView) rootView.findViewById(R.id.tvHeader);
        tvCalsBurned = (TextView) rootView.findViewById(R.id.tvCalsBurned);
        tvMilesRun = (TextView) rootView.findViewById(R.id.tvMilesRun);
        tvObjectivesComplete = (TextView) rootView.findViewById(R.id.tvObjectivesCompleted);
        tvPointsEarned = (TextView) rootView.findViewById(R.id.tvPointsEarned);

        setDaily();

        btnDaily.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setDaily();

            }
        });
        btnWeekly.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setWeekly();
            }
        });
        btnMonthly.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setMonthly();
            }
        });

        return rootView;
    }

    private void setDaily() {
        tvHeader.setText("Stats for today");
        btnDaily.setBackground(getResources().getDrawable(R.drawable.my_button_bg_selected));
        btnWeekly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
        btnMonthly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
        tvCalsBurned.setText("800 Calories");
        tvMilesRun.setText("2 Miles");
        tvObjectivesComplete.setText("0 Objectives");
        tvPointsEarned.setText("200 Points");
    }

    private void setWeekly() {
        tvHeader.setText("Stats for past 7 days");
        btnDaily.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
        btnWeekly.setBackground(getResources().getDrawable(R.drawable.my_button_bg_selected));
        btnMonthly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
        tvCalsBurned.setText("4100 Calories");
        tvMilesRun.setText("9 Miles");
        tvObjectivesComplete.setText("0 Objectives");
        tvPointsEarned.setText("450 Points");
    }

    private void setMonthly() {
        tvHeader.setText("Stats for this Month");
        btnDaily.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
        btnWeekly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
        btnMonthly.setBackground(getResources().getDrawable(R.drawable.my_button_bg_selected));
        tvCalsBurned.setText("13900 Calories");
        tvMilesRun.setText("24 Miles");
        tvObjectivesComplete.setText("2 Objectives");
        tvPointsEarned.setText("3150 Points");
    }


}
