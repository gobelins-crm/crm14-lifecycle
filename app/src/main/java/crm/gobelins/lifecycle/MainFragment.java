package crm.gobelins.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainFragment extends Fragment implements View.OnClickListener {

    private static final String ARGS_DEFAULT_TEXT = "DefaultText";
    private OnFragmentInteractionListener mListener;
    private String mDefaultText;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String aDefault) {
        MainFragment instance = new MainFragment();
        Bundle args = new Bundle();

        args.putString(ARGS_DEFAULT_TEXT, aDefault);
        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (null != getArguments()) {
            mDefaultText = getArguments().getString(ARGS_DEFAULT_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);
        ((EditText) view.findViewById(R.id.edit_text)).setText(mDefaultText);
        view.findViewById(R.id.launch_activity_button).setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (null != mListener) {
            mListener.onClick();
        }
    }

    public interface OnFragmentInteractionListener {
        public void onClick();
    }

}
