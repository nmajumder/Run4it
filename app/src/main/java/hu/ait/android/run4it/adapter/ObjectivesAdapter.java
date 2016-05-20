package hu.ait.android.run4it.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.ait.android.run4it.R;
import hu.ait.android.run4it.data.Objective;

/**
 * Created by Jwatto01 on 5/20/16.
 */
public class ObjectivesAdapter extends RecyclerView.Adapter<ObjectivesAdapter.ViewHolder>
        implements TouchHelperAdapter {

    private Context context;
    private List<Objective> objectives = new ArrayList<>();

    public ObjectivesAdapter(Context context) {
        this.context = context;
        //todo get all objectives from backendless
        //objectives = Objective.listAll(Objective.class);
    }

    @Override
    public ObjectivesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.objective_row, parent, false);

        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(ObjectivesAdapter.ViewHolder holder, int position) {
        holder.cbObjectiveCompleted.setClickable(false);
        String objName = objectives.get(position).getObjectiveName();
        int pointValue = objectives.get(position).getPoints();
        holder.tvObjectiveName.setText(objName);
        holder.tvPoints.setText(String.valueOf(pointValue));
    }

    @Override
    public int getItemCount() {
        return objectives.size();
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(objectives, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(objectives, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {

    }

    public void addObjective(Objective obj) {
        objectives.add(0, obj);
        //obj.save();

        notifyDataSetChanged();
    }
    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbObjectiveCompleted;
        TextView tvObjectiveName;
        TextView tvPoints;

        public ViewHolder(View itemView) {
            super(itemView);

            cbObjectiveCompleted = (CheckBox) itemView.findViewById(R.id.cbObjectiveCompleted);
            tvObjectiveName = (TextView) itemView.findViewById(R.id.tvObjective);
            tvPoints = (TextView) itemView.findViewById(R.id.tvPointValue);
        }
    }

}
