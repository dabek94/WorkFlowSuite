package me.bdabrowski.wfs.view.fragments.menu.employee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.bdabrowski.wfs.R;
import me.bdabrowski.wfs.service.model.Company;
import me.bdabrowski.wfs.view.activity.MainActivity;
import me.bdabrowski.wfs.viewmodel.CompanyViewModel;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Company.JobOpenings> jobOpenings;


    public JobAdapter(Context context, List<Company.JobOpenings> jobOpenings){
        this.layoutInflater = LayoutInflater.from(context);
        this.jobOpenings = jobOpenings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_cardview_job,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String jobPosition = jobOpenings.get(position).getPosition();
        String description = jobOpenings.get(position).getShortDescription();
        holder.jobPosition.setText(jobPosition);
        holder.jobDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return jobOpenings.size();
    }

    public void setItems(List<Company.JobOpenings> jobs){
        this.jobOpenings = jobs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView jobPosition, jobDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jobPosition = itemView.findViewById(R.id.job_position);
            jobDescription = itemView.findViewById(R.id.job_description);
        }
    }
}
