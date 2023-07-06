/*
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

public class AudioBot implements LongPollingBot {

    // Bot tokenini o'zgartiring
    private static final String BOT_TOKEN = "Sizning_bot_tokeningiz";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new AudioBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasAudio()) {
            Message message = update.getMessage();
            Audio audio = message.getAudio();
            String fileId = audio.getFileId();
            String title = message.getText();

            // Audiolar bilan ishlash uchun kodlar
            // fileId orqali audioning ID-sini olishingiz mumkin

            try {
                SendVoice sendVoice = new SendVoice();
                sendVoice.setChatId(message.getChatId());
                sendVoice.setVoice(new InputFile(fileId));
                sendVoice.setCaption(title);

                // Audioning qayta jo'natish
                execute(sendVoice);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "AudioBot";
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
*/
