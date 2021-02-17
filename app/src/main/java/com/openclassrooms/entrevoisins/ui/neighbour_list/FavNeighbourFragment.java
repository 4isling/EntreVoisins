package com.openclassrooms.entrevoisins.ui.neighbour_list;

import org.greenrobot.eventbus.EventBus;

/**
 * A fragment representing a list of Items.
 */
public class FavNeighbourFragment extends BaseFragment {

    private boolean isFavorite;


    public FavNeighbourFragment() {
    }


    public static FavNeighbourFragment newInstance() {
        FavNeighbourFragment fragment = new FavNeighbourFragment();
        return fragment;
    }


    @Override
    protected void initList() {
        mNeighbours = mApiService.getFavNeighbour();
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighbours));
        }
}
