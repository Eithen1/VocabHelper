package uk.ac.aber.vocabhelper.vocabhelper.datasource;

import java.util.ArrayList;
import java.util.List;

import uk.ac.aber.vocabhelper.vocabhelper.Vocab;

public class vocabList {

    private List<Vocab> vocabs  = new ArrayList<>();
    Vocab fewf = new Vocab("lemon","2","huoifhweifs");
    Vocab gfvfv = new Vocab("strawberry","rogu","dwqesuadchionbjLK");
    Vocab fvff =  new Vocab("feewfwefwefeewf","fwefwe","dfewiosnjcvkd");

            public void addVocabs() {
        vocabs.add(fewf);
        vocabs.add(gfvfv);
        vocabs.add(fvff);
            }

    public List<Vocab> getVocabs(){
        this.addVocabs();
        if(vocabs != null){
        return vocabs;}
        else{
           return null;
        }
    }
}




