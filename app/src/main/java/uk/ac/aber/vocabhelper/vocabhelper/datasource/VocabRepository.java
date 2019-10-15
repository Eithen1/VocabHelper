package uk.ac.aber.vocabhelper.vocabhelper.datasource;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import uk.ac.aber.vocabhelper.vocabhelper.Vocab;
import uk.ac.aber.vocabhelper.vocabhelper.VocabDao;

public class VocabRepository {

    private VocabDao vocabDao;
public VocabRepository(Application application){
    VocabDatabase db = VocabDatabase.getDatabase(application);
    vocabDao = db.getVocabDao();
}
public void insert(Vocab vocab){
    new InsertAsyncTask(vocabDao).execute(vocab);
}

public LiveData<List<Vocab>> getAllVocab() { return vocabDao.getAllVocab();}


public LiveData<List<Vocab>> getVocabByLang(String Lang) { return vocabDao.getVocabByLang(Lang);}
    public LiveData<List<Vocab>> getVocabByLearn(String Learn) { return vocabDao.getVocabByLearn(Learn);}
    private static class InsertAsyncTask extends AsyncTask<Vocab, Void, Void> {

        private VocabDao mAsyncTaskDao;

        InsertAsyncTask(VocabDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Vocab... params) {
            mAsyncTaskDao.insertMultipleVocab(params);
            return null;
        }
    }
}
