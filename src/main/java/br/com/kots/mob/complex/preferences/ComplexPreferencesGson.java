package br.com.kots.mob.complex.preferences;

import com.google.gson.Gson;

/*
 *  ref http://www.ne.jp/asahi/hishidama/home/tech/java/google/gson.html
 *  reamarks deep class is not simple copy
 */
public class ComplexPreferencesGson implements ComplexPreferencesHelper{
	private Gson GSON = null;

	public ComplexPreferencesGson(){
		GSON = new Gson();
	}
	
	@Override
	public String putObjectCore(Object object) {
		return GSON.toJson(object);
	}

	@Override
	public <T> T getObject(String data, Class<T> a) {
		return GSON.fromJson(data, a);
	}
}
