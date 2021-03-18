package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

/**
 * Event fired when a user Fav a Neighbour
 */
public class FavNeighbourEvent {
    public Neighbour neighbour;
    /**
     * Constructor.
     * @param neighbour
     */
    public FavNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
        DI.getNeighbourApiService().favNeighbour(neighbour);
    }
}
