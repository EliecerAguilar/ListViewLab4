package com.example.jotaz.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jotaz.listviewexample.InstagramListviewAdapter;
import com.example.jotaz.listviewexample.Chat;
import java.util.ArrayList;
import java.util.List;

public class InstagramActivity extends AppCompatActivity {

    ListView listaChats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        this.cargar();
        this.templateListView();
    }


    private void cargar(){
        listaChats = (ListView) findViewById(R.id.lstChats);

        listaChats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String usuarioName = ((Chat)a.getItemAtPosition(position)).getUser();
                Toast.makeText(InstagramActivity.this,"usuario seleccionado: " + usuarioName, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void templateListView(){
        List<Chat> opc = this.GetElementsToListViewTemplate();

        InstagramListviewAdapter adapter = new InstagramListviewAdapter(this, opc);

        listaChats.setAdapter(adapter);
    }

    private List<Chat> GetElementsToListViewTemplate()
    {
        List<Chat> opc = new ArrayList<>();

        opc.add(new Chat("Eliecer", "Hola como estas", "10 AM",R.drawable.user1));
        opc.add(new Chat("Maria", "Pasame el problema 3","12 AM",R.drawable.usr2));
        opc.add(new Chat("Carlos", "Que dieron en HP4 ?","1:50 PM",R.drawable.usr3));
        opc.add(new Chat("Andrea", "Recuerden el A3 para el miercoles","11:59 PM",R.drawable.usr4));

        return  opc;
    }

}
