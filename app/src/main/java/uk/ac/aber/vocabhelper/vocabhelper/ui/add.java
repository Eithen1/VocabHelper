package uk.ac.aber.vocabhelper.vocabhelper.ui;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uk.ac.aber.vocabhelper.vocabhelper.R;
import uk.ac.aber.vocabhelper.vocabhelper.Vocab;
import uk.ac.aber.vocabhelper.vocabhelper.VocabAddModel;

;

/**
 * A simple {@link Fragment} subclass.
 */

public class add extends Fragment {

    private static final String TAG = "onClick:";
    private static final String LANGUAGE_KEY = "LANGUAGE";
    private static final String LEARN_KEY = "LEARN";
    private static final String MEANING_PATH_KEY = "MEANING";
    private EditText langText;
    private EditText learnText;
    private EditText meaningText;
    private TextView langView;
    private TextView learnView;
    private Button addButton;
    private defineLanguage defined;
private VocabAddModel vocabViewModel;

    public add(){

    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vocabViewModel = ViewModelProviders.of(this).get(VocabAddModel.class);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        langText = view.findViewById(R.id.add_lang_input);
        learnText = view.findViewById(R.id.add_learn_input);
        meaningText = view.findViewById(R.id.add_meaning_input);
         langView = view.findViewById(R.id.add_lang_text);
         addButton = view.findViewById(R.id.add_button);
       addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LANGUAGE_KEY,"word:" + langText.getText().toString());
                Toast.makeText(getActivity(),"Word added",Toast.LENGTH_SHORT).show();
                insertVocab();
            }
        });
     return view;
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        if (langText.length() > 0)
            savedInstanceState.putString(LANGUAGE_KEY, String.valueOf(langText));
        if (learnText.length() > 0)
            savedInstanceState.putString(LEARN_KEY,learnText.getText().toString());
        if (meaningText.length() > 0)
            savedInstanceState.putString(MEANING_PATH_KEY, meaningText.toString());

        super.onSaveInstanceState(savedInstanceState);
    }
public void insertVocab(){

        Vocab vocab = new Vocab(langText.getText().toString(),
                learnText.getText().toString(),meaningText.getText().toString());
        vocabViewModel.insertVocab(vocab);}

}