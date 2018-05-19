package com.example.eduardopalacios.buscadoryoutube.webServices;

import android.os.AsyncTask;

import com.example.eduardopalacios.buscadoryoutube.clasesGson.Default;
import com.example.eduardopalacios.buscadoryoutube.clasesGson.Id;
import com.example.eduardopalacios.buscadoryoutube.clasesGson.Item;
import com.example.eduardopalacios.buscadoryoutube.clasesGson.Snippet;
import com.example.eduardopalacios.buscadoryoutube.clasesGson.Thumbnails;
import com.example.eduardopalacios.buscadoryoutube.clasesGson.Values;
import com.example.eduardopalacios.buscadoryoutube.clasesPOJO.Items;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oemy9 on 19/05/2018.
 */

public class descargarValores extends AsyncTask<String,Integer,List<Items>> {

    List<Items>datos;
    @Override
    protected List <Items> doInBackground (String... valores) {

        String busqueda=valores[0];
        String llave="AIzaSyAE2a0ti4DL-Ss3z66UgqAqAxYjhLe_XAk";

        String cadena="https://www.googleapis.com/youtube/v3/search?part=snippet&q="+busqueda+"&type=video&maxResults=20&key="+llave+"";

        try {

            URL url=new URL(cadena);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            int respuesta=connection.getResponseCode();
            String line="";
            String Json="";

            if (respuesta==HttpURLConnection.HTTP_OK)
            {
                BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((line=reader.readLine())!=null)
                {

                    Json=Json+line;
                }
                SerializacionGson(Json);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }


    public void SerializacionGson(String Json)

    {
        datos=new ArrayList<>();

        String idVideo,titulo,canal,urlImagen;

        Gson gson=new Gson();

        Values values=gson.fromJson(Json,Values.class);

        List<Item> item=values.getItems();

        for ( Item valor:item) {

            Id id=valor.getId();

            idVideo=id.getVideoId();

            Snippet snippet=valor.getSnippet();
            titulo=snippet.getTitle();
            canal=snippet.getChannelTitle();



            Thumbnails thumbnails=snippet.getThumbnails();
            Default deft=thumbnails.getDefault();
            urlImagen=deft.getUrl();



            datos.add(new Items(idVideo,titulo,canal,urlImagen));



        }





    }


}
