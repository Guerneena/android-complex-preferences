
Complex Preferences Android - by Felipe Silvestre
===========================

Complex Preferences is a component to android that allows the developers put objects and complex objects in SharedPreferences.
Gson (Google Json Library) is used internally to persist objects.

SharedPrefences of android is limited, only accept theses types: int,float,long,boolean,String,Set String. ComplexPrefences comes to improve it.

How to use:

You can persist your models with ComplexPreferences.
```java
    User user = new User();
    user.setName("Felipe");
    user.setAge(22); 
    user.setActive(true); 

    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);;
    complexPreferences.putObject("user", user);
    complexPreferences.commit();
```

And you can get it when you need!

```java
    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);
    User user = complexPreferences.getObject("user", User.class);
```

To remove or clear objects just use #removeObject(String key) and #clear() the same way as you'd do with standard android shared preferences editor.
```java
    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);;
    complexPreferences.removeObject("user");
    complexPreferences.commit();
```
```java
    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);;
    complexPreferences.clear()
```

Simple and effective.

If you need persist complex objects like a List of Users, you need create a new Class with List or other structure that you want.

```java
    public class ListComplexObject {
      
    	List<User> users;    

    	public List<User> getUsers() {
    		return users;
    	}    
    	public void setUsers(List<User> users) {
    		this.users = users;
    	}
    }
```

And use this object to persist

```java
    List<User> users = new ArrayList<User>();
    // populate your List
    ListComplexObject complexObject = new ListComplexObject();
    complexObject.setUsers(users);    

    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);;
    complexPreferences.putObject("list", complexObject);
    complexPreferences.commit();
```

Get your complex object

```java
    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);
    ListComplexObject complexObject = complexPreferences.getObject("list", ListComplexObject.class);

    for(User item: complexObject.users){
	   Log.i("ComplexPreferences", "item " + item);
     }
```

Good work!

--------------------------------------
# update ufo22940268

Add `pom.xml` files to make it possible to build with maven. And make it easier to integrate with my project.

--------------------------------------

# update kimukou.buzz

- jsonic support(classpath found jsonic.jar using/not found gson using)
- need append local.properties (using ant)
- .project/.classpath add (import project difficalte)


## ComplexPreferences

	ant jar task add (using custom_rules)

```
	ant jar
```
	
test ExampleComplexPreferences not reference library project

## ExampleComplexPreferences

ant after-copy/after-copy-install task add (using custom_rules)

```
	ant debug after-copy after-copy-install
```

### check device
 
- IS01(Android 1.6)
- galaxyTab(Android 2.2)
- ArrowsZ(Android 2.3.5)
- Xoom(Android 3.2)
- Nexsus7(Android 4.3)