package com.openclassrooms.entrevoisins.model;

import android.support.test.rule.ActivityTestRule;

import com.openclassrooms.entrevoisins.ui.neighbour_profile.NeighbourProfil;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class NeighbourProfilTest extends TestCase {

    private NeighbourProfil mActivity;
    private Neighbour mNeighbour;
    

    @Rule
    ActivityTestRule<NeighbourProfil> mActivityRule =
            new ActivityTestRule(NeighbourProfil.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }
}