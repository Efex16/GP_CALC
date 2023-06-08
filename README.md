
## Table of content

- [GP_CALC](#GP_CALC)
- [Team](#Team)
- [Technologies](#Technologies)
- [Challenge](#Challenge)
- [Risks](#Risks)
- [Infrastructure](#Infrastructure)
- [Existing Solutions](#Existing Solutions)

## GP_CALC

GP_CALC is an android app that can accept inputted courses score and calculate the Grade Point Average (GPA) of a maximum of 9 courses being offered on a grade scale of 4.00 and 5.00.

## Team

This project was solely written by Elijah Efe-Osadolor (Efex16). 

## Technologies

### Compiller

- Extensible Markup Language (XML) 1.0

### Tools

- Android Studio

### Programming Language

- Java

### List of libraries

- https://developer.android.com/topic/libraries/support-library/androidx-rn

### An alternate technology which can be use for this project is Visual Studio Code instead of Android Studio which i preferred to use due to the following factors stated below:

### Visual Studio Code vs Android Studio – Functionality and Search

⚙ Functionality: How easy is it is to get around my code? Can I tear tabs off and work on my code with more than one window open at a time?

🔎Search: Is it straightforward to find where a certain widget has been used in my app? If I forget the implementation of something, can I easily search and find if it has been used somewhere else?

# Functionality

- Visual Studio Code: You can split your tabs so that one window is split down the middle or you can try to reopen the same project in another instance of Visual Studio Code. But you can’t just tear the tabs off.

The practical effect of this is that if you are working between your services and your UI layer, you have to switch back and forth between both files until you eventually solve the issue.

- Android Studio: In terms of tearing the tabs off: Well, you just do it. You just pick one up, drag it off, and you’re done. You can put these onto alternate screens – whatever you want. Any comparable solution to doing this in Visual Studio Code (that’s as easy as just grabbing the tab and moving it to where you want it) doesn’t seem to exist, at least not at the time of writing.

For me personally, this is enough to make me want to use Android Studio by itself, but let’s press on.

# Searching in the project

- Visual Studio Code has the ability to “search anywhere” in the project when the user presses CTRL+SHIFT+F. Search anywhere

As we can see, I’ve searched for Sonder, and on the left-hand side of this window we have all the results. You can move backwards and forwards through them with F4 and SHIFT+F4. It’s certainly functional.

The only gripe I have with this search feature is that you tend to lose a lot of context when searching. We’re restricted to looking at each and every result of our search here, either by clicking on a specific result or using hotkeys to move through them. Afterwards, we can get back to where we were by clicking on the appropriate tab up at the top or hitting ALT+LEFT ARROW until we get back to where we were. Sometimes when I do that, I forget where I was up to and what I was doing initially.

- Android Studio

Again, CTRL+SHIFT+F. But this time, we get a dedicated search dialog.

If we search for something, like Sonder, we get the results in this dialog:

Pressing the up or down cursors here will show us results from that particular file, as well as the 8–9 lines on either side of that search result. Search results

Sometimes, I’m searching for an implementation of a certain widget or function, and then I just quickly hit CTRL+SHIFT+F to bring up this dialog. Doing so, I can quickly move through the list by using the up and down arrows, and when I have found what I’m looking for, I can just hit escape to go back to the file I was working on initially. In terms of productivity, I find this is more powerful and faster.

## Challenge

- This portfolio is targetted at solving and making it easy for calculation of Grade Point Average (GPA) by only administrative authorized person.

- This portfolio will not solve the issue of inputting the calculated GPA into a database for documentation. it's basically for calculating GPA.

- This portfolio is targetted on academic administrative staffs who are sattled with the responsibility of calulating departmental GPA of students before final inputation into the school database.

- This project is relevant to higher institution setting, both the institutionS scaling on 4.00 GPA and 5.00 GPA.

## Risks

I built an internal RESTful API for this web application so that data can be flexibly retreived from the MySQLdb. All available endpoints can be found in the `api.v1.views` directory. Here's a description of each endpoint:
     
## Infrastructure

- All my code is been written and compilled in Android studio and it's been push to a github repository cloned for proper documentation.

- I intend to populate the app by sharing the built akp app-debug file.

- An android phone will be configured to accept usb debugging via the developer setting of the phone for testing purpose during the developing of the app or alternatively an APK file will be built for direct installation on any android phone for testing purpose.


## Existing Solutions

Shout-out to [Open Lyrics Database](https://github.com/Lyrics/lyrics) for the lyrics shown!

Licenses for images from Wikimedia Commons:

* [The xx at the Alcatraz.jpg](https://commons.wikimedia.org/wiki/File:The_xx_at_the_Alcatraz.jpg)
* [Adele Live 2016 tour.jpeg](https://commons.wikimedia.org/wiki/File:Adele_Live_2016_tour.jpeg)
* [Paul Simonon The Clash September 20 1979 Palladium NYC.jpg](https://commons.wikimedia.org/wiki/File:Paul_Simonon_The_Clash_September_20_1979_Palladium_NYC.jpg)

## Future

- In expanding the functionality of the portfolio, i intend to integrate a student log-in where student can only have access to their GPA score. 

- I intend in integrating a link for the output of the portfolio to be an input to the school result database.

[Github](https://github.com/efex16)
[LinkedIn](https://www.linkedin.com/in/david-kwan-1b0930129/)
[Twitter](https://twitter.com/davidwkwan)
