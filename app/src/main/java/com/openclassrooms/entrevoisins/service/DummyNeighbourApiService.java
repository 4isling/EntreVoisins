package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.model.NeighbourProfil;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void favNeighbour(Neighbour neighbour)
    {
       neighbours.get(neighbours.indexOf(neighbour)).setFav(!neighbour.isFav());
    }


    // return list of fav neighbour via foreach
    @Override
    public List<Neighbour> getFavNeighbour() {
        List<Neighbour> favNeighbour = new ArrayList<Neighbour>();
        for (Neighbour n : neighbours) {
            if (n.isFav()) {
                favNeighbour.add(n);
            }
        }
        return favNeighbour;
    }
}
