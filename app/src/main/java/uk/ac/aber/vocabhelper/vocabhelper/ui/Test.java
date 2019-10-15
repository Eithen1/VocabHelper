package uk.ac.aber.vocabhelper.vocabhelper.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import uk.ac.aber.vocabhelper.vocabhelper.R;
import uk.ac.aber.vocabhelper.vocabhelper.Vocab;
import uk.ac.aber.vocabhelper.vocabhelper.datasource.VocabRepository;

/**
 * A simple {@link Fragment} subclass.
 */

public class Test extends Fragment {

    private EditText lang;
    private TextView meaning;
    private TextView learn;
    private int point = 0;
    private Button enter;
    private VocabRepository repository;
    private List<Vocab> list;
    Random rand = new Random();
    int i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vocabulary, container, false);
        learn = view.findViewById(R.id.test_learn);
        meaning = view.findViewById(R.id.test_meaning);
        lang = view.findViewById(R.id.test_lang_input);
        enter = view.findViewById(R.id.test_button);


      /**  enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iscorrect();
            }
        }); */
        return view;
    }

    private void iscorrect() {
        do {

            if (lang.toString() == list.get(i).getLanguage()) {
                point++;
                question();
            } else {
                return;
            }
        }
        while (point < 10);
    }




    public void question(){

        learn.setText(list.get(i).getLearn());
        meaning.setText(list.get(i).getMeaning());
       }
    }


