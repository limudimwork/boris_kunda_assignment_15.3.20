package com.assignment.boris_kunda_assignment_15320.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.boris_kunda_assignment_15320.R;
import com.assignment.boris_kunda_assignment_15320.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> mMovieList;
    private OnMovieClickListener mOnMovieClickListener;
    private Context mContext;

    public MovieAdapter (OnMovieClickListener iOnMovieClickListener, Context iContext) {
        mMovieList = new ArrayList<>();
        mOnMovieClickListener = iOnMovieClickListener;
        mContext = iContext;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder (@NonNull MovieViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        holder.bind(mMovieList.get(position), mOnMovieClickListener);
        holder.mMovieTitleTv.setText(movie.getTitle());
        Picasso.get().load(movie.getImageUrl()).placeholder(R.drawable.movie_place_holder).error(R.drawable.error).into(holder.mMoviePosterIv);
    }

    @Override
    public int getItemCount () {
        return mMovieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView mMovieTitleTv;
        private ImageView mMoviePosterIv;

        MovieViewHolder (@NonNull View itemView) {
            super(itemView);
            mMovieTitleTv = itemView.findViewById(R.id.movie_item_title_tv);
            mMoviePosterIv = itemView.findViewById(R.id.movie_item_poster_iv);
        }

        void bind (Movie iMovie, OnMovieClickListener iOnMovieClickListener) {
            itemView.setOnClickListener(v -> mOnMovieClickListener.onMovieClick(iMovie));
        }

    }

    public void setMovieList (List<Movie> iMovieList) {
        mMovieList = iMovieList;
        notifyDataSetChanged();
    }

    public interface OnMovieClickListener {

        void onMovieClick (Movie iMovie);

    }


}
