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
import hu.ait.android.run4it.data.Competition;

/**
 * Created by Jwatto01 on 5/20/16.
 */
public class CompetitionAdapter extends RecyclerView.Adapter<CompetitionAdapter.ViewHolder>
        implements TouchHelperAdapter{

    private Context context;
    private List<Competition> comps = new ArrayList<>();

    public CompetitionAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CompetitionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.competition_row, parent, false);

        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(CompetitionAdapter.ViewHolder holder, int position) {
        holder.tvBuyin.setText(String.valueOf(comps.get(position).getBuyin()));
        holder.compName.setText(comps.get(position).getCompName());
        holder.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo incremement users entered, switch button to withdraw, and upadate competitor list
            }
        });
    }

    @Override
    public int getItemCount() {
        return comps.size();
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(comps, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(comps, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {

    }

    public void addComp(Competition obj) {
        comps.add(0, obj);
        //obj.save();

        notifyDataSetChanged();
    }
    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBuyin;
        TextView compName;
        Button btnEnter;
        public ViewHolder(View itemView) {
            super(itemView);


            tvBuyin = (TextView) itemView.findViewById(R.id.tvBuyIn);
            compName = (TextView) itemView.findViewById(R.id.tvCompName);
            btnEnter = (Button) itemView.findViewById(R.id.btnEnter);
        }
    }
}
