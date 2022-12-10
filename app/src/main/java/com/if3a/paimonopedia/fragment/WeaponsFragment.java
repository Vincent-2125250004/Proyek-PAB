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

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.adapter.AdapterWeapons;
import com.if3a.paimonopedia.api.APIRequestData;
import com.if3a.paimonopedia.api.RetroServer;
import com.if3a.paimonopedia.models.Weapons;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeaponsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeaponsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rvWeapons;
    private List<Weapons> listWeapons;
    private AdapterWeapons adapterWeapons;
    private LinearLayoutManager linearLayoutManager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeaponsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeaponsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeaponsFragment newInstance(String param1, String param2) {
        WeaponsFragment fragment = new WeaponsFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvWeapons = getView().findViewById(R.id.rv_Weapons);

        linearLayoutManager = new LinearLayoutManager(getActivity());

        rvWeapons.setLayoutManager(linearLayoutManager);

        retrieveWeap();
    }

    private void retrieveWeap() {
        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<Weapons>> retrieveProcess = ardData.getWeapons();
        retrieveProcess.enqueue(new Callback<List<Weapons>>() {
            @Override
            public void onResponse(Call<List<Weapons>> call, Response<List<Weapons>> response) {
                listWeapons =response.body();
                adapterWeapons = new AdapterWeapons(listWeapons);
                rvWeapons.setAdapter(adapterWeapons);
            }

            @Override
            public void onFailure(Call<List<Weapons>> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weapons, container, false);
    }
}