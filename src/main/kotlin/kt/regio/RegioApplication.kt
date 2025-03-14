package kt.regio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.awt.Desktop
import java.net.URI;

@SpringBootApplication
class RegioApplication

fun main(args: Array<String>) {
	try {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			Desktop.getDesktop().browse(URI("http://localhost:8080/"))
		}
	} catch (e: Exception) {
		System.err.println("Failed to open browser: ${e.message}")
	}
	runApplication<RegioApplication>(*args)
}
