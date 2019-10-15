package com.example.jotaz.listviewexample;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class InstagramActivity extends AppCompatActivity {

    ListView listaChats;
    MenuItem menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        this.cargar();
        this.templateListView();

    }

    @Override
    protected void onStart() {
        super.onStart();


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
    private List<Chat> opc1;
    private void templateListView(){
        opc1 = this.GetElementsToListViewTemplate();

        InstagramListviewAdapter adapter = new InstagramListviewAdapter(this, opc1);

        listaChats.setAdapter(adapter);
    }

    private List<Chat> GetElementsToListViewTemplate()
    {
        List<Chat> opc = new ArrayList<>();

        opc.add(new Chat("Eliecer", "Hola como estas", "10 AM",R.drawable.ico));
        opc.add(new Chat("Maria", "Pasame el problema 3","12 AM",R.drawable.ic02));
        opc.add(new Chat("Carlos", "Que dieron en HP4 ?","1:50 PM",R.drawable.uc01));
        opc.add(new Chat("Andrea", "Recuerden el A3 para el miercoles","11:59 PM",R.drawable.ic03));

        return  opc;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_instagram,menu);
        return  true;

    }

    //seleccion de opcion del menu
    public boolean onOptionItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.newItem:
                this.AgregarNuevoElemento();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //private int cont=0;
    private void AgregarNuevoElemento(){

        opc1.add(new Chat("Eliecer_", "Hola como estas", "10 AM",R.drawable.ico));
        InstagramListviewAdapter adapter = new InstagramListviewAdapter(this, opc1);
        listaChats.setAdapter(adapter);
        //cont++;
    }

}
