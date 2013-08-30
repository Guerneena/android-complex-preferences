package br.com.kots.mob.complex.preferences;

import java.lang.reflect.Type;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ComplexPreferences implements SharedPreferences {

	private static ComplexPreferences complexPreferences;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	private static Gson GSON = new Gson();
	Type typeOfObject = new TypeToken<Object>() {
	}.getType();

	private ComplexPreferences(Context context, String namePreferences, int mode) {
		if (namePreferences == null || "".equals(namePreferences.trim())) {
			namePreferences = "complex_preferences";
		}
		preferences = context.getSharedPreferences(namePreferences, mode);
		editor = preferences.edit();
	}

	public static ComplexPreferences getComplexPreferences(Context context,
			String namePreferences, int mode) {

		if (complexPreferences == null) {
			complexPreferences = new ComplexPreferences(context,
					namePreferences, mode);
		}

		return complexPreferences;
	}

	public void putObject(String key, Object object) {
		if(object == null){
			throw new IllegalArgumentException("object is null");
		}
		
		if(key == null || "".equals(key.trim())){
			throw new IllegalArgumentException("key is empty or null");
		}
		
		editor.putString(key, GSON.toJson(object));
	}

	public void removeObject(String key) {
		editor.remove(key);
	}
	
	public void commit() {
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.GINGERBREAD){
			ComplexPreferencesEx.apply(editor);
		}
		else editor.commit();
	}

	public <T> T getObject(String key, Class<T> a) {
	
		String gson = preferences.getString(key, null);
		if (gson == null) {
			return null;
		} else {
			try{
				return GSON.fromJson(gson, a);
			} catch (Exception e) {
				throw new IllegalArgumentException("Object storaged with key " + key + " is instanceof other class");				
			}
		}
	}

	@Override
	public boolean contains(String key) {
		return preferences.contains(key);
	}

	@Override
	public Editor edit() {
		return preferences.edit();
	}

	@Override
	public Map<String, ?> getAll() {
		return preferences.getAll();
	}

	@Override
	public boolean getBoolean(String key, boolean defValue) {
		return preferences.getBoolean(key, defValue);
	}

	@Override
	public float getFloat(String key, float defValue) {
		return preferences.getFloat(key, defValue);
	}

	@Override
	public int getInt(String key, int defValue) {
		return preferences.getInt(key, defValue);
	}

	@Override
	public long getLong(String key, long defValue) {
		return preferences.getLong(key, defValue);
	}

	@Override
	public String getString(String key, String defValue) {
		return preferences.getString(key, defValue);
	}

	@Override
	public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
		preferences.registerOnSharedPreferenceChangeListener(listener);	
	}

	@Override
	public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
		preferences.unregisterOnSharedPreferenceChangeListener(listener);	
	}
		
	
}

