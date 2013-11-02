/*
 * RoundPickerView.java
 * Creation at : 2 nov. 2013 23:11:54
*/
package org.roundpicker.views;

import java.util.HashSet;
import java.util.Set;

import org.roundpicker.listeners.OnRotationChangedListener;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Valentin BASTIEN
 *
 */
public class RoundPickerView extends View{

	private Set<OnRotationChangedListener> rotationListeners = null;

	private Set<OnRotationChangedListener> getRotationListeners(){
		if (rotationListeners == null){
			rotationListeners = new HashSet<OnRotationChangedListener>();
		}
		return (rotationListeners);
	}

	public void addOnRotationChangedListener(OnRotationChangedListener listener){
		if (listener == null){
			return;
		}
		getRotationListeners().add(listener);
	}
	
	public int getRoundPickerRotation() {
		return rotation;	
	}

	public void setRoundPickerRotation(int rotation) {
		if (rotation < 0){
			this.rotation = 360 - ((rotation * -1) % 360);
		}else{
			this.rotation = rotation % 360;			
		}
		for (OnRotationChangedListener l : getRotationListeners()){
			l.onRotationChanged(this.rotation);
		}
	}
	
	public void addRoundPickerRotation(int rotation) {
		setRoundPickerRotation(this.rotation + rotation);
	}
	
	public void removeOnRotationChangedListener(OnRotationChangedListener l){
		if (l == null){
			return;
		}
		getRotationListeners().remove(l);
	}
	private int rotation = 0;
	
	public RoundPickerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public RoundPickerView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public RoundPickerView(Context context) {
		super(context);
	}

}
