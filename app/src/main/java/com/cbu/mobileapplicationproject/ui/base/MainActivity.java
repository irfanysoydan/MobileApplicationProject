package com.cbu.mobileapplicationproject.ui.base;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cbu.mobileapplicationproject.Post;
import com.cbu.mobileapplicationproject.entities.concrete.Question;
import com.cbu.mobileapplicationproject.ui.adapter.PostRecyclerAdapter;
import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.databinding.ActivityMainBinding;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.ui.adapter.QuestionRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import model.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Post> posts;

    private List<Question> questions;
    private RecyclerView recyclerView;
    private MainViewModel mainViewModel;
    private QuestionRecyclerAdapter questionRecyclerAdapter;

    private Button searchButton;
    private TextView projectName;
    private EditText editSearch;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        recyclerView = findViewById(R.id.recyclerview);
        projectName = (TextView) findViewById(R.id.txt_project);
        searchButton = (Button)findViewById(R.id.btn_search);
        editSearch = (EditText)findViewById(R.id.edittext_search);
        editSearch.setVisibility(View.INVISIBLE);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp=getApplicationContext().getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
                int a=sp.getInt("id",0);
                Log.e("kullanici id", ""+a);
                Log.e("kullanici adi soyadi",sp.getString("name","")+" "+(sp.getString("surname","")));
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
        getUserList();

        //viewSettings();
        //fillTheArray();
       // questionRecyclerAdapter.notifyDataSetChanged();
    }
    public void getUserList() {
        // swipeRefresh.setRefreshing(true);
        mainViewModel.getAllQuestion().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(@Nullable List<Question> questions) {
                //swipeRefresh.setRefreshing(false);
                setRecyclerView(questions);
            }
        });

    }
    private void setRecyclerView(List<Question> questions) {
        questionRecyclerAdapter = new QuestionRecyclerAdapter(questions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questionRecyclerAdapter);
        questionRecyclerAdapter.notifyDataSetChanged();
    }

    private void filter(String text){
        ArrayList<Post> filteredList = new ArrayList<>();

        for(Post item: posts){
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

      // questionRecyclerAdapter.filterList(filteredList);
    }

    private void fillTheArray(){

       /* posts.add(new Post(R.drawable.profile_icon, "Yusuf Topkaya", "25 Nisan", "Traktörlerin Uşağa giderken fazla hararet yapması"));
        posts.add(new Post(R.drawable.profile_icon, "İrfan Yunus Soydan", "25 Nisan", "Çim biçme makinelerinin çim gelişimi üzerine etkisi"));
        posts.add(new Post(R.drawable.profile_icon, "Ömer Özoğlu", "25 Nisan", "Konyadaki verimli arazilerin yapay gübre kullanılarak harcanması"));
        posts.add(new Post(R.drawable.profile_icon, "Recep Şen", "25 Nisan", "Turunçgillerdeki vitamin miktarının nasıl artırılacağı"));
        posts.add(new Post(R.drawable.profile_icon, "Hikmet Gezmen", "25 Nisan", "Suriyeli Mültecilerin Hataydaki topraklar üzerine etkisi"));
        posts.add(new Post(R.drawable.profile_icon, "Halil Furkan Deniz", "25 Nisan", "Gaziosmanpaşa halkının yarısının meyvesi bıçak olan bir ağaç üretimini istemesi"));
        posts.add(new Post(R.drawable.profile_icon, "Yusuf Özçevik", "25 Nisan", "Yusuf Özçevik"));
        posts.add(new Post(R.drawable.profile_icon, "Müge Özçevik", "25 Nisan", "Müge Özçevik"));*/
    }
    private void viewSettings(){
       // recyclerView = findViewById(R.id.recyclerview);
        posts = new ArrayList<>();
       // questionRecyclerAdapter = new QuestionRecyclerAdapter(questions);
       // recyclerView.setAdapter(questionRecyclerAdapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}