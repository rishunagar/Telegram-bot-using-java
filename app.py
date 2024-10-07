# this is code for " iCloud EMS integrated with Telegram bot"
import telebot

Token = "6790259664:AAHBY8aL-bAhp_Bvw3FGlkB1mFyj0sqmB0E"

bot = telebot.TeleBot(Token)

# a function to handle a text message


@bot.message_handler(['start'])
def start(message):
    bot.reply_to(message, "Welcome to GU bot \n How can I help you")


# This is decorter for help command
@bot.message_handler(['help'])
def help(message):
    bot.reply_to(message, """/start -> Greeting
     /help -> See commands list 
     /icloud -> iCLoud EMS link  
     /lms -> GU LMS link  
     /GU_eliberay -> GU eLIBRARY link                    
     """)

# this is for icloud command


@bot.message_handler(['icloud'])
def link(message):
    bot.reply_to(
        message, "https://t.me/Galgotias_University_bot/Icloudemstelebot")


# this is for GU LMS
@bot.message_handler(['lms'])
def link(message):
    bot.reply_to(message, "https://t.me/Galgotias_University_bot/GuLMS")

# this is for GU eLIBRARY


@bot.message_handler(['GU_eliberay'])
def link(message):
    bot.reply_to(message, "https://t.me/Galgotias_University_bot/Gu_eLIBRARY")

# This is a default message when cmd is invalid


@bot.message_handler()
def custom(message):
    msg = "This is invalid command"
    bot.reply_to(message, msg)


# polling used to continuously check for new updates
bot.polling()