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
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.ait.android.run4it.CompDetailsActivity;
import hu.ait.android.run4it.R;
import hu.ait.android.run4it.data.Competition;

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
    public void onBindViewHolder(final CompetitionAdapter.ViewHolder holder, final int position) {
        holder.compName.setText(comps.get(position).getCompName());
        if (comps.get(position).isEntered()) {
            holder.btnEnter.setText("Withdraw");
            holder.btnEnter.setBackgroundResource(R.drawable.withdraw_button_border);
            holder.btnEnter.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.btnEnter.setText("Enter");
            holder.btnEnter.setBackgroundResource(R.drawable.enter_button_border);
            holder.btnEnter.setTextColor(Color.parseColor("#616161"));
        }
        holder.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo incremement users entered, switch button to withdraw, and update competitor list
                if (!(comps.get(position).isEntered())) {
                    comps.get(position).setEntered(true);
                    holder.btnEnter.setText("Withdraw");
                    holder.btnEnter.setBackgroundResource(R.drawable.withdraw_button_border);
                    holder.btnEnter.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    comps.get(position).setEntered(false);
                    holder.btnEnter.setText("Enter");
                    holder.btnEnter.setBackgroundResource(R.drawable.enter_button_border);
                    holder.btnEnter.setTextColor(Color.parseColor("#616161"));
                }
            }
        });
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo show details fragment
                Competition comp = comps.get(position);
                Intent showDetailsIntent = new Intent(context, CompDetailsActivity.class);

                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_NAME, comp.getCompName());
                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_DESCRIP, comp.getDescription());
                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_BUYIN, comp.getBuyin());
                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_WINNINGS1, comp.getWinnings1st());
                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_WINNINGS2, comp.getWinnings2nd());
                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_WINNINGS3, comp.getWinnings3rd());

                String beginDate = comp.getBegin().toString();
                String endDate = comp.getEnd().toString();
                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_BEGIN_DATE, beginDate);
                showDetailsIntent.putExtra(CompDetailsActivity.KEY_COMP_END_DATE, endDate);
                context.startActivity(showDetailsIntent);
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
        TextView compName;
        Button btnEnter;
        Button btnDetails;
        public ViewHolder(View itemView) {
            super(itemView);
            compName = (TextView) itemView.findViewById(R.id.tvCompName);
            btnDetails = (Button) itemView.findViewById(R.id.btnCompInfo);
            btnEnter = (Button) itemView.findViewById(R.id.btnCompEnter);
        }
    }
}
