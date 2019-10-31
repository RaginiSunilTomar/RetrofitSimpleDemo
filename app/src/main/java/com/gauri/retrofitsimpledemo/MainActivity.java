package com.gauri.retrofitsimpledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textviewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewResult= findViewById(R.id.text_view_result);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())// we are converting json into string by using gson
                .build();

        //here url competed
        JsonPlaceHolderApi jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);

      //to get post from url
        Call<List<Post>> call=jsonPlaceHolderApi.getPosts();
        //enque is used to generate asyncronys request,execute to generate syncronys request
        call.enqueue(new Callback<List<Post>>() {//to call the response
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {//to send the response
                if (!response.isSuccessful()){
                    textviewResult.setText("Code: "+response.code());
                    return;
                }

                List<Post> posts=response.body();//to store response in list

                for (Post post : posts){
                    String content="";
                    content+= "ID: "+post.getId()+ "\n";
                    content+= "User ID: "+post.getUserid()+ "\n";
                    content+= "Title: "+post.getTitle()+ "\n";
                    content+= "Text: "+post.getText()+ "\n\n";

                    textviewResult.append(content);//append for hold the response
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textviewResult.setText(t.getMessage());

            }
        });



    }
}
