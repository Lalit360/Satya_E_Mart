package com.example.satya_e_mart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.satya_e_mart.Adapters.MainAdapter;
import com.example.satya_e_mart.Models.MainModel;
import com.example.satya_e_mart.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.ic_acer , "acer-aspire-gx" ,"15000","acer-aspire-gx-781-gaming-pc"));
        list.add(new MainModel(R.drawable.ic_apple_pad , "apple-9-7-ipad" ,"75000","apple-9-7-ipad-32-gb-gold"));
        list.add(new MainModel(R.drawable.ic_dell_inpiroi, "dell-inspiron-5675" ,"25000","dell-inspiron-5675-gaming-pc-recon-blue"));
        list.add(new MainModel(R.drawable.ic_dell_xps, "dell xps" ,"35000","dell-xps-15-9560"));
        list.add(new MainModel(R.drawable.ic_dell_inspironii, "dell-inspiron-15" ,"15000","dell-inspiron-15-7000-15-6"));

        MainAdapter adapter = new MainAdapter(list,this);

        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this , OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}