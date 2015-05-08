package eu.livotov.zxscan.zxscandemoapp;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by Nachiket on 4/18/2015.
 */
public class FetchData {

    public FetchData(){

    }

    public String getData(String phNo, String data,String ip){
        String line="";

        try{
            String url = "http://"+ip+":3000/qrcode/"+data+"/"+phNo;
            //String url = "http://192/qrcode/"+data+"/"+phNo;
            BufferedReader in = null;

            HttpClient httpclient = new DefaultHttpClient();

            HttpGet request = new HttpGet();
            URI website;
            website = new URI(url);
            request.setURI(website);
            HttpResponse response = httpclient.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            line = in.readLine();

        }catch(Exception e){
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        return line;

    }


}
