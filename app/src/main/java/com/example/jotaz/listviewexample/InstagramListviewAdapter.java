package com.example.jotaz.listviewexample;

import android.content.Context;
//import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class InstagramListviewAdapter extends ArrayAdapter<Chat> {

    private List<Chat> info = new ArrayList<>();

    public InstagramListviewAdapter(Context context, List<Chat> datos) {
        super(context,R.layout.activity_instagram,datos);
        info =datos;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_listview_instagram,null);

        TextView usuario = (TextView) item.findViewById(R.id.user);
        usuario.setText(info.get(position).getUser());

        TextView mensaje = (TextView)item.findViewById(R.id.msj);
        mensaje.setText(info.get(position).getMsj());

        TextView hora = (TextView)item.findViewById(R.id.hora);
        hora.setText(info.get(position).getH());

        ImageView imagen = (ImageView)item.findViewById(R.id.imagen);
        imagen.setImageResource(info.get(position).getImg());

        return(item);

    }
}
