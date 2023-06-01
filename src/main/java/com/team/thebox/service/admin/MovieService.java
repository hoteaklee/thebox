package com.team.thebox.service.admin;

import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface MovieService {
    Map<String, Object> newMovies(Movie movie);
    boolean newMovies2(Movie movie);
    boolean newMovieAttach(MultipartFile attach, Map<String, Object> mvinfo);

    Movie readOneMovie(int movno);

    Map<String, Object> readMovie(Integer cpg);
    List<String> readMovieTitle(long movno);
    List<Movie> readMovnoAndTitle();

    boolean newMovieSchedule(MovieSchedule movsch);

    List<MovieSchedule> readSchedule();

    List<Integer> readBookedCnt();
    Map<String, Object> readMovieSchedule(Long movno, Long schno);
}