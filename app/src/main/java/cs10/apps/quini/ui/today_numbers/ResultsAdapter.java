package cs10.apps.quini.ui.today_numbers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import cs10.apps.common.NumberFormat;
import cs10.apps.quini.databinding.ContentDayResultsBinding;
import cs10.apps.quini.model.DayResults;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultRowHolder> {
    private final List<DayResults> list = new LinkedList<>();
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public List<DayResults> getList() {
        return list;
    }

    @NonNull @Override
    public ResultRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ContentDayResultsBinding binding = ContentDayResultsBinding.inflate(inflater, parent, false);
        return new ResultRowHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultRowHolder holder, int position) {
        DayResults item = list.get(position);
        TextView[] views = new TextView[]{
                holder.binding.tvRes0, holder.binding.tvRes1, holder.binding.tvRes2,
                holder.binding.tvRes3, holder.binding.tvRes4, holder.binding.tvRes5,
                holder.binding.tvRes6, holder.binding.tvRes7
        };

        for (int i=0; i<8; i++){
            int number = item.get(i);
            if (number == 0) views[i].setText("--");
            else views[i].setText(NumberFormat.fourDecimals(number));
        }

        holder.binding.tvTitle.setText("Día " + item.getDay() + " de junio");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected static class ResultRowHolder extends RecyclerView.ViewHolder {
        protected ContentDayResultsBinding binding;

        public ResultRowHolder(@NonNull ContentDayResultsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
