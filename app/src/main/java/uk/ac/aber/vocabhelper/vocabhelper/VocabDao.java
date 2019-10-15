package uk.ac.aber.vocabhelper.vocabhelper;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface VocabDao {

    @Insert(onConflict = IGNORE)
    void insertSingleWord(Vocab vocab);

    @Update (onConflict = IGNORE)
    void updateWord(Vocab vocab);

    @Insert
    void insertMultipleVocab(Vocab[] vocabList);

    @Insert
    void insertMultipleVocab(List<Vocab> vocabList);

    @Delete
    void deleteWord(Vocab vocab);

    @Query("DELETE FROM vocabs")
    void deleteAll();

    @Query("SELECT * FROM vocabs")
    LiveData<List<Vocab>> getAllVocab();

    @Query("SELECT * FROM vocabs WHERE language = :lang")
    LiveData<List<Vocab>> getVocabByLang(String lang);

    @Query("SELECT * FROM vocabs WHERE learn = :learn")
    LiveData<List<Vocab>> getVocabByLearn(String learn);

}
