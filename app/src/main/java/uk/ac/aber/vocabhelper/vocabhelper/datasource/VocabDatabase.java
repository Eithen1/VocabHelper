package uk.ac.aber.vocabhelper.vocabhelper.datasource;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import uk.ac.aber.vocabhelper.vocabhelper.Vocab;
import uk.ac.aber.vocabhelper.vocabhelper.VocabDao;

@Database(entities = {Vocab.class}, version =1)
public abstract class VocabDatabase extends RoomDatabase {
    private static VocabDatabase INSTANCE;

    public  abstract VocabDao getVocabDao();

    public static VocabDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (VocabDatabase.class){
                if(INSTANCE == null){
                  INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                          VocabDatabase.class,"Vocab_database").allowMainThreadQueries().addCallback(sRoomDatabaseCallback).build();

                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db){
                    super.onCreate(db);

                    // Let's build the database asynchronously in a separate thread
                    // We are not allowed to use Dao calls until onCreate returns
                    // so we cannot populate the database on the current main thread
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final VocabDao vocabDao;

        PopulateDbAsync(VocabDatabase db){vocabDao = db.getVocabDao();}

        @Override
        protected Void doInBackground(Void... voids) {
            List<Vocab> vocabList = new ArrayList<>();
           vocabList.add( new Vocab("lemon","2","huoifhweifs cunhv ijsaodbcnz sdjoxn sinc"));
            vocabList.add(     new Vocab("strawberry","rogu","dwqesuadchionbjLK dwqior dwpodjwe "));
        vocabDao.insertMultipleVocab(vocabList);
                    return null;
        }
    }
}
