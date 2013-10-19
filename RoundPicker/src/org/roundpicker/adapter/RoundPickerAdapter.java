/*
 * RoundPickerAdapter.java
 * Creation at : 17 oct. 2013 23:38:46
*/
package org.roundpicker.adapter;

import java.util.List;

import org.roundpicker.model.RoundPickerElem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author Valentin BASTIEN
 *
 */
public class RoundPickerAdapter extends BaseAdapter{

	private List<RoundPickerElem> _elems;

	public RoundPickerAdapter(List<RoundPickerElem> elems){
		_elems = elems;
	}

	public RoundPickerAdapter(){

	}

	@Override
	public int getCount() {
		if (_elems == null){
			return 0;
		}
		return _elems.size();
	}

	@Override
	public Object getItem(int index) {
		if (_elems == null || _elems.size() <= index || index < 0){
			return null;
		}
		return _elems.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		return (arg0);
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRoundPickerElemList(List<RoundPickerElem> elems) {
		_elems = elems;
	}

	public void removeRoundPickerElem(RoundPickerElem elem) {
		if (_elems == null || _elems.contains(elem) == false){
			return;
		}
		_elems.remove(elem);
	}
	
	public void addRoundPickerElem(RoundPickerElem elem){
		if (_elems == null || elem == null){
			return;
		}
		_elems.add(elem);
	}

}
