package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cbu.mobileapplicationproject.Post;
import com.cbu.mobileapplicationproject.PostRecyclerAdapter;
import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.databinding.ActivityLoginBinding;
import com.cbu.mobileapplicationproject.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Post> posts;
    private RecyclerView recyclerView;
    private PostRecyclerAdapter postRecyclerAdapter;
    private Button searchButton;
    private TextView projectName;
    private EditText editSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        projectName = (TextView) findViewById(R.id.txt_project);
        searchButton = (Button)findViewById(R.id.btn_search);
        editSearch = (EditText)findViewById(R.id.edittext_search);
        editSearch.setVisibility(View.INVISIBLE);



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projectName.setVisibility(view.GONE);
                editSearch.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });


        viewSettings();
        fillTheArray();
        postRecyclerAdapter.notifyDataSetChanged();
    }

    private void filter(String text){
        ArrayList<Post> filteredList = new ArrayList<>();

        for(Post item: posts){
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        postRecyclerAdapter.filterList(filteredList);
    }

    private void fillTheArray(){
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "A"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Araba"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Ev"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Deli"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Dana"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Hahahah"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Ben"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Sen"));
    }
    private void viewSettings(){
        recyclerView = findViewById(R.id.recyclerview);
        posts = new ArrayList<>();
        postRecyclerAdapter = new PostRecyclerAdapter(posts);
        recyclerView.setAdapter(postRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}