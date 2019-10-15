package uk.ac.aber.vocabhelper.vocabhelper;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "vocabs")
public class Vocab {

    @NonNull
    @PrimaryKey
    String language;

    String learn;
    String meaning;


    public Vocab(String language,String learn, String meaning ){
        this.language = language;
        this.learn = learn;
        this.meaning = meaning;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
