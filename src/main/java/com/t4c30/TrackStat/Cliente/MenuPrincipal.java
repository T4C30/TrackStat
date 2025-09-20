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

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.t4c30.TrackStat.Goldberg.Juego;
import com.t4c30.TrackStat.Goldberg.Servidor;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;


/**
 *
 * @author T4C30
 */
public class MenuPrincipal {
    @FXML
    private TreeView listaJuego;

    @FXML
    private Menu cuentas;

    @FXML
    private Menu ayuda;

    @FXML
    private MenuItem logroGoldberg;  
    

    @FXML
    private void initialize() {
        ArrayList<Juego> listaJuegos = new ArrayList<>();
        File carpeta = new File("null");
        for (File juego : carpeta.listFiles()) {
            listaJuegos.add(new Juego(juego.getAbsolutePath()));
        }
        
        logroGoldberg.setOnAction(e -> {
            Servidor.rutaGoldberg(carpetaLogros());
        });

    }

    @FXML
    static Path carpetaLogros(){
        Window w = null;
        DirectoryChooser carpetaLogros = new DirectoryChooser();
        carpetaLogros.setTitle("Selector");
        File carpeta = carpetaLogros.showDialog(w);
        Path p = Paths.get(carpeta.getAbsolutePath());
        return p;
    }

    @FXML
    public static void alerta(String contenido){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
