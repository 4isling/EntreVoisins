package com.openclassrooms.entrevoisins.ui.neighbour_list;

import org.greenrobot.eventbus.EventBus;

public class NeighbourFragment extends BaseFragment {


    public NeighbourFragment(){
    }
    public static NeighbourFragment newInstance(){
        NeighbourFragment fragment = new NeighbourFragment();
        return fragment;
    }

    @Override
    protected void initList() {
        mNeighbours = mApiService.getNeighbours();
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighbours));
    }
}
//notify data set change