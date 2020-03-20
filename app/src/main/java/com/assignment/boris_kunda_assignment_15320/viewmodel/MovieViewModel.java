package com.assignment.boris_kunda_assignment_15320.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.assignment.boris_kunda_assignment_15320.model.Movie;
import com.assignment.boris_kunda_assignment_15320.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    // TODO: 3/19/2020 check about single Live-data for popup
    //todo pass next screen only if load db/api successful


    private MovieRepository mMovieRepository;


    public MovieViewModel (@NonNull Application application) {
        super(application);
        mMovieRepository = MovieRepository.getMovieRepository(application);

    }

    public LiveData<List<Movie>> getMovieListLD () {
        return mMovieRepository.getMoviesListLD();
    }

    public LiveData<Boolean> displayMovieExistsPopUpLd () {
        return mMovieRepository.displayMovieAlreadyExistsPopUpMd();
    }

    public void loadMoviesList () {
        mMovieRepository.loadMoviesListFromApi();
    }

    public void updateDbOrDisplayPopUp (Movie iMovie) {
        mMovieRepository.updateDbOrDisplayPopUp(iMovie);// TODO: 3/18/2020 single live data
    }

}
