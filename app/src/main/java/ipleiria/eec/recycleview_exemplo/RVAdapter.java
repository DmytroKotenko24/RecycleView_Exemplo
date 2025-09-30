package ipleiria.eec.recycleview_exemplo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import modelo.Person;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {
    ArrayList<Person> persons;
    public RVAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.personName.setText(persons.get(position).getName());
        holder.personAge.setText(persons.get(position).getAge());
        holder.personPhoto.setImageResource(persons.get(position).getPhotoId());
    }
    @Override
    public int getItemCount() {
        return persons.size();
    }
    public class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        PersonViewHolder(View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.person_name);
            personAge = itemView.findViewById(R.id.person_age);
            personPhoto = itemView.findViewById(R.id.person_photo);
        }
    }
}
