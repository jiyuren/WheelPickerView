/*
 * RoundPickerElem.java
 * Creation at : 17 oct. 2013 23:38:46
*/
package org.roundpicker.model;

import android.graphics.drawable.Drawable;

/**
 * @author Valentin BASTIEN
 *
 */
public class RoundPickerElem {

	private String _libelle;
	private Drawable _icon;
	
	public RoundPickerElem(String libelle, Drawable icon){
		_libelle = libelle;
		_icon = icon;
	}

	public String getLibelle() {
		return _libelle;
	}

	public void setLibelle(String libelle) {
		this._libelle = libelle;
	}

	public Drawable getIcon() {
		return _icon;
	}

	public void setIcon(Drawable icon) {
		this._icon = icon;
	}
	
	
}
