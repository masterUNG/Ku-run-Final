package kusrc.worapong.preyapron.sriwan.kurun;

import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowOff extends AppCompatActivity {

    private ListView listView;
    private String[] nameStrings, avateStrings, goldStrings;
    private int[] avataInts, goldInts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_off);

        listView = (ListView) findViewById(R.id.listView2);

        ConnectedUser connectedUser = new ConnectedUser();
        connectedUser.execute();

    }   // Main Method

    public class ConnectedUser extends AsyncTask<Void, Voice, String> {
        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://swiftcodingthai.com/keng/php_get_user_master.php").build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                return null;
            }

        }   // doIn

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                Log.d("31MayV1", "JSoN ==> " + s);

                JSONArray jsonArray = new JSONArray(s);

                nameStrings = new String[jsonArray.length()];
                avateStrings = new String[jsonArray.length()];
                goldStrings = new String[jsonArray.length()];
                avataInts = new int[jsonArray.length()];
                goldInts = new int[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    nameStrings[i] = jsonObject.getString("Name");
                    avateStrings[i] = jsonObject.getString("Avata");
                    avataInts[i] = createAvata(avateStrings[i]);
                    goldStrings[i] = jsonObject.getString("Gold");
                    goldInts[i] = createGold(goldStrings[i]);



                }

                ShowOffAdapter showOffAdapter = new ShowOffAdapter(ShowOff.this, avataInts, goldInts, nameStrings);
                listView.setAdapter(showOffAdapter);


            } catch (Exception e) {
                Log.d("31MayV2", "e ==> " + e.toString());
            }

        }   // onPost
    }   // Class

    private int createGold(String goldString) {

        int[] resultInts = new int[]{R.drawable.image0,
                R.drawable.image1,R.drawable.imge2, R.drawable.image3};

        return resultInts[Integer.parseInt(goldString)];
    }

    private int createAvata(String avateString) {

        int[] resultInts = new int[]{R.drawable.kon48,
                R.drawable.rat48, R.drawable.bird48, R.drawable.doremon48, R.drawable.nobita48};

        return resultInts[Integer.parseInt(avateString)];
    }

}   // Main Class
