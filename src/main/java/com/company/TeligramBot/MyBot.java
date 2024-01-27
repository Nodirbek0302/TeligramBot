package com.company.TeligramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaAudio;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasAudio() || message.hasVoice()) {


                String fileId = message.getAudio().getFileId();

                String title = message.getAudio().getTitle();
                System.out.println(title);
                String oneTitle = title.substring(0, title.indexOf("-"));
                String twoTitle = title.contains("(")?title.substring(title.indexOf("-")+1,title.indexOf("(")-1):title.substring(title.indexOf("-")+1);;


                Runnable runnable = () -> {
                    SendAudio audio1 = new SendAudio();
                    audio1.setCaption(oneTitle.trim() + ":" + twoTitle.trim());
                    audio1.setChatId("@mp3_li");
                    audio1.setAudio(new InputFile(fileId));

                    try {
                        execute(audio1);
                    } catch (TelegramApiException e) {
                       e.printStackTrace();
                    }
                };
                new Thread(runnable).start();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@nodiraudio_bot";
    }

    @Override
    public String getBotToken() {
        return "6004328792:AAGSMZCZkJNQeIqmOrb9TmfZX-W1-oCE_hg";
    }
}
