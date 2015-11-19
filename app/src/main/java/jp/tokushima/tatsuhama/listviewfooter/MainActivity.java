package jp.tokushima.tatsuhama.listviewfooter;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private View mFooterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mFooterView = createFooterView();
        mListView.setAdapter(createAdapter());
        mListView.addFooterView(mFooterView);
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mListView.removeFooterView(mFooterView);
            }
        }, 5000);
    }

    private ArrayAdapter<String> createAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for (int i = 0; i < 5; i++) {
            adapter.add(Integer.toString(i));
        }
        return adapter;
    }

    private View createFooterView() {
        return LayoutInflater.from(this).inflate(R.layout.footer, mListView, false);
    }
}
