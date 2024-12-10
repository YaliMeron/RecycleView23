package com.example.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> Models = new ArrayList<>();
int[] Images = {R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recycleid);

        setUpModels();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,Models);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpModels(){
 String [] Texts = getResources().getStringArray(R.array.Texts_for_recycle_view);
 String []Texts2 = getResources().getStringArray(R.array.Texts_for_recycle_view2);
 for (int i =0;i<Texts.length;i++)
 {
     Models.add(new Model(Images[i], Texts[i],Texts2[i]));
 }
    }
}