package ipleiria.eec.recycleview_exemplo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import modelo.ManagePersons;
import modelo.Person;

public class MainActivity extends AppCompatActivity {

    private ManagePersons hr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.RecyclerViewMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeData();
        RecyclerView rv = findViewById(R.id.RecyclerViewMain);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        RVAdapter adapter = new RVAdapter(hr.getPersons());
        rv.setAdapter(adapter);
    }

    private void initializeData() {
        hr = new ManagePersons();
        hr.addPerson(new Person("Dmytro Kotenko", "23 years old", R.drawable.dima));
        hr.addPerson(new Person("Diogo Oliveira", "20 years old", R.drawable.diogo));
        hr.addPerson(new Person("Tiago Tavares", "69 years old", R.drawable.tavares));
    }
}