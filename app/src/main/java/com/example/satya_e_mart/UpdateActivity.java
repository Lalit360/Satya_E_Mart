package com.example.satya_e_mart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.satya_e_mart.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {

    ActivityUpdateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final  DBHelper helper = new DBHelper(this);
//        final int image = getIntent().getIntExtra("image" , 0);
//        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
//
//        final String name = getIntent().getStringExtra("name");
//        final String description = getIntent().getStringExtra("desc");
//
//        binding.detailImage.setImageResource(image);
//        binding.insertPrice.setText(String.format("%d", price));
//        binding.insertName.setText(name);
//        binding.detailDescription.setText(description);

        int id = getIntent().getIntExtra("id",0);

            Cursor cursor = helper.getOrderById(id);
            int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.insertPrice.setText(String.format("%d", cursor.getInt(3)));
            binding.insertName.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));


            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  boolean isUpdated =  helper.UpdateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.insertPrice.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.insertName.getText().toString(),
                            1,
                            id

                    );
                  if(isUpdated)
                      Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                  else
                      Toast.makeText(UpdateActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
