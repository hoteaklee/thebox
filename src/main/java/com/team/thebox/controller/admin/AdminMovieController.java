package com.team.thebox.controller.admin;

import com.team.thebox.domain.Movie;
import com.team.thebox.service.admin.AdminMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/management/movie")
@Controller
public class AdminMovieController {
    private final AdminMovieService adminMovieService;
    @Autowired
    public AdminMovieController(AdminMovieService adminMovieService) {
        this.adminMovieService = adminMovieService;
    }
    @GetMapping("/movielist")
    public String movieList(){

        return "management/movielist";
    }
    @GetMapping("/register")
    public String showMovieForm(Model m){
        m.addAttribute("movie", new Movie());

        return "management/movieregister";
    }
    @PostMapping("/register")
    public String submitMovieForm(Movie movie, MultipartFile attach) {
        String viewPage = "/management/movieregister";


        if(adminMovieService.saveMovie(movie)) {
            viewPage = "redirect:/management/movielist";
        }
        return viewPage;
    }

    @GetMapping("/schedule/resgister")
    public String movieScheduleRegister(){
        return "management/moviescheduleregister";

    }

    @GetMapping("/schedule")
    public String movieScheduleList(){
        return "management/movieschedulelist";

    }
    @GetMapping("/schedule/calendar")
    public String movieScheduleListCalendar(){
        return "management/movieschedulecalendar";

    }


}