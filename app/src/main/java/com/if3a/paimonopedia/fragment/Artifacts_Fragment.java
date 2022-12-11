package com.if3a.paimonopedia.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.adapter.AdapterArtifacts;
import com.if3a.paimonopedia.api.APIRequestData;
import com.if3a.paimonopedia.api.RetroServer;
import com.if3a.paimonopedia.models.Artifacts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Artifacts_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Artifacts_Fragment extends Fragment {

    private RecyclerView rvArtifacts;
    private ProgressBar pbArtifacts;
    private RecyclerView.Adapter AdapArtifacts;
    private  RecyclerView.LayoutManager LMArtifacts;
    private List<Artifacts> listArtifacts = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Artifacts_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Artifacts_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Artifacts_Fragment newInstance(String param1, String param2) {
        Artifacts_Fragment fragment = new Artifacts_Fragment();
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
        return inflater.inflate(R.layout.fragment_artifacts_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvArtifacts = view.findViewById(R.id.rv_artifacts);
        pbArtifacts = view.findViewById(R.id.pbArtifacts);

        LMArtifacts = new LinearLayoutManager(getView().getContext(),LinearLayoutManager.VERTICAL, false);
        rvArtifacts.setLayoutManager(LMArtifacts);
    }

    public void retrieveArtifacts (){
        pbArtifacts.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<Artifacts>> process = ardData.getArtifacts();

        process.enqueue(new Callback<List<Artifacts>>() {
            @Override
            public void onResponse(Call<List<Artifacts>> call, Response<List<Artifacts>> response) {
                listArtifacts = response.body();
                AdapArtifacts = new AdapterArtifacts(getView().getContext(),listArtifacts);
                rvArtifacts.setAdapter(AdapArtifacts);
                pbArtifacts.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Artifacts>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveArtifacts();
    }
}