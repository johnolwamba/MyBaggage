package com.example.user.mybaggage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.user.mybaggage.adapters.AlertDialogManager;
import com.example.user.mybaggage.adapters.NuggetsRecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Nuggets extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> listNuggetImage = new ArrayList();
    ArrayList<String> listNuggetId = new ArrayList();
    ArrayList<String> listNuggetDescription = new ArrayList();

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuggets);


        recyclerView= (RecyclerView) findViewById(R.id.nuggetsRecycler);
        prepareData();
        Log.d("listNugget_size",listNuggetDescription.size()+"");

        NuggetsRecyclerAdapter adapter=new NuggetsRecyclerAdapter(Nuggets.this,listNuggetId.toArray(new String[listNuggetId.size()]),
                listNuggetDescription.toArray(new String[listNuggetDescription.size()]),listNuggetImage.toArray(new String[listNuggetImage.size()]));
                 recyclerView.setAdapter(adapter);
                 recyclerView.setHasFixedSize(true);
                 recyclerView.setLayoutManager(new LinearLayoutManager(Nuggets.this));

//        if(isNetworkAvailable()){
//            new myCards().execute();
//        }else{
//            Toast.makeText(getApplicationContext(),getString(R.string.no_internet_connection),Toast.LENGTH_SHORT).show();
//        }


    }

    public void prepareData(){

         listNuggetImage.add("kq");
         listNuggetId.add("1");
         listNuggetDescription.add("Nugget 1");

        listNuggetImage.add("profile");
        listNuggetId.add("2");
        listNuggetDescription.add("Nugget 2");

        listNuggetImage.add("profile");
        listNuggetId.add("3");
        listNuggetDescription.add("Nugget 3");

        listNuggetImage.add("kq");
        listNuggetId.add("4");
        listNuggetDescription.add("Nugget 4");




    }


    // Private class isNetworkAvailable
    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }


    /**
     * Async task class to get json by making HTTP call
     * */
//    private class myCards extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pDialog = new ProgressDialog(ManageCardsView.this);
//            pDialog.setMessage(getString(R.string.loading)+"...");
//            pDialog.setCancelable(true);
//            pDialog.show();
//
//        }
//        @Override
//        protected Void doInBackground(Void... arg0){
//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            params.add(new BasicNameValuePair("token", sharedpreferences.getString("token",null)));
//
//            // Creating service handler class instance
//            ServiceHandler sh = new ServiceHandler();
//            String url = URL_MY_CARDS+"?token="+sharedpreferences.getString("token",null);
//
//            // Making a request to url and getting response
//            String json = sh.makeServiceCall(url, ServiceHandler.GET,null);
//
//            //shows the response that we got from the http request on the logcat
//            Log.d("my_Response: ", "> " + json+ "URL:" + url);
//
//            listBankName.clear();
//            listCardNo.clear();
//            listSpendingLimit.clear();
//            listCardID.clear();
//            listDuration.clear();
//            listShared.clear();
//
//            if (json != null) {
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        pDialog.dismiss();
//                    }
//                });
//
//                try {
//                    JSONObject jsonObj = new JSONObject(json);
//                    if (jsonObj != null) {
//
//                        if(jsonObj.get("status").toString() == null){
//                            final String message = jsonObj.getString("message");
//                            // Existing data
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                    AlertDialog.Builder builder = new AlertDialog.Builder(
//                                            ManageCardsView.this);
//                                    builder.setMessage(message)
//                                            .setCancelable(false)
//                                            .setPositiveButton(getString(R.string.sign_in),
//                                                    new DialogInterface.OnClickListener() {
//                                                        public void onClick(
//                                                                DialogInterface dialog, int id) {
//                                                            Intent i = new Intent(ManageCardsView.this,LockScreenView.class);
//                                                            startActivity(i);
//                                                        }
//
//                                                    });
//                                    AlertDialog alert = builder.create();
//                                    alert.show();
//                                    pDialog.dismiss();
//                                }
//                            });
//
//                        }
//                        String status = jsonObj.getString("status");
//                        String bank="";
//                        String limit="";
//                        String card="";
//                        String id="";
//                        String duration ="";
//                        Boolean shared =false;
//                        if(status.equals("success")){
//                            final JSONArray dataArr = jsonObj.getJSONArray("data");
//
//                            if(dataArr.length()<1){
//                                // Existing data
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        AlertDialog.Builder builder = new AlertDialog.Builder(
//                                                ManageCardsView.this);
//                                        builder.setMessage(getString(R.string.no_cards_at_the_moment))
//                                                .setCancelable(false)
//                                                .setPositiveButton(getString(R.string.home),
//                                                        new DialogInterface.OnClickListener() {
//                                                            public void onClick(
//                                                                    DialogInterface dialog, int id) {
//                                                                Intent i = new Intent(ManageCardsView.this,HomeView.class);
//                                                                i.putExtra("fromIntent", "fromIntent");
//                                                                startActivity(i);
//                                                            }
//
//                                                        });
//                                        AlertDialog alert = builder.create();
//                                        alert.show();
//
//
//
//                                        pDialog.dismiss();
//                                    }
//                                });
//                            }
//                            for(int i =0; i<dataArr.length();i++){
//                                JSONObject catObj = (JSONObject) dataArr.get(i);
//                                bank = catObj.getString("bank");
//                                //limit = catObj.getString("limit");
//                                card = catObj.getString("card");
//                                id = catObj.getString("id");
//                                // duration = catObj.getString("duration");
//                                shared = catObj.getBoolean("has_sponsee");
//
//
//                                listBankName.add(bank);
//                                //listSpendingLimit.add(limit);
//                                listCardNo.add(card);
//                                listCardID.add(id);
//                                //  listDuration.add(duration);
//                                listShared.add(shared);
//
//                                editor.putString("card_string","card_string");
//                                editor.commit();
//
//                            }
//                            // Existing data
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//
//
//                                    pDialog.dismiss();
//                                    CardsRecyclerAdapter adapter=new CardsRecyclerAdapter(ManageCardsView.this,listBankName.toArray(new String[listBankName.size()]),
//                                            listCardNo.toArray(new String[listCardNo.size()]),listCardID.toArray(new String[listCardID.size()]),
//                                            listShared.toArray(new Boolean[listShared.size()]));
//                                    recyclerView.setAdapter(adapter);
//                                    recyclerView.setHasFixedSize(true);
//                                    recyclerView.setLayoutManager(new LinearLayoutManager(ManageCardsView.this));
//
//
//                                }
//                            });
//                        }else{
//
//                            listBankName.clear();
//                            listCardNo.clear();
//                            listSpendingLimit.clear();
//                            listCardID.clear();
//
//                            // Existing data
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    alert.showAlertDialog(
//                                            ManageCardsView.this,
//                                            getString(R.string.error),
//                                            "Please try again",
//                                            false);
//                                    pDialog.dismiss();
//
//
//                                }
//                            });
//
//                        }
//
//                    } else {
////                        // Existing data
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                alert.showAlertDialog(
//                                        ManageCardsView.this,
//                                        getString(R.string.failed),
//                                        getString(R.string.failed),
//                                        false);
//                                pDialog.dismiss();
//
//                            }
//                        });
//                    }
//
//                } catch (JSONException e) {
//
//                    e.printStackTrace();
//                }
//
//            } else {
//                // Error in connection
//                runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        alert.showAlertDialog(
//                                ManageCardsView.this,
//                                getString(R.string.error),
//                                getString(R.string.no_internet_connection),
//                                false);
//                        pDialog.dismiss();
//                        alert.notify();
//                    }
//                });
//
//                // Go to previous page
//                Intent intCategory = new Intent(getApplicationContext(), HomeView.class);
//                intCategory.putExtra("fromIntent", "fromIntent");
//                intCategory.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intCategory);
//            }
//            return null;
//        }
//        protected void onPostExecute(Void result) {
//            // dismiss the dialog once done
//            super.onPostExecute(result);
//            if (pDialog.isShowing())
//                pDialog.dismiss();
//        }
//
//
//
//    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(Nuggets.this,HomeFirst.class);
        startActivity(i);
        Nuggets.this.finish();

    }







}
