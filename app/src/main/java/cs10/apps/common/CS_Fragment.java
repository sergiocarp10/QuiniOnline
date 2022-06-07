package cs10.apps.common;

import androidx.fragment.app.Fragment;

public class CS_Fragment extends Fragment {

    void doInForeground(Runnable r){
        if (getActivity() != null) getActivity().runOnUiThread(r);
    }

    void doInBackground(Runnable r){
        new Thread(r).start();
    }
}
