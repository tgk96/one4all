package com.example.yoh.one4all;

import android.os.AsyncTask;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.lang.String;

/**
 * Created by shubhamjoshi on 09-06-2017.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    AlertDialog alertDialog;

    BackgroundTask(Context ctx){

        this.ctx=ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url="http://localhost/webapp/register.php";
        String login_url = "http://localhost/webapp/login.php";
        String method = params[0];

        if (method.equals("register")) {
            String name=params[1];
            String user_name=params[2];
            String user_pass=params[3];
            String email_addr=params[4];
            String age=params[5];
            String cnf_pass=params[6];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") +"="+ URLEncoder.encode(name,"UTF-8") + "&" +
                        URLEncoder.encode("user_name","UTF-8") +"="+ URLEncoder.encode(user_name,"UTF-8") + "&" +
                        URLEncoder.encode("user_pass","UTF-8") +"="+ URLEncoder.encode(user_pass,"UTF-8") + "&" +
                        URLEncoder.encode("email_addr","UTF-8") +"="+ URLEncoder.encode(email_addr,"UTF-8") + "&" +
                        URLEncoder.encode("age","UTF-8") +"="+ URLEncoder.encode(age,"UTF-8") + "&" +
                        URLEncoder.encode("cnf_pass","UTF-8") +"="+ URLEncoder.encode(cnf_pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS =httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success...";




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("login")
        {
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputstream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputstream,"UTF-8"));

                String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                        URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputstream.close();

                InputStream inputstream=httpURLConnection.getInputStream();
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream,"iso-8859-1"));
                String response = "";
                String line = "";
                while(line=bufferedreader.readLine()!=null)
                {
                    response+=line;
                }

                bufferedreader.close();
                inputstream.close();
                httpURLConnection.disconnect();
                return response;



            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Logged in Successfully");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("Registration Success..."))
        {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }


}
