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

/**
 * Created by nathanmajumder on 5/12/16.
 */
public class ProfStatsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prof_stats, null);

        final Button btnDaily = (Button) rootView.findViewById(R.id.btnDailyStats);
        final Button btnWeekly = (Button) rootView.findViewById(R.id.btnWeeklyStats);
        final Button btnMonthly = (Button) rootView.findViewById(R.id.btnMonthlyStats);
        final TextView tvHeader = (TextView) rootView.findViewById(R.id.tvHeader);
        TextView tvCalsBurned = (TextView) rootView.findViewById(R.id.tvCalsBurned);
        TextView tvMilesRun = (TextView) rootView.findViewById(R.id.tvMilesRun);
        TextView tvObjectivesComplete = (TextView) rootView.findViewById(R.id.tvObjectivesCompleted);
        TextView tvPointsEarned = (TextView) rootView.findViewById(R.id.tvPointsEarned);

        btnDaily.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvHeader.setText("Stats for today");
                btnDaily.setBackground(getResources().getDrawable(R.drawable.my_button_bg_selected));
                btnWeekly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
                btnMonthly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));

            }
        });
        btnWeekly.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvHeader.setText("Stats for past 7 days");
                btnDaily.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
                btnWeekly.setBackground(getResources().getDrawable(R.drawable.my_button_bg_selected));
                btnMonthly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
            }
        });
        btnMonthly.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvHeader.setText("Stats for this Month");
                btnDaily.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
                btnWeekly.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
                btnMonthly.setBackground(getResources().getDrawable(R.drawable.my_button_bg_selected));
            }
        });

        return rootView;
    }
}
