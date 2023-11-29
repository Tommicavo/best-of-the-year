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
		model.addAttribute("movies", movies);
		return "movies";
	}
	
	private List<Movie> getBestMovies() {
		
		int id = 1;
		List<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie(id++, "Movie title 1"));
		movies.add(new Movie(id++, "Movie title 2"));
		movies.add(new Movie(id++, "Movie title 3"));
		movies.add(new Movie(id++, "Movie title 4"));
		movies.add(new Movie(id++, "Movie title 5"));

		return movies;
	}
	
	@GetMapping("/movies/{id}")
	public String movie(Model model, @PathVariable int id) {

		List<Movie> movies = getBestMovies();
		
		for (Movie movie : movies) {
			if (movie.getId() == id) {
				model.addAttribute("movie", movie);
				break;
			}
		}
		return "movie";
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
		
		List<Song> songs = getBestSongs();
		model.addAttribute("songs", songs);
		return "songs";
	}
	
	private List<Song> getBestSongs() {
		
		int id = 1;
		List<Song> songs = new ArrayList<>();
				
		songs.add(new Song(id++, "Song title 1"));
		songs.add(new Song(id++, "Song title 2"));
		songs.add(new Song(id++, "Song title 3"));
		songs.add(new Song(id++, "Song title 4"));
		songs.add(new Song(id++, "Song title 5"));

		return songs;
	}
	
	@GetMapping("/songs/{id}")
	public String song(Model model, @PathVariable int id) {

		List<Song> songs = getBestSongs();
		
		for (Song song : songs) {
			if (song.getId() == id) {
				model.addAttribute("song", song);
				break;
			}
		}
		return "song";
	}
}
