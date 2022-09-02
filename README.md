# NLPTextProcessing
This program processes user text to provide user with count of - Sentences, Words, Nouns and Verbs within the text.

## Functionality
HTML page takes input text from user. The program processes the text and returns the following information on html page:
1. The text entered by user
2. Count of:
* Sentences
* Words
* Nouns
* Verbs

## Screenshots
<img width="500" alt="Entryform" src="https://user-images.githubusercontent.com/103872081/188039965-d44d5183-ea42-461d-9666-d731431d99e6.PNG">
 
<img width="500" alt="processed" src="https://user-images.githubusercontent.com/103872081/188040051-cb5cbd88-dab5-43eb-a556-f71a56a8b4cf.PNG">


## Technology

Java Servlet, HTML, Stanford CoreNLP, Apache Tomcat 8, Maven, Eclipse IDE

## Project Details

1. It is a dynamic web application with maven functionality and is created on Eclipse IDE and uses Apache Tomcat 8 server
2. On running, project displays a html page with a form where user can enter their text and submit the form
3. On submitting, request to sent to server. Through the web.xml file, correct servlet is fetched and Servlet 'DataProcessServlet' is called. 
4. Servlet collects the text from html page and calls the 'process' method of 'NLPProcessing class'.
4. The 'process' method of 'NLPProcessing' class uses Stanford coreNLP to process text and extract information about number of words, sentences, nouns and verbs
5. This information is returned to the Servlet 'DataProcessServlet' . Servlet sends this information as response back to the user


