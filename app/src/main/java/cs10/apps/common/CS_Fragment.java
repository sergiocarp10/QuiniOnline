package cs10.apps.common;

import androidx.fragment.app.Fragment;

public class CS_Fragment extends Fragment {

    public void doInForeground(Runnable r){
        if (getActivity() != null) getActivity().runOnUiThread(r);
    }

    public void doInBackground(Runnable r){
        new Thread(r).start();
    }
}
