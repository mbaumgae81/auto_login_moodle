
/**
 *
 *  @ author M.Baumgärtner
 *
 *
 */



package autolog;


import dev.failsafe.internal.util.Assert;
import net.sourceforge.htmlunit.corejs.javascript.serialize.ScriptableOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main extends HtmlUnitDriver {

	public static void main(String[] argv) throws InterruptedException {
		// -------> starte Config
		LocalDateTime myObj = LocalDateTime.now(); // Create a date object
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myObj.format(myFormatObj);
		String searchKeinunterricht = "Heute kein Unterricht!";
		String searchAStarten = "Achtung bitte Zeiterfassung starten!";
		String searchStartz = "Startzeit";
		String searchEndz= "Endzeit";

		String argu_1 = "null";
		String argu_2 = "null";
		String argu_3 = "null";
		boolean debug = false;
		int laenge = 0;
		int waitTime = 0;
		laenge = argv.length;

		int random = (int) (Math.random() * 1000 + 1);
		waitTime = random;
		waitTime *= 300;
		WebDriver driver = new HtmlUnitDriver();
		String page_source = driver.getPageSource();
		// ------> alles gesetzt

		if (laenge >= 3) {
			argu_1 = argv[0];
			argu_2 = argv[1];
			argu_3 = argv[2];

		} else {
			System.out.println("Es wurden nicht alle Paramerter angegeben, Benutzername, Passwort, EIN / AUS");
		}

		// Fehler von Selenium und Webabrufen deaktivieren
		// Disable CSS errors
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		//
		Thread.sleep(waitTime);

		System.out.println("---------------------" + formattedDate + "------------------------------");
		driver.get("https://lernplattform.gfn.de/login/index.php");

		System.out.println("Page title is: " + driver.getTitle());

		driver.findElement(By.id("username")).sendKeys(argu_1); // Find and enter in Username Field
		Thread.sleep(1000);

		driver.findElement(By.id("password")).sendKeys(argu_2); // Find and enter Password
		Thread.sleep(1000);
		driver.findElement(By.id("loginbtn")).click();          // Find and click Login Botton

		Thread.sleep(10000);


        System.out.println("Page title is: " + driver.getTitle());






		// Ein soll durchgeführt werden //
		if (argu_3.equalsIgnoreCase("EIN")) {
			page_source = driver.getPageSource();		// Lade Page
			if (page_source.contains(searchAStarten)){	//Wenn Seach Starten gefunden wird
				System.out.println("Starte Zeit\n");
				driver.get("https://lernplattform.gfn.de/?starten=1");
				Thread.sleep(1000);
				// Prüfe ob erfoglreich
				page_source = driver.getPageSource();
				if (page_source.contains(searchStartz)){
					System.out.println("Anmeldung erfolgt");
				}
			}

		} else if (argu_3.equalsIgnoreCase("AUS")) {

			page_source = driver.getPageSource();
			if (page_source.contains(searchStartz)){
				System.out.println("Stoppe Zeit");
				System.out.println("Page title is: " + driver.getTitle());
				driver.get("https://lernplattform.gfn.de/?stoppen=1");
				Thread.sleep(1000);
				// Prüfe ob erfoglreich
				page_source = driver.getPageSource();
				if (page_source.contains(searchEndz)){
					System.out.println("Abmeldung erfolgt");
				}

			}



		} else
			System.out.println("Falscher Parameter übrgeben");

		System.out.println("---------------------------------------------------------------------");

		driver.quit();
	}


}
