
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private int
    private ListNeighbourActivity mActivity;


    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_neighbours),isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_neighbours),isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(withItemCount(ITEMS_COUNT-1));
    }


    /**
     * When user click on a Neighbour, in listNeighbourActivity open the profile activity
     *
     */
    @Test
    public void myNeighbourList_FragmentClick_displayProfile_activity(){
        // Given : Click on a neighbour fragment
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        // Then : Go on the profileActivity
        onView(allOf(withId(R.id.ProfileActivity),isDisplayed())).check(matches(isDisplayed()));
    }

    /**
     * When user click on the neighbour, give the good neighbour
     *
     */
    @Test
    public void profileActivity_load_the_selected_Neighbour(){
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.profileName),isDisplayed())).check(matches(withText("Caroline")));
    }

    /**
     * when user click on favlist neighours the list of neighbour should return the fav neighbour list
     */
    @Test
    public void myFavNeighbourList_displayOnly_FavNeighbour(){
        onView(withId(R.id.main_content));
        onView(withId(R.id.favNeighbourTab)).perform(click());
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(withItemCount())
    }

}