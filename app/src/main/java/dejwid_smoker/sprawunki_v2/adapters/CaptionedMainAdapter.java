package dejwid_smoker.sprawunki_v2.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dejwid_smoker.sprawunki_v2.R;

public class CaptionedMainAdapter extends RecyclerView.Adapter<CaptionedMainAdapter.ViewHolder> {

    private Listener listener;
    private ArrayList<String> names;

    public static interface Listener {
        public void onClick(int position, String name);

        public void onClickDelete(int position, String name);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView view) {
            super(view);
            cardView = view;
        }

    }

    public CaptionedMainAdapter(ArrayList<String> name) {
        this.names = name;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_main, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;

        final ImageView delete = (ImageView) cardView.findViewById(R.id.delete_card_view_main);
        final TextView listName = (TextView) cardView.findViewById(R.id.text_card_main);

        listName.setText(names.get(position));

        listName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setBackgroundResource(R.color.listClicked);
                listener.onClick(position, names.get(position));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete.setBackgroundResource(R.color.listClicked);
                listener.onClickDelete(position, names.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


}
