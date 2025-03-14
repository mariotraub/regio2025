const { app, BrowserWindow } = require('electron');
const path = require('path');

function createWindow() {
    // Erstelle ein Fenster
    let win = new BrowserWindow({
        width: 1024,
        height: 768,
        webPreferences: {
            nodeIntegration: true
        }
    });

    // Lade die lokale HTML-Datei, die von Thymeleaf generiert wird (z.B. index.html)
    win.loadURL('http://localhost:8080'); // Hier verweist du auf den Spring Boot Server
}

app.whenReady().then(createWindow);

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});

