package br.com.kots.mob.complex.preferences;


public interface ComplexPreferencesHelper {
	public String putObjectCore(Object object);
	public <T> T getObject(String data, Class<T> a) ;
}
