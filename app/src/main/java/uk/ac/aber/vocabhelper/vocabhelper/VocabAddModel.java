package uk.ac.aber.vocabhelper.vocabhelper;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import uk.ac.aber.vocabhelper.vocabhelper.datasource.VocabRepository;

public class VocabAddModel extends AndroidViewModel {

private VocabRepository repository;

public VocabAddModel(@NonNull Application application){
    super(application);
    repository = new VocabRepository(application);
}
public void insertVocab(Vocab vocab){
    repository.insert(vocab);
}
    }
