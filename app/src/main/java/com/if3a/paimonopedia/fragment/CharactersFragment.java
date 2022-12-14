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
import android.widget.Toast;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.adapter.AdapterCharacters;
import com.if3a.paimonopedia.api.APIRequestData;
import com.if3a.paimonopedia.api.RetroServer;
import com.if3a.paimonopedia.models.Characters;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharactersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharactersFragment extends Fragment {

    private RecyclerView rvChara;
    private RecyclerView.Adapter adChara;
    private RecyclerView.LayoutManager lmChara;
    private List<Characters> listChara = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CharactersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharactersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharactersFragment newInstance(String param1, String param2) {
        CharactersFragment fragment = new CharactersFragment();
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

        rvChara = view.findViewById(R.id.rv_Characters);

        lmChara = new LinearLayoutManager(getView().getContext(), LinearLayoutManager.VERTICAL, false);
        rvChara.setLayoutManager(lmChara);
    }

    private void retrieveChara() {
        APIRequestData API = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<Characters>> proses = API.getCharacters();

        proses.enqueue(new Callback<List<Characters>>() {
            @Override
            public void onResponse(Call<List<Characters>> call, Response<List<Characters>> response) {

                listChara = response.body();

//                Toast.makeText(getView().getContext(), "Response : " + listChara, Toast.LENGTH_SHORT).show();

                adChara = new AdapterCharacters(listChara);
                rvChara.setAdapter(adChara);

            }

            @Override
            public void onFailure(Call<List<Characters>> call, Throwable t) {
                Toast.makeText(getView().getContext(), "Gagal menghubungi server : " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveChara();
    }
}