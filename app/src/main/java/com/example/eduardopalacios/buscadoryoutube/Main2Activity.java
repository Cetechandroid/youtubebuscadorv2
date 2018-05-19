package com.example.eduardopalacios.buscadoryoutube;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eduardopalacios.buscadoryoutube.Adaptadores.AdapterItem;
import com.example.eduardopalacios.buscadoryoutube.clasesPOJO.Items;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    List<Items> items=new ArrayList <>();
    AdapterItem adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.lista);

        Bundle bundle=getIntent().getExtras();
        items= bundle.getParcelableArrayList("PARCE");
        adapter=new AdapterItem(this,R.layout.disenio_listview,items);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView <?> adapterView, View view, int i, long l) {

                Bundle bundle=new Bundle();
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                bundle.putString("id_video",items.get(i).getIdVideo());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }
}
