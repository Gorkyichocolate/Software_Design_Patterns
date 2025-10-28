package Observer;

import Builder.Weather;

public interface Observer {
    void update(Weather weather);
}
