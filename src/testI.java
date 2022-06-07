import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;
public class testI {

    public static int totalFilms;
    public static int currentTime;

    public static void main(String[] args) {
        currentTime = 1;
        Scanner input = new Scanner(System.in);
        totalFilms = input.nextInt();
        List<Film> films = IntStream.range(1, totalFilms + 1)
                .mapToObj(number -> new Film(number, input.nextInt(), input.nextInt(), input.nextInt())).collect(Collectors.toList());


        List<Film> filmsToWatch = new ArrayList<>();

        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getStart() < currentTime) {
                continue;
            }
            Film nextFilm = films.get(i);

            for (int j = i + 1; j < films.size(); j++) {
                Film possibleNextFilm = films.get(j);
                if (possibleNextFilm.getStart() >= nextFilm.getEnd()) {
                    break;
                } else if (possibleNextFilm.getRating() > nextFilm.getRating()) {
                    nextFilm = possibleNextFilm;
                    i = j;
                }
            }
            filmsToWatch.add(nextFilm);
            currentTime = nextFilm.getEnd();
        }

        System.out.println(filmsToWatch.size());
        String filmsToWatchLine = filmsToWatch.stream()
                .map(film -> String.valueOf(film.getNumber()))
                .collect(Collectors.joining(" "));
        System.out.print(filmsToWatchLine);
    }


    public static class Film {

        private final int number;
        private final int start;
        private final int end;
        private final int rating;

        public Film(int number, int start, int end, int rating) {
            this.number = number;
            this.start = start;
            this.end = end;
            this.rating = rating;
        }

        public int getNumber() {
            return number;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return "Film{" +
                    "number=" + number +
                    ", start=" + start +
                    ", end=" + end +
                    ", rating=" + rating +
                    '}';
        }
    }
}