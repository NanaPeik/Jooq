package ge.tsu.weather;

import ge.tsu.weather.classes.Tables;
import ge.tsu.weather.classes.tables.records.WeatherRecord;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

  @Autowired
  private DSLContext dslContext;

  @Override
  public void add(WeatherAdd weatherAdd) {
    WeatherRecord weatherRecord = dslContext.newRecord(Tables.WEATHER);
    BeanUtils.copyProperties(weatherAdd, weatherRecord);
    weatherRecord.insert();
  }

  @Override
  public void update(int id, WeatherAdd weatherAdd) {
    dslContext.update(Tables.WEATHER).set(Tables.WEATHER.WIND, weatherAdd.getWind())
        .set(Tables.WEATHER.CITY, weatherAdd.getCity())
        .set(Tables.WEATHER.HUMIDITY, weatherAdd.getHumidity())
        .set(Tables.WEATHER.REGION, weatherAdd.getRegion())
        .set(Tables.WEATHER.TEMP, weatherAdd.getTemp()).execute();
  }

  @Override
  public List<WeatherView> get(WeatherAdd weatherAdd) {
    SelectConditionStep conditionStep = (SelectConditionStep) dslContext.select()
        .from(Tables.WEATHER);
    if (weatherAdd.getCity() != null) {
      conditionStep.and(Tables.WEATHER.CITY.eq(weatherAdd.getCity()));
    }
    if (weatherAdd.getHumidity() != null) {
      conditionStep.and(Tables.WEATHER.HUMIDITY.eq(weatherAdd.getHumidity()));
    }
    if (weatherAdd.getRegion() != null) {
      conditionStep.and(Tables.WEATHER.REGION.eq(weatherAdd.getRegion()));
    }
    if (weatherAdd.getTemp() != null) {
      conditionStep.and(Tables.WEATHER.TEMP.eq(weatherAdd.getTemp()));
    }
    if (weatherAdd.getWind() != null) {
      conditionStep.and(Tables.WEATHER.WIND.eq(weatherAdd.getWind()));
    }
    List<WeatherRecord> records = conditionStep.fetch().into(WeatherRecord.class);
    return (List<WeatherView>) records.stream().map(this::map);
  }

  @Override
  public void delete(int id) {
    dslContext.deleteFrom(Tables.WEATHER).where(Tables.WEATHER.ID.eq(id)).execute();
  }

  @Override
  public WeatherView getById(int id) {
    WeatherRecord weatherRecord = dslContext.select().from(Tables.WEATHER)
        .where(Tables.WEATHER.ID.eq(id)).fetchOne().into(WeatherRecord.class);
    return map(weatherRecord);
  }

  private WeatherView map(WeatherRecord weatherRecord) {
    WeatherView weatherView = new WeatherView();
    weatherView.setId(weatherRecord.getId());
    weatherView.setCity(weatherRecord.getCity());
    weatherView.setHumidity(weatherRecord.getHumidity());
    weatherView.setRegion(weatherRecord.getRegion());
    weatherView.setWind(weatherRecord.getWind());
    return weatherView;
  }
}
