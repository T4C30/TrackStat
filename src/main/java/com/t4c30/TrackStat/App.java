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
package com.t4c30.TrackStat;

import java.io.IOException;
import java.util.Properties;

import com.t4c30.TrackStat.Goldberg.GestorJSON;
import com.t4c30.TrackStat.Goldberg.Juego;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 * @author T4C30
 */
public class App extends Application {

    @Override
    public void start(Stage ventana) throws IOException {
        Parent raiz = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        Scene escena = new Scene(raiz);
        ventana.setScene(escena);
        ventana.setTitle("App");
        ventana.show();
    }


    public static void main(String[] args) {
        Properties p = new Properties();
        GestorJSON.keySteamWebClient = p.getProperty("KeySteamWebClient");
        Juego.usuario = p.getProperty("Usuario");
        launch(args);
    }

}