/*
 * RoundPickerViewTest.java
 * Creation at : 2 nov. 2013 21:58:00
*/
package org.roundpicker.views;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.roundpicker.roundpickerapp.MainActivity;
import org.roundpicker.roundpickerapp.R;
import org.roundpicker.views.mockup.OnRotationChangedListenerMockup;

/**
 * @author Valentin BASTIEN
 *
 */
@RunWith(RobolectricTestRunner.class)
public class RoundPickerViewTest {

	private MainActivity activity;
	private RoundPickerView roundPickerView;
	private OnRotationChangedListenerMockup listener1 = new OnRotationChangedListenerMockup();
	private OnRotationChangedListenerMockup listener2 = new OnRotationChangedListenerMockup();
	private OnRotationChangedListenerMockup listener3 = new OnRotationChangedListenerMockup();
	private OnRotationChangedListenerMockup listener4 = new OnRotationChangedListenerMockup();
	
	@Before
	public void setUp(){
		activity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
		roundPickerView = (RoundPickerView) activity.findViewById(R.id.round_picker_view);
	}
		
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testSetRoundPickerRotationAngle(){
		assertEquals("The round picker view has not the correct RoundPickerRotation init value ", 0, roundPickerView.getRoundPickerRotation());
		roundPickerView.setRoundPickerRotation(180);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 180, roundPickerView.getRoundPickerRotation());
		roundPickerView.setRoundPickerRotation(-150);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 360 - 150, roundPickerView.getRoundPickerRotation());
		roundPickerView.setRoundPickerRotation(3600);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 3600 % 360, roundPickerView.getRoundPickerRotation());		
	}
	
	@Test
	public void testAddRoundPickerRotationAngle(){
		roundPickerView.setRoundPickerRotation(0);
		roundPickerView.addRoundPickerRotation(18);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 18, roundPickerView.getRoundPickerRotation());		
		roundPickerView.addRoundPickerRotation(18);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 36, roundPickerView.getRoundPickerRotation());
// The result should be the same
		roundPickerView.addRoundPickerRotation(360);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 36, roundPickerView.getRoundPickerRotation());
		roundPickerView.addRoundPickerRotation(-18);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 18, roundPickerView.getRoundPickerRotation());		
		roundPickerView.addRoundPickerRotation(-36);
		assertEquals("The round picker view has not the correct RoundPickerRotation value ", 360 - 18, roundPickerView.getRoundPickerRotation());
	}
	
	private void testAllListeners(int value){
		assertEquals("The rotation listener has not the correct value", value, listener1.getRotation());
		assertEquals("The rotation listener has not the correct value", value, listener2.getRotation());
		assertEquals("The rotation listener has not the correct value", value, listener3.getRotation());
		assertEquals("The rotation listener has not the correct value", value, listener4.getRotation());		
	}

	private void cleanNotifOnListeners(){
		listener1.setNumberOfNotification(0);
		listener2.setNumberOfNotification(0);
		listener4.setNumberOfNotification(0);
		listener3.setNumberOfNotification(0);
	}
	
	@Test
	public void testRotationListener(){
		// Should not crash
		roundPickerView.addOnRotationChangedListener(null);
		roundPickerView.setRoundPickerRotation(10);

		roundPickerView.addOnRotationChangedListener(listener1);
		roundPickerView.setRoundPickerRotation(10);
		assertEquals("The rotation listener has not the correct value", 10, listener1.getRotation());
		
		roundPickerView.setRoundPickerRotation(40);
		assertEquals("The rotation listener has not the correct value", 40, listener1.getRotation());

		
		roundPickerView.setRoundPickerRotation(-150);
		assertEquals("The rotation listener has not the correct value", 360 - 150, listener1.getRotation());

		roundPickerView.addOnRotationChangedListener(listener2);
		roundPickerView.addOnRotationChangedListener(listener3);
		roundPickerView.addOnRotationChangedListener(listener4);
		roundPickerView.setRoundPickerRotation(45);
		testAllListeners(45);

		roundPickerView.addRoundPickerRotation(-90);
		testAllListeners(360 - 45);

		assertEquals("The listeners had been called a wrong number of time", 5, listener1.getNumberOfNotification());
		assertEquals("The listeners had been called a wrong number of time", 2, listener2.getNumberOfNotification());
		assertEquals("The listeners had been called a wrong number of time", 2, listener3.getNumberOfNotification());
		assertEquals("The listeners had been called a wrong number of time", 2, listener4.getNumberOfNotification());
		
		cleanNotifOnListeners();
		
		// Should do nothing
		roundPickerView.addOnRotationChangedListener(listener1);
		roundPickerView.removeOnRotationChangedListener(listener2);
		roundPickerView.addRoundPickerRotation(45);
		
		assertEquals("The listeners had been called a wrong number of time", 1, listener1.getNumberOfNotification());
		assertEquals("The listeners had been called a wrong number of time", 0, listener2.getNumberOfNotification());
		
		// Should not crash
		roundPickerView.removeOnRotationChangedListener(null);
			
	}
	
}
