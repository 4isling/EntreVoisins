package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }


    @Test
    public void a_getFavoriteNeighbourWithSuccess() {
        List<Neighbour> neighbours = service.getFavNeighbour();
        List<Neighbour> expectedFavNeighbours = DummyFavNeighbourGenerator.DUMMY_FAV_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavNeighbours.toArray()));

    }
    @Test
    public void b_getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void c_deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void d_favoriteNeighbourWithSuccess(){
        Neighbour neighbourToFavorite = service.getNeighbours().get(3);
        if(!neighbourToFavorite.isFav())
        service.favNeighbour(neighbourToFavorite);
        assertTrue(service.getFavNeighbour().contains(neighbourToFavorite));
    }

    @Test
    public void e_unFavNeighbourWithSuccess(){
        Neighbour neighbourToUnFav = service.getNeighbours().get(0);
        if(neighbourToUnFav.isFav())
        service.favNeighbour(neighbourToUnFav);
        assertFalse(service.getFavNeighbour().contains(neighbourToUnFav));
    }




}
