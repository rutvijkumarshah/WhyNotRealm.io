package wnr.shah.rutvijkumar.whynotrealm;

import android.util.Log;

import io.realm.RealmObject;

public class Customer extends RealmObject{
    private String name;

    public String getName() {
        return name;
    }

    /***
     * This method will not be called by Realm.io instead it gets replaced by generated proxy method
     *
     * @param name
     */
    public void setName(String name) {
        //following log statements will not be found in logs
        Log.d("UNREACHABLE_TAG","name is ="+name);

        if(name!=null){
            //Save customer name in uppercase only.
            this.name = name.toUpperCase();
        }

    }

 /****
  *
  * Realm.io wont allow ANY method other than getters/setters
  *
  * Uncomment any of the following method and use it in MainActivity.java gives compile time error.
  *
  * Any of the following method
  *
    public boolean isNameStartsWith(String startsWith){
        return getName().startsWith(startsWith);
    }

    public static void helperMethod(){
        //wont even compile
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
    *******/
}
