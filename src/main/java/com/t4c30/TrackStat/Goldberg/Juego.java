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
package com.t4c30.TrackStat.Goldberg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import com.t4c30.TrackStat.Cliente.MenuPrincipal;

/**
 *  Objeto Juego que maneja la direccion de juegos y su appid
 * @author T4C30
 */
public class Juego {
    private Integer appId;
    public static HashMap<Path, Path> enlaceLogros = new HashMap<>();
    public static String usuario;

    public Juego(String carpetaJuego) {
        this.appId = archivotxt(carpetaJuego);
    }



    /**
     * Enlazo la carpetas que contienen un achievements.json
     * @param carpetaJuego ruta de la carpeta juego
     * @return Devuelve un mapa
     */
    public void carpetaLogros(String carpetaJuego){
        String carpetaGolgbergSave = "C:\\Users\\"+usuario+"\\AppData\\Roaming\\Goldberg SteamEmu Saves"+ archivotxt(carpetaJuego) + "\\achievements.json";
        String carpetaJuegoLogros = carpetaJuego + "\\steam_settings\\achievements.json";
        enlaceLogros.put(Paths.get(carpetaJuegoLogros), Paths.get(carpetaGolgbergSave));
    }

    /**
     * Lectura de id del juego
     * @param carpetaJuego ruta de la carpeta juego
     * @return Devuelve el entero del juego
     */
    private int archivotxt(String carpetaJuego) {
        String archivo = carpetaJuego + "appId.txt";

        try {
            archivo = Files.readString(Paths.get(carpetaJuego));
        } catch (IOException ex) {
            MenuPrincipal.alerta("No se pudo revisar el archivo");
        }

        return Integer.parseInt(archivo);
    }


}
