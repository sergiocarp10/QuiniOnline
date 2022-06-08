package cs10.apps.quini.ui.today_numbers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Random;

import cs10.apps.common.CS_Fragment;
import cs10.apps.quini.databinding.FragmentTodayNumbersBinding;
import cs10.apps.quini.model.DayResults;

public class TodayNumbersFragment extends CS_Fragment {
    private FragmentTodayNumbersBinding binding;
    private ResultsAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTodayNumbersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recycler.setVisibility(View.GONE);
        binding.pb.setVisibility(View.VISIBLE);

        adapter = new ResultsAdapter();
        adapter.setContext(getContext());
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        doInBackground(() -> {
            Random random = new Random();

            // TODAY
            DayResults results = new DayResults();
            for (int j=0; j<6; j++) results.set(random.nextInt(10000), j);
            results.setDay(8);
            adapter.getList().add(results);

            // PREVIOUS
            for (int i=0; i<7; i++){
                results = new DayResults();
                for (int j=0; j<8; j++) results.set(random.nextInt(10000), j);
                results.setDay(7-i);
                adapter.getList().add(results);
            }

            try {
                Thread.sleep(700);
            } catch (Exception e){
                e.printStackTrace();
            }

            doInForeground(() -> {
                binding.recycler.setVisibility(View.VISIBLE);
                binding.pb.setVisibility(View.GONE);
                adapter.notifyItemRangeInserted(0,8);
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}