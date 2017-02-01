package hexa.congressApp.com.congress.fragments.legislators.favourites;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
import hexa.congressApp.com.congress.R;
import hexa.congressApp.com.congress.activities.comm.CommDescriptionsActivity;
import hexa.congressApp.com.congress.adapters.CommAdapter;
import hexa.congressApp.com.congress.model.CommModel;
import hexa.congressApp.com.congress.utils.SharedPreferenceProvider;

public class LegCommFragment extends Fragment {


    ArrayList<CommModel> commModels;
    ListView mListView;
    SpotsDialog dialog;
    String id,name,chamber,commSubComm,parentId,phone,office;
    int count;
    SharedPreferenceProvider sharedPreferenceProvider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_leg_comm, container, false);
        commModels = new ArrayList<>();

        mListView = (ListView) v.findViewById(R.id.listview);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in=new Intent(getActivity(), CommDescriptionsActivity.class);
                in.putExtra("commId",commModels.get(i).getCommId());
                in.putExtra("commName",commModels.get(i).getCommName());
                in.putExtra("commChamber",commModels.get(i).getCommChamber());
                in.putExtra("commSubComm",commModels.get(i).getCommSubComm());
                in.putExtra("commPComm",commModels.get(i).getParentCommId());
                in.putExtra("commPhone",commModels.get(i).getPhone());
                in.putExtra("commOffice",commModels.get(i).getOffice());
                in.putExtra("refresh","fav");

                getActivity().startActivity(in);

            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        sharedPreferenceProvider = new SharedPreferenceProvider();
        String totalC = sharedPreferenceProvider.fatchDataLegislators(getActivity(), "totalCommNumber");
        count = Integer.parseInt(totalC);
        commModels.clear();

        for (int i = 1; i <= count; i++) {
            id=sharedPreferenceProvider.fatchDataLegislators(getActivity(),"commId"+i);
            name=sharedPreferenceProvider.fatchDataLegislators(getActivity(),"commName"+i);
            chamber=sharedPreferenceProvider.fatchDataLegislators(getActivity(),"commChamber"+i);
            commSubComm=sharedPreferenceProvider.fatchDataLegislators(getActivity(),"commSubComm"+i);
            parentId=sharedPreferenceProvider.fatchDataLegislators(getActivity(),"commPComm"+i);
            phone=sharedPreferenceProvider.fatchDataLegislators(getActivity(),"commPhone"+i);
            office=sharedPreferenceProvider.fatchDataLegislators(getActivity(),"commOffice"+i);

            if(!id.equals("0"))
                commModels.add(new CommModel(id,name,chamber,commSubComm,parentId,phone,office));
        }
        CommAdapter adapter = new CommAdapter(getActivity(), commModels);
        mListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mListView.setFastScrollEnabled(true);
    }
}