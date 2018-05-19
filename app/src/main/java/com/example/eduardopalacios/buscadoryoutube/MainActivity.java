package com.example.eduardopalacios.buscadoryoutube;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.eduardopalacios.buscadoryoutube.clasesGson.Item;
import com.example.eduardopalacios.buscadoryoutube.clasesPOJO.Items;
import com.example.eduardopalacios.buscadoryoutube.webServices.descargarValores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText buscar;
    ImageButton boton;
    descargarValores descargar;
    List<Items> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscar=findViewById(R.id.ETBuscar);
        boton=findViewById(R.id.botonBuscar);


    }


    public void onClickButton(View view)
    {

        if (view.getId()==R.id.botonBuscar)
        {
            descargar=new descargarValores();

            descargar.execute(buscar.getText().toString());

            try {

               datos=descargar.get();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


            pasarValores();
        }

    }

    public void pasarValores()
    {
        Bundle bundle=new Bundle();
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        bundle.putParcelableArrayList("PARCE", (ArrayList<? extends Parcelable>) datos);
        intent.putExtras(bundle);

        startActivity(intent);
    }

}
