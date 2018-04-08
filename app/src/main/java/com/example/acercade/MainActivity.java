package com.example.acercade;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView githubTextView;
    TextView facebookTextView;
    TextView emailTextView;
    TextView phoneTextView;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageViewFoto);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.foto);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);

        nameTextView = findViewById(R.id.nameTextView);
        githubTextView = findViewById(R.id.githubTextView);
        facebookTextView = findViewById(R.id.facebookTextView);
        emailTextView = findViewById(R.id.emailTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        shareButton = findViewById(R.id.shareButton);

        String nameText = nameTextView.getText().toString();
        String githubText = githubTextView.getText().toString();
        String facebookText = facebookTextView.getText().toString();
        String emailText = emailTextView.getText().toString();
        String phoneText = phoneTextView.getText().toString();
        final String text = nameText+"\n"+"Github: "+githubText+"\n"+"Facebook: "+facebookText+"\n"+"Email: "+emailText+"\n"+"Teléfono: "+phoneText+"\n";

        shareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share"));
            }
        });
    }
}
