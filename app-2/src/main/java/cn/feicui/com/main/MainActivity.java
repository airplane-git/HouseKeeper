package cn.feicui.com.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.feicui.com.main.entity.DataKnowledge;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView= (ListView)findViewById(R.id.lv);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                DataKnowledge.str
        );
        assert listView!=null;
            listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position){
                    case 0:
                        intent.setClass(MainActivity.this, AnimationActivity.class);
                        break;
//                    case 1:
//                        break;
//                    case 2:
//                        break;
                }
                startActivity(intent);
            }
        });
    }
}
