package pl.edu.pb.wi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    public static final String KEY_EXTRA_ANSWER_SHOWN = "pb.edu.pl.quiz.answerShown";
    private boolean correctAnswer;
    private Button showCorrectAnswerButton;
    private TextView answerTextView;


    private void setAnswerShownResult(boolean answerWasShown){
        Intent resultIntent = new Intent();
        boolean answerShown = false;
        resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN, answerShown);
        setResult(RESULT_OK, resultIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);
        showCorrectAnswerButton = findViewById(R.id.showCorrectAnswerButton);
        answerTextView = findViewById(R.id.answer_text_view);

        showCorrectAnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int answer = correctAnswer ? R.string.button_true : R.string.button_false;
                answerTextView.setText(answer);
                setAnswerShownResult(true);
            }
        });
    }
}