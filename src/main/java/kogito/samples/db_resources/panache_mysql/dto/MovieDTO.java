package kogito.samples.db_resources.panache_mysql.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kogito.samples.db_resources.panache_mysql.entity.Movie;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    public Long id;
    public String title;
    public String director;

    //@JsonbDateFormat("yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate releaseDate;

    public static MovieDTO from(Movie movie) {
        return MovieDTO
                .builder()
                .id(movie.id)
                .releaseDate(movie.releaseDate)
                .title(movie.title)
                .director(movie.director)
                .build();
    }

    public static List<MovieDTO> from(List<Movie> actor) {
        return actor.stream().map(MovieDTO::from)
                .collect(Collectors.toList());

    }
}
