package uk.ac.aber.vocabhelper.vocabhelper;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import uk.ac.aber.vocabhelper.vocabhelper.datasource.VocabRepository;

public class VocabViewModel extends AndroidViewModel {

    private VocabRepository repository;
    private LiveData<List<Vocab>> vocab_list;


    private String lang;
    private  String learn;
    private String meaning;

    private final String anyLang;
    private final String anyLearn;
    private final String anyMeaning;

    private VocabRecyclerAdapter adapter;

    public VocabViewModel(@NonNull Application application) {
        super(application);
        repository = new VocabRepository((application));

        anyLang = "Any Native Word";
        lang =anyLang;
        anyLearn = "Any Learning Word";
        learn = anyLearn;
        anyMeaning = "Any Meaning of a Word";
        meaning = anyMeaning;

        vocab_list = repository.getAllVocab();

    }

    public LiveData<List<Vocab>> getVocab() { return vocab_list;}

    public LiveData<List<Vocab>> getVocab(String lang, String learn, String meaning){
        boolean changed = false;
        if (!this.lang.equals(lang)){
            this.lang = lang;
            changed = true;
        }
        if (!this.learn.equals(learn)){
            this.learn = learn;
            changed = true;
        }
        if (!this.meaning.equals(meaning)){
            this.meaning = meaning;
            changed = true;
        }

        if(changed){
            if (!lang.equals(anyLang) && learn.equals(anyLearn) && meaning.equals(anyMeaning)){
                // Just load based on breed value: everything else is default and so omitted
                vocab_list = repository.getVocabByLang(lang);
            }
            else if (lang.equals(anyLang) && !learn.equals(anyLearn) && meaning.equals(anyMeaning)){
                // Just load based on gender value: everything else is default and so omitted
                vocab_list = repository.getVocabByLearn(learn);
            }

            else {
                // All are defaults

                vocab_list = repository.getAllVocab();
            }
        }
        return vocab_list;
    }
    public VocabRecyclerAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(VocabRecyclerAdapter adapter){
        this.adapter = adapter;
    }
}
