package kusrc.worapong.preyapron.sriwan.kurun;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class HistoryListView extends AppCompatActivity {

    private ListView listView;
    private String[] dateStrings, nameStrings, goldStrings;
    private int[] iconInts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list_view);

        listView = (ListView) findViewById(R.id.listView);

        ConnectHistory connectHistory = new ConnectHistory();
        connectHistory.execute();

    }   // Main Method

    public class ConnectHistory extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://swiftcodingthai.com/keng/php_get_history_master.php").build();
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

                JSONArray jsonArray = new JSONArray(s);

                dateStrings = new String[jsonArray.length()];
                nameStrings = new String[jsonArray.length()];
                goldStrings = new String[jsonArray.length()];
                iconInts = new int[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    dateStrings[i] = jsonObject.getString("Date");
                    nameStrings[i] = jsonObject.getString("Name");
                    goldStrings[i] = jsonObject.getString("Gold");
                    iconInts[i] = crestImage(goldStrings[i]);

                }   // for

                HistoryAdapter historyAdapter = new HistoryAdapter(HistoryListView.this,
                        iconInts, dateStrings, nameStrings);
                listView.setAdapter(historyAdapter);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }   // onPost
    }   // Class

    private int crestImage(String goldString) {

        int[] resultInts = new int[]{R.drawable.image0, R.drawable.image1, R.drawable.imge2, R.drawable.image3};

        return resultInts[Integer.parseInt(goldString)];
    }


}   // Main Class
