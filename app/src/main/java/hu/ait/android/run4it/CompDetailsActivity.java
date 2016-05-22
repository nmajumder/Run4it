package hu.ait.android.run4it;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;

import hu.ait.android.run4it.data.Competition;

public class CompDetailsActivity extends AppCompatActivity {

    public static final String KEY_COMP_NAME = "competitionNameKey";
    public static final String KEY_COMP_DESCRIP = "competitionDescripKey";
    public static final String KEY_COMP_BUYIN = "competitionBuyinKey";
    public static final String KEY_COMP_WINNINGS1 = "competitionWinnings1Key";
    public static final String KEY_COMP_WINNINGS2 = "competitionWinnings2Key";
    public static final String KEY_COMP_WINNINGS3 = "competitionWinnings3Key";
    public static final String KEY_COMP_BEGIN_DATE = "competitionBeginDateKey";
    public static final String KEY_COMP_END_DATE = "competitionEndDateKey";

    TextView tvName;
    TextView tvDescrip;
    Button btnBack;
    TextView tvBuyin;
    TextView tvFirst;
    TextView tvSecond;
    TextView tvThird;
    TextView tvDateBegin;
    TextView tvDateEnd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_details);

        tvName = (TextView) findViewById(R.id.tvCompTitle);
        tvDescrip = (TextView) findViewById(R.id.tvCompDescription);
        btnBack = (Button) findViewById(R.id.btnCompBack);
        tvBuyin = (TextView) findViewById(R.id.tvBuyIn);
        tvFirst = (TextView) findViewById(R.id.tv1stPlace);
        tvSecond = (TextView) findViewById(R.id.tv2ndPlace);
        tvThird = (TextView) findViewById(R.id.tv3rdPlace);
        tvDateBegin = (TextView) findViewById(R.id.tvCompBeginDate);
        tvDateEnd = (TextView) findViewById(R.id.tvCompEndDate);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvName.setText(getIntent().getStringExtra(KEY_COMP_NAME));
        tvDescrip.setText(getIntent().getStringExtra(KEY_COMP_DESCRIP));
        tvBuyin.setText(String.valueOf(getIntent().getIntExtra(KEY_COMP_BUYIN, -1)));
        tvFirst.setText(String.valueOf(getIntent().getIntExtra(KEY_COMP_WINNINGS1, -1)));
        tvSecond.setText(String.valueOf(getIntent().getIntExtra(KEY_COMP_WINNINGS2, -1)));
        tvThird.setText(String.valueOf(getIntent().getIntExtra(KEY_COMP_WINNINGS3, -1)));
        tvDateBegin.setText(getIntent().getStringExtra(KEY_COMP_BEGIN_DATE));
        tvDateEnd.setText(getIntent().getStringExtra(KEY_COMP_END_DATE));
    }

}
