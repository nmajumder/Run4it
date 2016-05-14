package hu.ait.android.run4it.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.ait.android.run4it.R;
import hu.ait.android.run4it.data.Goal;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ViewHolder>
        implements TouchHelperAdapter {

    private Context context;
    private List<Goal> goals = new ArrayList<>();

    public GoalAdapter(Context context) {
        this.context = context;

        goals = Goal.listAll(Goal.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goal_row, parent, false);

        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.cbCompleted.setClickable(false);
        String timeString;
        String goalString;
        int num = goals.get(position).getNumber();
        int tnum = goals.get(position).getTimeNumber();
        switch(goals.get(position).getTp()) {
            case DAILY: if (tnum == 1) {timeString = "day";} else {timeString = "days";} break;
            case WEEKLY: if (tnum == 1) {timeString = "week";} else {timeString = "weeks";} break;
            case MONTHLY: if (tnum == 1) {timeString = "month";} else {timeString = "months";} break;
            default: timeString = ""; break;
        }
        switch (goals.get(position).getM()) {
            case MILES:
                if (num == 1) {
                    goalString = "Run 1 mile in "+tnum+" "+timeString;
                } else {
                    goalString = "Run "+num+" miles in "+tnum+" "+timeString;
                }
                break;
            case CALORIES:
                if (num == 1) {
                    goalString = "Burn 1 calorie in "+tnum+" "+timeString;
                } else {
                    goalString = "Burn "+num+" calories in "+tnum+" "+timeString;
                }
                break;
            default:
                goalString = "";
        }
        holder.tvGoal.setText(goalString);

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeGoal(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return goals.size();
    }

    public void addGoal(Goal goal) {
        goals.add(0, goal);
        goal.save();

        notifyDataSetChanged();
    }

    public void removeGoal(int position) {
        Goal.delete(goals.get(position));
        goals.remove(position);

        notifyDataSetChanged();
    }

    public void removeAllGoals() {
        for (Goal goal : goals) {
            Goal.delete(goal);
        }
        goals.clear();

        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onItemDismiss(int position) {
        Goal.delete(goals.get(position));
        goals.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(goals, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(goals, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbCompleted;
        TextView tvGoal;
        Button btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);

            cbCompleted = (CheckBox) itemView.findViewById(R.id.cbGoalCompleted);
            tvGoal = (TextView) itemView.findViewById(R.id.tvGoal);
            btnDelete = (Button) itemView.findViewById(R.id.btnDeleteGoal);
        }
    }

}
