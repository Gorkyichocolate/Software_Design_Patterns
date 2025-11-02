package TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import RabbitMQ.Send;
import RabbitMQ.Recv;
import Observer.WeatherSubject;
import Observer.WeatherObserver;
import Notfications.TelegramBot;
import StrategyWeather.*;
import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {
    private static Bot instance;
    private static WeatherSubject weatherSubject;
    private static Map<Long, WeatherObserver> userObservers = new HashMap<>();

    public Bot() {
        instance = this;
        weatherSubject = new WeatherSubject();
    }

    public static Bot getInstance() {
        return instance;
    }

    @Override
    public String getBotUsername() {
        return "WeatherApp_SDP_Bot";
    }

    @Override
    public String getBotToken() {
        return "8389015410:AAFy7E_pQkXep_QGcIrrz0rH1-jUJ-QMm5I";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            Long chatId = update.getMessage().getChatId();

            if (message.startsWith("/")) {
                handleCommand(chatId, message);
            } else {
                String city = message.toLowerCase();
                handleCityRequest(chatId, city);
            }
        }
    }

    private void handleCommand(Long chatId, String command) {
        if (command.equals("/start")) {
            sendText(chatId, "Choice type of Notifications\n\n" +
                    "Commands:\n" +
                    "/minute - notifications every minute \n" +
                    "/hour - notifications every hour \n" +
                    "/daily - notifications every day\n" +
                    "/stop - stop notifications");

            if (!userObservers.containsKey(chatId)) {
                TelegramBot notifier = new TelegramBot(chatId);
                Strategy strategy = new ConcreteStrategyMinute();
                WeatherObserver observer = new WeatherObserver("User_" + chatId, notifier, strategy);
                weatherSubject.addObserver(observer);
                userObservers.put(chatId, observer);
            }
        } else if (command.equals("/minute")) {
            updateStrategy(chatId, new ConcreteStrategyMinute(), "Minute notifications");
        } else if (command.equals("/hour")) {
            updateStrategy(chatId, new ConcreteStrategyHour(), "Hour notifications");
        } else if (command.equals("/daily")) {
            updateStrategy(chatId, new ConcreteStrategyDaily(), "Daily notifications");
        } else if (command.equals("/stop")) {
            WeatherObserver observer = userObservers.get(chatId);
            if (observer != null) {
                observer.stopNotifications();
                sendText(chatId, "Stoping notifications");
            }
        }
    }

    private void updateStrategy(Long chatId, Strategy strategy, String message) {
        WeatherObserver observer = userObservers.get(chatId);
        if (observer != null) {
            observer.setIntervalStrategy(strategy);
            sendText(chatId, message);
        } else {
            sendText(chatId, "/start");
        }
    }

    private void handleCityRequest(Long chatId, String city) {
        sendText(chatId, "City: " + city);

        try {
            Send.sendCityRequest(city);
            sendText(chatId, "request sended ");
        } catch (Exception e) {
            sendText(chatId, "Error: " + e.getMessage());
        }
    }

    public void sendText(Long chatId, String what) {
        SendMessage sm = SendMessage.builder().chatId(chatId.toString()).text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Send.initialize();

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        botsApi.registerBot(bot);

        Recv.setWeatherSubject(weatherSubject);
        Recv.startListening();

    }
}
