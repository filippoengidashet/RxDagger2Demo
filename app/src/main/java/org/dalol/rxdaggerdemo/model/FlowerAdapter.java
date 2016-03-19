package org.dalol.rxdaggerdemo.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.dalol.rxdaggerdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 3/19/2016
 */
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    private final LayoutInflater mInflater;
    private List<FlowerResponse> mFlowerList;
    private FlowerClickListener mListener;

    public FlowerAdapter(FlowerClickListener listener, LayoutInflater inflater) {
        mListener = listener;
        mInflater = inflater;
        mFlowerList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.item_flower, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        FlowerResponse currFlower = mFlowerList.get(position);

        holder.mName.setText(currFlower.getName());
        holder.mPrice.setText(String.format("$%.2f", currFlower.getPrice()));

        Glide.with(holder.itemView.getContext()).load(Constant.PHOTO_URL + currFlower.getPhoto()).into(holder.mPhoto);
    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    public void addFlowers(List<FlowerResponse> flowerResponses) {
        mFlowerList.addAll(flowerResponses);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mPhoto;
        private TextView mName, mPrice;

        public Holder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.flowerPhoto);
            mName = (TextView) itemView.findViewById(R.id.flowerName);
            mPrice = (TextView) itemView.findViewById(R.id.flowerPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getLayoutPosition(), mFlowerList.get(getAdapterPosition()).getName());
        }
    }

    public interface FlowerClickListener {

        void onClick(int position, String name);
    }
}
