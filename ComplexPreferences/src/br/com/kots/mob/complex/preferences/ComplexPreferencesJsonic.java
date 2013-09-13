package br.com.kots.mob.complex.preferences;

import net.arnx.jsonic.JSON;

public class ComplexPreferencesJsonic implements ComplexPreferencesHelper{

	public ComplexPreferencesJsonic(){
	}
	
	@Override
	public String putObjectCore(Object object) {
		return JSON.encode(object);
	}

	@Override
	public <T> T getObject(String data, Class<T> a) {
		return JSON.decode(data, a);
	}
}
