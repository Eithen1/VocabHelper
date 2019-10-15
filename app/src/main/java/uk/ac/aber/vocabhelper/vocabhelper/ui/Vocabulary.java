package uk.ac.aber.vocabhelper.vocabhelper.ui;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import uk.ac.aber.vocabhelper.vocabhelper.R;
import uk.ac.aber.vocabhelper.vocabhelper.Vocab;
import uk.ac.aber.vocabhelper.vocabhelper.VocabRecyclerAdapter;
import uk.ac.aber.vocabhelper.vocabhelper.VocabViewModel;
import uk.ac.aber.vocabhelper.vocabhelper.datasource.vocabList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Vocabulary extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{


    private VocabRecyclerAdapter vocabRecyclerAdapter;
    private VocabViewModel vocabview;
    private LiveData<List<Vocab>> oldList;


    public Vocabulary(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vocabulary, container, false);

        vocabview = ViewModelProviders.of(this).get(VocabViewModel.class);
       vocabRecyclerAdapter = vocabview.getAdapter();
       if(vocabRecyclerAdapter == null){
           vocabRecyclerAdapter = new VocabRecyclerAdapter(getActivity());
           vocabview.setAdapter(vocabRecyclerAdapter);
       }

       //Temporary Vocab list to display recycleView working
        vocabList list = new vocabList();
       vocabRecyclerAdapter = new VocabRecyclerAdapter(getContext(),list.getVocabs());
        RecyclerView listVocab = view.findViewById(R.id.vocab_list);
        listVocab.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);;
        listVocab.setLayoutManager(gridLayoutManager);
        listVocab.setAdapter(vocabRecyclerAdapter);

        vocabRecyclerAdapter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Get the word and display it
                Toast.makeText(getContext(), "Vocab clicked", Toast.LENGTH_SHORT).show();
                TextView nameView = v.findViewById(R.id.lang_textview);
                Toast.makeText(getContext(), "Vocab" + nameView.getText() + " clicked", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


    public void  setupObserver(){
        LiveData<List<Vocab >> vocablist = searchForVocab();

        if (!Objects.equals(oldList, vocablist)){
            if (oldList != null){
                oldList.removeObservers(this);
            }
            oldList = vocablist;
        }

        // Only add an observer to the LiveData object if it doesn't
        // already have one. We have to do this check since searchForCats
        // will just return the same LiveData object if the search criteria have not changed
        if (!vocablist.hasObservers()) {

            vocablist.observe(this, new Observer<List<Vocab>>() {
                @Override
                public void onChanged(@Nullable List<Vocab> cats) {
                    vocabRecyclerAdapter.changeDataSet(cats);
                }
            });
        }
    }

    public LiveData<List<Vocab>> searchForVocab(){
        return vocabview.getVocab();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
setupObserver();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

    }
}
