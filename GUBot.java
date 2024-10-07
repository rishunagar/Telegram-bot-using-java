import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class GUBot extends TelegramLongPollingBot {

    private static final String BOT_TOKEN = "6790259664:AAHBY8aL-bAhp_Bvw3FGlkB1mFyj0sqmB0E";
    private static final String BOT_USERNAME = "GalgotiasUniversityBot";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":
                    sendResponse(chatId, "Welcome to GU bot \n How can I help you");
                    break;
                case "/help":
                    sendResponse(chatId, "/start -> Greeting\n/help -> See commands list\n/icloud -> iCloud EMS link\n/lms -> GU LMS link\n/GU_eliberay -> GU eLIBRARY link");
                    break;
                case "/icloud":
                    sendResponse(chatId, "https://t.me/Galgotias_University_bot/Icloudemstelebot");
                    break;
                case "/lms":
                    sendResponse(chatId, "https://t.me/Galgotias_University_bot/GuLMS");
                    break;
                case "/GU_eliberay":
                    sendResponse(chatId, "https://t.me/Galgotias_University_bot/Gu_eLIBRARY");
                    break;
                default:
                    sendResponse(chatId, "This is an invalid command");
                    break;
            }
        }
    }

    private void sendResponse(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public static void main(String[] args) {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new GUBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
