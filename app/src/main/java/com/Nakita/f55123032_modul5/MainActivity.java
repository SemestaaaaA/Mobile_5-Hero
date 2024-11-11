package com.Nakita.f55123032_modul5;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<Pahlawan> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPahlawan = findViewById(R.id.rv_Pahlawan);
        rvPahlawan.setHasFixedSize(true);
        list.addAll(getListHeroes());
        showRecyclerList();}
    public ArrayList<Pahlawan> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray (R.array.data_photo);
        ArrayList<Pahlawan> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Pahlawan pahlawan = new Pahlawan();
            pahlawan.setName(dataName[i]);
            pahlawan.setDescription (dataDescription[i]);
            pahlawan.setPhoto(dataPhoto.getResourceId(i, -1));
            listHero.add(pahlawan);
        }return listHero;}
        private void showSelectedHero(Pahlawan pahlawan){Toast.makeText(this, "Nama Pahlawan adalah " + pahlawan.getName(), Toast.LENGTH_SHORT).show();}
    private void showRecyclerList(){
        rvPahlawan.setLayoutManager (new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter (list);
        rvPahlawan.setAdapter(listHeroAdapter);
        listHeroAdapter.setOnItemClickCallback(this::showSelectedHero);}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_list){rvPahlawan.setLayoutManager(new LinearLayoutManager(this));}
        else if (item.getItemId() == R.id.action_grid) {rvPahlawan.setLayoutManager(new GridLayoutManager(this, 2));}
        return super.onOptionsItemSelected(item);}

}