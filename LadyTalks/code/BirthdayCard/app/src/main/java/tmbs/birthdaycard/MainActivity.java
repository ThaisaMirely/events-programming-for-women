package tmbs.birthdaycard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static final String EXTRA_MESSAGE = "extra_message_key";
    public static final String EXTRA_TITLE = "extra_title_key";
    public static final String EXTRA_BACKGROUND = "extra_background_key";

    private String imageTitle;
    private String imageBackground;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = (EditText) findViewById(R.id.editText_message);
        Button buttonCreateCard = (Button) findViewById(R.id.button_card);
        RadioButton radioButtonImageTitle01 = (RadioButton) findViewById(R.id.radioButton_sticker01);
        RadioButton radioButtonImageTitle02 = (RadioButton) findViewById(R.id.radioButton_sticker02);
        RadioButton radioButtonImageBackground01 = (RadioButton) findViewById(R.id.radioButton_background01);
        RadioButton radioButtonImageBackground02 = (RadioButton) findViewById(R.id.radioButton_background02);

        buttonCreateCard.setOnClickListener(this);
        radioButtonImageTitle01.setOnClickListener(this);
        radioButtonImageTitle02.setOnClickListener(this);
        radioButtonImageBackground01.setOnClickListener(this);
        radioButtonImageBackground02.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.radioButton_sticker01:
                imageTitle = "title_01";

                break;
            case R.id.radioButton_sticker02:
                imageTitle = "title_02";

                break;
            case R.id.radioButton_background01:
                imageBackground = "background_01";

                break;
            case R.id.radioButton_background02:
                imageBackground = "background_02";

                break;
            case R.id.button_card:
                String message = editTextMessage.getText().toString();

                if((!message.isEmpty() && message.trim() != null) && !imageTitle.isEmpty() && !imageBackground.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, CardScreenActivity.class);

                    intent.putExtra(EXTRA_MESSAGE, message);
                    intent.putExtra(EXTRA_TITLE, imageTitle);
                    intent.putExtra(EXTRA_BACKGROUND, imageBackground);

                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"Informe todos os campos.",Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
