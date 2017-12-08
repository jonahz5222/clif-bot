 Clif the Water Polo Bot Documentation

    This application was developed for use by the University of Missouri Water Polo Club by Jonah Zukosky for CMP_SC 3330's final project. It's purpose is to make weekly reminders easier for the team and to more efficiently provide information about practices to all members of the club. It will be hosted on a free server so it will always be running, checking to send messages.

    Messages are stored in an ArrayList as an attribute of the Bot Singleton Class, then accessed by the Controller either through an instance of this singleton bot or through the main model. This arrayList can be updated via the message view controller, and is displayed in a table view on the main view. This is all for user interfacing. The actually functionality is contained in the main model, which checks the current date against the message.date attribute (accessed through message.getDate()) and once the date matches, it will check the time attribute of the message and sleep the program until it is time to display the message, at which time it will send the string attribute of the message to the server using the MessageSender.java class, posting the string in the GroupMe chat.



			 	 ————Requirements————

——————————————————————————
	Classes
——————————————————————————

For this project, there were two main classes that I created.

First, **Bot.java**, which is a singleton class designed to hold the attributes of my bot, including API key, name, and its list of messages.

Second, **Message.java**, which was designed to hold the attributes of each message that populates the messageList of the bot. These include title, message, date, time, and frequency.


——————————————————————————
	Subclasses
——————————————————————————

 Each of my ViewControllers extends the Switchable class **(LoginViewController.java line 28, MainViewController.java line 34, MessageViewController.java line 30)**

——————————————————————————
	Abstract Class
——————————————————————————

There are two abstract classes in my project, **LoginModel.java (found on line 13)** and **Switchable.java (found on line 20)**

———————————————————————————
	 Interface
———————————————————————————

I utilize an interface for my serialization functions in my Main View Controller. It is implemented on line 34 of MainViewController.java. The interface is SerializationInterface.java.

———————————————————————————
	 Collection Class
———————————————————————————

I utilize an ArrayList<Message> (where message is my class created to hold messages) throughout my program, but it originates in the Bot class, as it is an attribute of the bot. This is in **Bot.java on line 21**.

———————————————————————————
	Exception Handling
———————————————————————————

There is exception handling throughout the program, but primarily it takes place in **Jbzmv8WaterPoloGroupMeBot.java on lines 49-53 ** and in **MessageSender.java on lines 22-49**.

———————————————————————————
	Models
———————————————————————————

    I utilize multiple models for this project, LoginModel.java and MainModel.java, and MessageModel.java. Along with those, other data manipulation occurs with my classes, Bot.java and Message.javaThe former handles the data of the LoginView, primarily checking the username and password and returning a boolean. The MainModel handles holding the messageList and running the timer that sends the actual messages to the server.

———————————————————————————
	Multiple Scenes
———————————————————————————

There are three scenes utilized in my project

1. LoginView.fxml

        * Checks the username and password, and if correct, moves to MainView

        
2. MainView.fxml

        * From MainView, the user sees a table of all messages scheduled and can either logout, going back to LoginView.fxml (Accessed in the 'Help' MenuItem) or create a new message, going to MessageView.fxml (Accessed using either the Create Message Button in the Scene or in the 'File' MenuItem)

        
3. MessageView.fxml

        * Accessed from MainView.fxml, you can create a new message in this view. You can go back to the MainView by pressing Cancel or Submit.
        

I utilized the Switchable class that we worked on together in class to move between views. This code can be found in Switchable.java (on all lines). Switchable.switchTo is called in the controllers of each view (LoginViewController.java : 76) (MainViewController.java : 71 (handleLogoutButton()),MainViewController.java : 100 (handleMessageButton()))  (MessageViewController.java : 101 (handleSubmit()), MessageViewController : 116 (handleCancel()))
    
——————————————————————————————————————————————————————
Scene data based on application data change
——————————————————————————————————————————————————————

Scene data is primarily updated via the user changing application data in the Main View, concerning the MessageList ArrayList and populating the tableView in that scene with the list. The method that handles this update is updateMessageList() and is called on **line 113 of MainViewController.java**. This method loads the messageList into the tableView and is called after a new message (or set of messages) is created.
    
——————————————————————————————
	About Information
——————————————————————————————

About information can be accessed in the program by clicking on the "Help" MenuItem in either the LoginView or the MainView

The code for this information can be found in **MainViewController.java on line 55**. The method is entitled handleAboutButton

——————————————————————————————————————————————————————
	Saving and Loading Data
——————————————————————————————————————————————————————


Saving and loading data is accomplished by saving the messageList on either close or by pressing the "Save Clif" button in the File MenuItem. The message ArrayList is parsed into JSON and written to a file, bot.txt which is stored in the project directory. Then, when the Main View initializes, the bot is initialized from bot.txt. This is all accomplished using Jackson for Java. Occurs on lines 75(handleSaveBot()) and 154(deserializer()) of MainViewController.java and also line 40 of Jbzmv8WaterPoloGroupMeBot.java, as a part of a OnCloseRequest.


