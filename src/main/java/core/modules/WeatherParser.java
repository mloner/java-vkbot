package core.modules;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WeatherParser {
    private String city = "volgograd";
    private Document doc;
    public WeatherParser() throws IOException {
        doc = Jsoup.connect(String.format("https://world-weather.ru/pogoda/russia/%s/",city)).get();
    }
    WeatherParser(String city) throws IOException {
        this.city = city;
        doc = Jsoup.connect(String.format("https://world-weather.ru/pogoda/russia/%s/",city)).get();
    }


    public String getWeatherTodayDescription() {
        Elements elements = doc.select("span.dw-into");
        return elements.text().split("Подробнее")[0];
    }

}
