package com.example.satya_e_mart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.satya_e_mart.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    int score = 0, sum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final  DBHelper helper = new DBHelper(this);

//        if(getIntent().getIntExtra("type",0) == 1){

        final int image = getIntent().getIntExtra("image" , 0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));

       final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("desc");

//        sum = price * score;

        binding.detailImage.setImageResource(image);
//        binding.insertPrice.setText(sum);
        binding.insertPrice.setText(String.format("%d", price));
        binding.insertName.setText(name);
        binding.detailDescription.setText(description);




        binding.insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted = helper.InsertOrder(
                        binding.nameBox.getText().toString(),
                binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())
                );
                if (isInserted)
                    Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
      //  }
//        else {
//            int id = getIntent().getIntExtra("id",0);
//
//            Cursor cursor = helper.getOrderById(id);
//            int image = cursor.getInt(4);
//            binding.detailImage.setImageResource(image);
//            binding.insertPrice.setText(String.format("%d", cursor.getInt(3)));
//            binding.insertName.setText(cursor.getString(6));
//            binding.detailDescription.setText(cursor.getString(5));
//
//
//            binding.nameBox.setText(cursor.getString(1));
//            binding.phoneBox.setText(cursor.getString(2));
//            binding.insertButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                  boolean isUpdated =  helper.UpdateOrder(
//                            binding.nameBox.getText().toString(),
//                            binding.phoneBox.getText().toString(),
//                            Integer.parseInt(binding.insertPrice.getText().toString()),
//                            image,
//                            binding.detailDescription.getText().toString(),
//                            binding.insertName.getText().toString(),
//                            1,
//                            id
//
//                    );
//                  if(isUpdated)
//                      Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
//                  else
//                      Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }



        String s = String.valueOf(score);
        binding.quantity.setText(s);



    }
    public void add(View view){

        score++;
        String s = String.valueOf(score);
        binding.quantity.setText(s);
//        int i = Integer.parseInt(s);
//
//        sum = price *i;

        

    }
    public void subtract(View view){

        score--;
        String s = String.valueOf(score);
        binding.quantity.setText(s);
    }


}