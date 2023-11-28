package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(Model model) {
		
		String name = "Tommi";
		
		model.addAttribute("name", name);
		
		return "home";
	}
	
	@GetMapping("/movies")
	public String movies(Model model) {
		
		
		List<Movie> movies = getBestMovies();
		
		String movieTitles = "";
		for (Movie movie : movies) {
			movieTitles += ", " + movie.getTitle();
		}
		model.addAttribute("movieTitles", movieTitles.substring(2, movieTitles.length()));
		
		return "movies";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		
		Movie m1 = new Movie(1, "Movie 1 title");
		Movie m2 = new Movie(2, "Movie 2 title");
		Movie m3 = new Movie(3, "Movie 3 title");
		Movie m4 = new Movie(4, "Movie 4 title");
		Movie m5 = new Movie(5, "Movie 5 title");
		
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
		
		return movies;
	}
	
	@GetMapping("/movies/{id}")
	public String movie(Model model, @PathVariable int id) {

		List<Movie> movies = getBestMovies();
		
		for (Movie movie : movies) {
			if (movie.getId() == id) {
				model.addAttribute("title", movie.getTitle());
				break;
			}
		}
		return "movie";
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
		
		
		List<Song> songs = getBestSongs();
		
		String songTitles = "";
		for (Song song: songs) {
			songTitles += ", " + song.getTitle();
		}
		model.addAttribute("songTitles", songTitles.substring(2, songTitles.length()));
		
		return "songs";
	}
	
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		
		Song s1 = new Song(1, "Song 1 title");
		Song s2 = new Song(2, "Song 2 title");
		Song s3 = new Song(3, "Song 3 title");
		Song s4 = new Song(4, "Song 4 title");
		Song s5 = new Song(5, "Song 5 title");
		
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		songs.add(s5);
		
		return songs;
	}
	
	@GetMapping("/songs/{id}")
	public String song(Model model, @PathVariable int id) {

		List<Song> songs = getBestSongs();
		
		for (Song song : songs) {
			if (song.getId() == id) {
				model.addAttribute("title", song.getTitle());
				break;
			}
		}
		return "song";
	}
}
