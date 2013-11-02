/*
 * OnRotationChangeListenerMockup.java
 * Creation at : 3 nov. 2013 00:03:51
*/
package org.roundpicker.views.mockup;

import org.roundpicker.listeners.OnRotationChangedListener;

/**
 * @author Valentin BASTIEN
 *
 */
public class OnRotationChangedListenerMockup implements OnRotationChangedListener{

	private int rotation = 0;
	private int numberOfNotification = 0;
	
	@Override
	public void onRotationChanged(int newValue) {
		rotation = newValue;
		numberOfNotification++;
	}

	public int getNumberOfNotification() {
		return numberOfNotification;
	}

	public void setNumberOfNotification(int numberOfNotification) {
		this.numberOfNotification = numberOfNotification;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
	

}
