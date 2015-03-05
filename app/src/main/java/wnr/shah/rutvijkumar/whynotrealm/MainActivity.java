package wnr.shah.rutvijkumar.whynotrealm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends ActionBarActivity {

    private EditText mCustomerEditName;
    private TextView mCustomerSavedName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomerEditName=(EditText)findViewById(R.id.etName);
        mCustomerSavedName=(TextView)findViewById(R.id.tvResult);
    }


    public void onSave(View view){
        saveCustomerData(mCustomerEditName.getText().toString());
        Customer customer = getCustomerData();
        Log.d("TAG",customer.toString());
        /**
         * Call any of uncommented (other than getters/setters) method here.
         */
        //customer.helperMethod();
        String savedCustomerName=customer.getName();
        mCustomerSavedName.setText(savedCustomerName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveCustomerData(String name){
        Realm realm = Realm.getInstance(this);
        realm.beginTransaction();
        Customer customer=realm.createObject(Customer.class);
        customer.setName(name);
        realm.commitTransaction();

    }
    private Customer getCustomerData(){
        Realm realm = Realm.getInstance(this);
        RealmResults<Customer> customers = realm.allObjects(Customer.class);
        int total=customers.size();
        return customers.get(total-1);
    }
}
