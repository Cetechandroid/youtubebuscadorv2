package com.example.eduardopalacios.buscadoryoutube.clasesPOJO;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eduardopalacios on 17/05/18.
 */

public class Items implements Parcelable {

    String idVideo,titulo,descripcion,imagen;

    public Items (String idVideo, String titulo, String descripcion, String imagen)
    {
        this.idVideo=idVideo;
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.imagen=imagen;
    }

    protected Items (Parcel in) {
        idVideo = in.readString();
        titulo = in.readString();
        descripcion = in.readString();
        imagen = in.readString();
    }

    public static final Creator <Items> CREATOR = new Creator <Items>() {
        @Override
        public Items createFromParcel (Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray (int size) {
            return new Items[size];
        }
    };

    public String getIdVideo() {
        return idVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel parcel, int i) {
        parcel.writeString(idVideo);
        parcel.writeString(titulo);
        parcel.writeString(descripcion);
        parcel.writeString(imagen);
    }
}
