package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.secondapp.Constant;
import com.hmkcode.android.another.app.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
this is the main activity which will be opened when u click from other app.


 */

public class DropdownFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public DropdownFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DropdownFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DropdownFragment newInstance(String param1, String param2) {
        DropdownFragment fragment = new DropdownFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    private void initializeSpinner(View view) {
        // Spinner element

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position > 0){
                    Map<Integer, String> constantsMap = Constant.aMap;
                    String value = constantsMap.get(position);
                    Toast.makeText(getActivity(), "value is : " + value, Toast.LENGTH_SHORT).show();

                    Bundle args = new Bundle();
                    args.putString("websiteUrl",value);
                    WebViewFragment newFragment = new WebViewFragment();
                    newFragment.setArguments(args);

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_out_right,
                                    R.anim.slide_out_right, 0, 0)
                            .replace(R.id.frameId, newFragment).commit();


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add("Please select the place");
        categories.add("google");
        categories.add("apple");
        categories.add("flipkart");
        categories.add("amazon");
        categories.add("bluestone");
        categories.add("bluestone");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dropdown, container, false);
        initializeSpinner(view);
        return view;
    }


}
