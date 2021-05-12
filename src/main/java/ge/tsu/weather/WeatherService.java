package ge.tsu.weather;

import java.util.List;

public interface WeatherService {
  void add(WeatherAdd weatherAdd);
  void update(int id, WeatherAdd weatherAdd);
  List<WeatherView> get(WeatherAdd weatherAdd);
  void delete(int id);
  WeatherView getById(int id);
}
