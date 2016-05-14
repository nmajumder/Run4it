package hu.ait.android.run4it;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import hu.ait.android.run4it.data.Goal;
import hu.ait.android.run4it.data.TimePeriod;
import hu.ait.android.run4it.data.WorkoutMeasure;

public class AddGoalActivity extends AppCompatActivity {

    public static final String KEY_NUM_UNITS = "goalUnits";
    public static final String KEY_TIME = "goalTime";
    public static final String KEY_TYPE_IND = "goalWorkoutMeasure";
    public static final String KEY_TIME_IND = "goalTimeMeasure";

    Button btnCancel;
    Button btnSave;
    EditText etGoalNumber;
    EditText etGoalTimeNumber;
    Spinner typeSpinner;
    Spinner timeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        etGoalNumber = (EditText) findViewById(R.id.etGoalNumber);
        etGoalTimeNumber = (EditText) findViewById(R.id.etTimeNumber);

        typeSpinner = (Spinner) findViewById(R.id.spinnerWorkoutType);
        ArrayAdapter<CharSequence> typeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.workout_measure_array, android.R.layout.simple_spinner_item);
        typeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeSpinnerAdapter);

        timeSpinner = (Spinner) findViewById(R.id.spinnerTimeFrame);
        ArrayAdapter<CharSequence> timeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.time_frame_array, android.R.layout.simple_spinner_item);
        timeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeSpinnerAdapter);

        btnCancel = (Button) findViewById(R.id.btnCancelGoal);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, resultIntent);
                finish();
            }
        });
        btnSave = (Button) findViewById(R.id.btnSaveGoal);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etGoalNumber.getText().toString().trim().length() == 0) {
                    etGoalNumber.setError("Must provide a number for this goal");
                    return;
                } else if (etGoalTimeNumber.getText().toString().trim().length() == 0) {
                    etGoalTimeNumber.setError("Must provide a time frame for this goal");
                    return;
                } else if (typeSpinner.getSelectedItem() == null) {
                    return;
                } else if (timeSpinner.getSelectedItem() == null) {
                    return;
                }

                int time = Integer.parseInt(etGoalTimeNumber.getText().toString());
                int numUnits = Integer.parseInt(etGoalNumber.getText().toString());
                int typeIndex = typeSpinner.getSelectedItemPosition();
                int timeIndex = timeSpinner.getSelectedItemPosition();

                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_NUM_UNITS,numUnits);
                resultIntent.putExtra(KEY_TIME,time);
                resultIntent.putExtra(KEY_TYPE_IND,typeIndex);
                resultIntent.putExtra(KEY_TIME_IND,timeIndex);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();

            }
        });

    }
}
