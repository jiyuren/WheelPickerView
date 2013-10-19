/*
 * RoundPickerAdapterTest.java
 * Creation at : 17 oct. 2013 23:38:46
*/
package org.roundpicker.adapter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.roundpicker.MainActivity;
import org.roundpicker.R;
import org.roundpicker.model.RoundPickerElem;

import android.graphics.drawable.Drawable;

/**
 * @author Valentin BASTIEN
 *
 */
@RunWith(RobolectricTestRunner.class)
public class RoundPickerAdapterTest {
	private MainActivity activity;

	private RoundPickerAdapter adapter;
	private List<RoundPickerElem> elems;
	
// Drawable for tests
	private Drawable blueSquare;
	private Drawable purpleSquare;
	private Drawable greenSquare;
	private Drawable redSquare;
	private RoundPickerElem firstElem;
	private RoundPickerElem secondElem;
	private RoundPickerElem thirdElem;
	private RoundPickerElem fourthElem;

	@Before
	public void setUp(){
		activity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
		adapter = new RoundPickerAdapter();
		elems = new ArrayList<RoundPickerElem>();
		
		blueSquare = activity.getResources().getDrawable(R.drawable.square_blue_light);
		greenSquare = activity.getResources().getDrawable(R.drawable.square_green_light);
		purpleSquare = activity.getResources().getDrawable(R.drawable.square_purple_light);
		redSquare = activity.getResources().getDrawable(R.drawable.square_red_light);
		
    	firstElem = new RoundPickerElem("one", purpleSquare);
    	secondElem = new RoundPickerElem("two", greenSquare);
    	thirdElem = new RoundPickerElem("three", redSquare);
    	fourthElem = new RoundPickerElem("four", blueSquare);
	}
	
	@After
	public void tearDown(){
		
	}
	
    @Test
    public void shouldBeProtectedAgainstNull() throws Exception {
		adapter.setRoundPickerElemList(null);
		adapter.getItem(0);
    }
    
    @Test
    public void shouldBeProtectedAgainstWrongIndexes() throws Exception {
    	elems.clear();
		adapter.setRoundPickerElemList(elems);
		Object result;
		result = adapter.getItem(-1);
		assertNull("Adapter should not return a valid value when given a wrong index", result);
		result = adapter.getItem(3); // Which is wrong because it has no item
		assertNull("Adapter should not return a valid value when given a wrong index", result);
    }
    
    @Test
    public void shouldReturnTheCorrectItem() throws Exception{  	
    	elems.clear();
    	elems.add(firstElem);
    	elems.add(secondElem);
    	elems.add(thirdElem);
    	elems.add(fourthElem);

    	adapter.setRoundPickerElemList(elems);
    	
    	RoundPickerElem res = (RoundPickerElem) adapter.getItem(0);
    	assertEquals("The round picker elem has not the correct string value ", firstElem.getLibelle(), res.getLibelle());
    	assertEquals("The round picker elem has not the correct drawable value ", firstElem.getLibelle(), res.getLibelle());
    	
    	res = (RoundPickerElem) adapter.getItem(1);
    	assertEquals("The round picker elem has not the correct string value ", secondElem.getLibelle(), res.getLibelle());
    	assertEquals("The round picker elem has not the correct drawable value ", secondElem.getLibelle(), res.getLibelle());

    	res = (RoundPickerElem) adapter.getItem(2);
    	assertEquals("The round picker elem has not the correct string value ", thirdElem.getLibelle(), res.getLibelle());
    	assertEquals("The round picker elem has not the correct drawable value ", thirdElem.getLibelle(), res.getLibelle());

    	res = (RoundPickerElem) adapter.getItem(3);
    	assertEquals("The round picker elem has not the correct string value ", fourthElem.getLibelle(), res.getLibelle());
    	assertEquals("The round picker elem has not the correct drawable value ", fourthElem.getLibelle(), res.getLibelle());

    	
    }
    
    @Test
    public void testWrongCase(){
    	elems.clear();
    	
    	adapter.setRoundPickerElemList(elems);    	
    	assertNull("The adapter should return a null value", adapter.getItem(0));

    	elems.add(firstElem);
    	elems.add(secondElem);
    	elems.add(thirdElem);
    	elems.add(fourthElem);
    	
    	adapter.setRoundPickerElemList(elems);
    	
    	adapter.removeRoundPickerElem(firstElem);
    	
    	assertNull("The adapter should return a null value", adapter.getItem(3));
    }
    
    @Test
    public void shouldAddCorrectly(){
    	elems.clear();
    	adapter.setRoundPickerElemList(null);
    	assertEquals("The adapter does not have the expected number of items", 0, adapter.getCount());
    	adapter.addRoundPickerElem(firstElem);
    	assertEquals("The adapter does not have the expected number of items", 0, adapter.getCount()); //Because there is no list inside

    	adapter.setRoundPickerElemList(elems);
    	
    	adapter.addRoundPickerElem(null); // should not do anything
    	assertEquals("The adapter does not have the expected number of items", 0, adapter.getCount());    	
    	
    	adapter.addRoundPickerElem(firstElem);
    	assertEquals("The adapter does not have the expected number of items", 1, adapter.getCount());

    	adapter.addRoundPickerElem(secondElem);
    	assertEquals("The adapter does not have the expected number of items", 2, adapter.getCount());

    }
    
    @Test
    public void shouldRemoveCorrectly(){
    	elems.clear();
    	adapter.setRoundPickerElemList(elems);

    	adapter.addRoundPickerElem(firstElem);
    	adapter.addRoundPickerElem(secondElem);
    	adapter.addRoundPickerElem(thirdElem);
    	adapter.addRoundPickerElem(fourthElem);
    	
    	assertEquals("The adapter does not have the expected number of items", 4, adapter.getCount());
    	
    	adapter.removeRoundPickerElem(null); // should not do anything
    	assertEquals("The adapter does not have the expected number of items", 4, adapter.getCount());
    	
    	adapter.removeRoundPickerElem(firstElem);
    	assertEquals("The adapter does not have the expected number of items", 3, adapter.getCount());    	

    	adapter.removeRoundPickerElem(firstElem); // Should not erase anything
    	assertEquals("The adapter does not have the expected number of items", 3, adapter.getCount());

    	adapter.removeRoundPickerElem(secondElem);
    	assertEquals("The adapter does not have the expected number of items", 2, adapter.getCount());

    	adapter.removeRoundPickerElem(thirdElem);
    	assertEquals("The adapter does not have the expected number of items", 1, adapter.getCount());

    	adapter.removeRoundPickerElem(fourthElem);
    	assertEquals("The adapter does not have the expected number of items", 0, adapter.getCount());
    	
    	adapter.removeRoundPickerElem(fourthElem); // should not do anything
    	assertEquals("The adapter does not have the expected number of items", 0, adapter.getCount());    	
    }
}