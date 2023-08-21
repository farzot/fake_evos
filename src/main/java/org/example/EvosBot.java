package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class EvosBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("hello");
//        ReplyKeyboardMarkup maniKlaviaturam=new ReplyKeyboardMarkup();
//        List<KeyboardRow> KlaviaturaQatorilari=new ArrayList<>();
//       // KlaviaturaQatori1.add(new KeyboardRow());
//        KeyboardRow qator1=new KeyboardRow();
//        qator1.add(new KeyboardButton("English"));
//        qator1.add(new KeyboardButton("Russian"));
//        qator1.add(new KeyboardButton("Uzbek"));
//        KlaviaturaQatorilari.add(qator1);
//
//        KeyboardRow qator2=new KeyboardRow();
//        qator2.add(new KeyboardButton("Chenise"));
//        qator2.add(new KeyboardButton("Kazak"));
//        KlaviaturaQatorilari.add(qator2);
//
//
//        maniKlaviaturam.setKeyboard(KlaviaturaQatorilari);
//        SendMessage xabarYuborish=new SendMessage();
//        xabarYuborish.setReplyMarkup(maniKlaviaturam);
//        xabarYuborish.setChatId(update.getMessage().getChatId());
//        //xabarYuborish.setText("Ishlamayapti");
//        try {
//            execute(xabarYuborish);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }

        long chatID = update.getMessage().getChatId();

        Message xabar = new Message();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);

        //agar uptade da yangiXabar bo'lsa
        if (update.hasMessage())
            //shu xabarni colsolega chiqaramiz
            //   System.out.println(update.getMessage());
            //  System.out.println(update.getMessage().getText());
            //xabarni user ga otish
            if (update.getMessage().getText().equals("/salom")) {

                xabar.setText("Assalomu aleykum");


                sendMessage.setText(xabar.getText());
            }
            else if (update.getMessage().getText().equals("/xayr")) {

                xabar.setText("Xayr salomat bo'ling");
                sendMessage.setText(xabar.getText());
            }
            else if(update.getMessage().getText().equals("/tanishish")){
                xabar.setText("Ismingiz nima?");
                sendMessage.setText(new HttpClientMain().sending());

                update.getMessage().getText();
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                xabar.setText("Tanishganimdan xurandman");
                sendMessage.setText(update.getMessage().getText()+xabar.getText());


            }

//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public String getBotUsername() {
        return "ooopiiiBot";
    }

    @Override
    public String getBotToken() {
        return "6517799145:AAHtGKU9L6QuANP2ukR5IYP4j4Vy-vGI95E";
    }
}
