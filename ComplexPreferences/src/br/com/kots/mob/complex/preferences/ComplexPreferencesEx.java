package  br.com.kots.mob.complex.preferences;

import java.util.Set;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint("NewApi")
public class ComplexPreferencesEx {
	public static void apply(Editor e ){
		e.apply();
	}
	
	public static Set<String> getStringSet(SharedPreferences preferences,String key, Set<String> values){
		return preferences.getStringSet(key, values);
	}
	
}
