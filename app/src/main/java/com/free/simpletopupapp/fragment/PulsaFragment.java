package com.free.simpletopupapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.free.simpletopupapp.R;
import com.free.simpletopupapp.adapter.PromoAdapter;
import com.free.simpletopupapp.utils.PromoModel;
import com.free.simpletopupapp.view.CustomListPulsa;
import com.free.simpletopupapp.view.StartSnapHelper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PulsaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PulsaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PulsaFragment extends Fragment {

    @Bind(R.id.edtPhone)
    EditText edtPhone;

    @Bind(R.id.listpulsa)
    ListView listpulsa;

    @Bind(R.id.recycler)
    RecyclerView recyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String TAG = PulsaFragment.class.getSimpleName();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Integer[] nominal= {
            25000,
            50000,
            100000,
            150000,
            200000
    };

    private String[] nominals= {
            "25000",
            "50000",
            "100000",
            "150000",
            "200000"
    };

    private Integer[] harga= {
            25000,
            50000,
            100000,
            150000,
            195000
    };

    private int[] myImageList =
            new int[]{R.drawable.kredivo_xl,
                    R.drawable.kredivo_indosat,
                    R.drawable.kredivo_sepulsa,
                    R.drawable.kredivo_telkomsel};
    private ArrayList<PromoModel> imageModelArrayList;
    private PromoAdapter adapter;

    public PulsaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PulsaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PulsaFragment newInstance(String param1, String param2) {
        PulsaFragment fragment = new PulsaFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pulsa, container, false);
        ButterKnife.bind(this, view);
        //return inflater.inflate(R.layout.fragment_pulsa, container, false);
        editPhoneTextChangeListener();
        showRecyclerView();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private ArrayList<PromoModel> getPromo(){

        ArrayList<PromoModel> list = new ArrayList<>();

        for(int i = 0; i < myImageList.length; i++){
            PromoModel promoModel = new PromoModel();
            promoModel.setImage_drawable(myImageList[i]);
            list.add(promoModel);
        }

        return list;
    }

    private void showRecyclerView(){
        imageModelArrayList = getPromo();
        adapter = new PromoAdapter(getActivity(), imageModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerView);
    }

    private void editPhoneTextChangeListener(){
        edtPhone.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length()>0){
                    Log.d(TAG,"Masuk on Text Change");
                    edtPhone.setCompoundDrawablesWithIntrinsicBounds(null, null,
                            ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.baseline_clear_black_18), null);
                    edtPhoneOnTouch();
                    if(s.length()>=4){
                        Log.d(TAG,"nominal.length: "+nominal.length);
                        Log.d(TAG,"harga.length: "+harga.length);
                        CustomListPulsa customListPulsa = new CustomListPulsa(getActivity(),nominal,harga);
                        Log.d(TAG,"Masuk CustomListPulsa Adapter set");
                        listpulsa.setAdapter(customListPulsa);
                        /*ArrayAdapter<String> adapterNominal = new ArrayAdapter<String>(getActivity(),
                                android.R.layout.simple_spinner_item, nominals);
                        listpulsa.setAdapter(adapterNominal);*/
                    }
                    else {
                        listpulsa.setAdapter(null);
                    }
                }
                else {
                    listpulsa.setAdapter(null);
                    edtPhone.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                }
            }
        });
    }

    private void edtPhoneOnTouch(){
        edtPhone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(edtPhone.getCompoundDrawables()[DRAWABLE_RIGHT]!=null){
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        if(event.getRawX() >= (edtPhone.getRight() -
                                edtPhone.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                            // your action here
                            edtPhone.setText("");
                            return true;
                        }
                    }
                }

                return false;
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
