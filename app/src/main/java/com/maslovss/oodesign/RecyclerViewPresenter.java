package com.maslovss.oodesign;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maslovss.oodesign.interfaces.IPresenter;
import com.maslovss.oodesign.interfaces.IViewHolder;
import com.maslovss.oodesign.interfaces.IViewHolderFactory;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Сергей on 23.03.2016.
 */
public class RecyclerViewPresenter<T> implements IPresenter {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    IViewHolderFactory<T> holderFactory;
    List<T> list;


    public RecyclerViewPresenter( Context context ,  RecyclerView recyclerView , List<T> list, int layoutResource, int[] itemResources ,  IViewHolderFactory<T> factory ) {
        this.list = list;
        this.holderFactory = factory;
        this.recyclerView = recyclerView;
        this.adapter = new RecyclerViewAdapter<T>(list , factory , layoutResource , itemResources);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public void setLayoutManager(RecyclerView.LayoutManager layout){
        recyclerView.setLayoutManager(layout);
    }

    public void setSwipe(boolean swipe){
        if (swipe){
            ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                    list.remove(viewHolder.getAdapterPosition());
                    adapter.notifyDataSetChanged();
                }
            };

            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
            itemTouchHelper.attachToRecyclerView(recyclerView);

        }
    }

    @Override
    public void present() {
        adapter.notifyDataSetChanged();
    }

    public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewAdapter<T>.ViewHolder> {

        List<T> mDataset;
        IViewHolderFactory<T> holderFactory;
        int     layoutResource;
        int[]   itemResources = new int[] {};

        public RecyclerViewAdapter(List<T> mDataset ,IViewHolderFactory<T> factory , int layoutResource , int[]   itemResources) {
            this.mDataset = mDataset;
            this.layoutResource = layoutResource;
            this.itemResources = itemResources;
            holderFactory = factory;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(layoutResource, parent, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(contactView , itemResources );
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            T obj = mDataset.get(position);
            holder.objectViewHolder.show(obj);
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public IViewHolder<T> objectViewHolder = holderFactory.createViewHolder() ;
            public ViewHolder(View itemView , int[] itemResources) {
                super(itemView);
                objectViewHolder.bind(itemView , itemResources);
            }
        }
    }
}
