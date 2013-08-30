package  br.com.kots.mob.complex.preferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;

@SuppressLint("NewApi")
public class ComplexPreferencesEx {
	public static void apply(Editor e ){
		e.apply();
	}
}
