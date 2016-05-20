package hu.ait.android.run4it;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.BackendlessCallback;

import java.util.Iterator;

import hu.ait.android.run4it.adapter.ObjectivesAdapter;
import hu.ait.android.run4it.adapter.TouchHelperCallback;
import hu.ait.android.run4it.data.Objective;

public class ObjectivesActivity extends BaseActivity {
    TextView top;
    ObjectivesAdapter objectRecyclerAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectives);

        top = (TextView) findViewById(R.id.tvTop);
        //comment change

        objectRecyclerAdapter = new ObjectivesAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.objectivesRecyclerView);
        recyclerView.setHasFixedSize(true);
        // RecyclerView layout manager
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(objectRecyclerAdapter);

        ItemTouchHelper.Callback callback = new TouchHelperCallback(objectRecyclerAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        Backendless.Persistence.of(Objective.class).find(new BackendlessCallback<BackendlessCollection<Objective>>() {
            @Override
            public void handleResponse(BackendlessCollection<Objective> response) {
                Iterator<Objective> objIterator = response.getCurrentPage().iterator();
                while (objIterator.hasNext()){
                    Objective obj = objIterator.next();
                    objectRecyclerAdapter.addObjective(obj);
                }
            }
        });

    }
}
