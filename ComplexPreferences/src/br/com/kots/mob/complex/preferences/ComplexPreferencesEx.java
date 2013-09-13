package br.com.kots.mob.complex.preferences;

import java.util.HashSet;
import java.util.Set;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint("NewApi")
public class ComplexPreferencesEx {
	public static void apply(Editor e) {
		e.apply();
	}

	public static Set<String> getStringSet(SharedPreferences sp, String key,Set<String> values) {
		// return sp.getStringSet(key, values);
		
		// need deep copy
		//    see http://blog.nagopy.com/2013/02/sharedpreferencesgetstringset.html
		//
		Set<String> saved = sp.getStringSet(key, values);
		Set<String> returnSet = new HashSet<String>(saved.size());
		for (String str : saved) {
			returnSet.add(str);
		}
		return returnSet;
	}
}
