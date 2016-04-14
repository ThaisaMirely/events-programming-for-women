package tmbs.birthdaycard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        LinearLayout layoutView = (LinearLayout) findViewById(R.id.layout_card);
        TextView textView = (TextView) findViewById(R.id.textView_card_message);
        ImageView imageViewTitle = (ImageView) findViewById(R.id.imageView_card_title);

        Intent intent = getIntent();
        if(intent!=null) {
            String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            String imageTitle = intent.getStringExtra(MainActivity.EXTRA_TITLE);
            String imageBackground = intent.getStringExtra(MainActivity.EXTRA_BACKGROUND);

            layoutView.setBackgroundResource(getResources().getIdentifier(imageBackground, "drawable", getPackageName()));
            textView.setText(message);
            imageViewTitle.setImageResource(getResources().getIdentifier(imageTitle, "drawable", getPackageName()));
        }

    }
}
