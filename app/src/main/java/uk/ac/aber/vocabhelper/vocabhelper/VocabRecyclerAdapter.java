package uk.ac.aber.vocabhelper.vocabhelper;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import uk.ac.aber.vocabhelper.vocabhelper.databinding.RecyclerViewVocabItemBinding;

public class VocabRecyclerAdapter extends RecyclerView.Adapter<VocabRecyclerAdapter.ViewHolder> {
    private final Context context;
    private List<Vocab> dataSet;
    private View.OnClickListener clickListener;


    public VocabRecyclerAdapter(Context context) {
        this.context = context;

    }


    public VocabRecyclerAdapter(Context context, List<Vocab> vocab) {
        this.context = context;
this.dataSet = vocab;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

      RecyclerViewVocabItemBinding binding;
private TextView lang;
private TextView learn;
private TextView meaning;

        ViewHolder(View itemView) {
            super(itemView);


       binding = DataBindingUtil.bind(itemView);
lang = itemView.findViewById(R.id.lang_textview);
learn =itemView.findViewById(R.id.learn_textView);
meaning = itemView.findViewById(R.id.meaning_textview);
       itemView.setOnClickListener(clickListener);

        }

void bindDataSet(Vocab vocab){
            binding.setVocab(vocab);
}
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_view_vocab_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
if(dataSet != null)
{
        holder.bindDataSet(dataSet.get(position));
        holder.lang.setText(dataSet.get(position).getLanguage());
        holder.learn.setText(dataSet.get(position).getLearn());
        holder.meaning.setText(dataSet.get(position).getMeaning());
}
    }
   public void changeDataSet(List<Vocab> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(dataSet != null){
        return dataSet.size();}
        else{
            return 0;}
    }

   public void setOnClickListener(View.OnClickListener itemClickListener) {
        clickListener = itemClickListener;
    }


}
