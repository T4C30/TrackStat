/*
 * Copyright 2025 T4C30.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.t4c30.TrackStat.Cliente;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Popup;

/**
 *
 * @author T4C30
 */
public class Notificacion {



    public static void notificar(){
         if (!SystemTray.isSupported()) {
            System.out.println("La bandeja del sistema no está soportada.");
            return;
        }

        // Crear popup menu
        PopupMenu menu = new PopupMenu();
        MenuItem salir = new MenuItem("Salir");
        menu.add(salir);

        salir.addActionListener(e -> System.exit(0));

        Image icono = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(icono, "Mi App Notificadora", menu);
        trayIcon.setImageAutoSize(true);

        try {
            SystemTray.getSystemTray().add(trayIcon);

            // Mostrar notificación al iniciar
            trayIcon.displayMessage(
                "Bienvenido 👋",
                "La aplicación ahora está corriendo en segundo plano",
                TrayIcon.MessageType.INFO
            );

        } catch (AWTException e) {
            System.out.println("No se pudo agregar a la bandeja.");
        }
    }
    
}
