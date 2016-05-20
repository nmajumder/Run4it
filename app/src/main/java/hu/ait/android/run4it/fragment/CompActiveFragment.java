package hu.ait.android.run4it.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.BackendlessCallback;

import java.util.Iterator;

import hu.ait.android.run4it.R;
import hu.ait.android.run4it.adapter.CompetitionAdapter;
import hu.ait.android.run4it.adapter.TouchHelperCallback;
import hu.ait.android.run4it.data.Competition;

/**
 * Created by nathanmajumder on 5/12/16.
 */
public class CompActiveFragment extends Fragment {

    CompetitionAdapter compRecyclerAdapter;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comp_active, null);

        compRecyclerAdapter = new CompetitionAdapter(getContext());
        recyclerView = (RecyclerView) rootView.findViewById(R.id.competitionsRecyclerView);
        recyclerView.setHasFixedSize(true);
        // RecyclerView layout manager
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(compRecyclerAdapter);

        ItemTouchHelper.Callback callback = new TouchHelperCallback(compRecyclerAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        Backendless.Persistence.of(Competition.class).find(new BackendlessCallback<BackendlessCollection<Competition>>() {
            @Override
            public void handleResponse(BackendlessCollection<Competition> response) {
                Iterator<Competition> objIterator = response.getCurrentPage().iterator();
                while (objIterator.hasNext()){
                    Competition obj = objIterator.next();
                    compRecyclerAdapter.addComp(obj);
                }
            }
        });


        return rootView;
    }
}
