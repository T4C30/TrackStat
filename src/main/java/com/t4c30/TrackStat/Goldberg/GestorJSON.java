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

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.t4c30.TrackStat.Cliente.MenuPrincipal;

/**
 *
 * @author T4C30
 */
public class GestorJSON {
    static public String keySteamWebClient; 
    
    // Lectura entre dos archivos JSON
    public static void actualizacion(Path juego){
        Path saveLogro = Juego.enlaceLogros.get(juego);
        

    }

    
    // API REST de Steam para generar un JSON con todo
    public static void steamWebClient(String appId){
        ObjectMapper mapeador = new ObjectMapper();
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest mision = HttpRequest.newBuilder()
                .uri(URI.create("https://api.steampowered.com/ISteamUserStats/GetSchemaForGame/v2/?key="+ keySteamWebClient +"&appid="+appId))
                .build(); 
        try {
            HttpResponse<String> respuesta = cliente.send(mision, HttpResponse.BodyHandlers.ofString());
            JsonNode raiz = mapeador.readTree(respuesta.body());
            JsonNode nodo = raiz.path("game")
                                        .path("availableGameStats")
                                        .path("achievements");
            List<Logro> logros = Arrays.asList(
                mapeador.treeToValue(nodo, Logro[].class)
            );
            mapeador.writeValue(new File("achievements.json"), logros);
        } catch (IOException | InterruptedException e) {
            MenuPrincipal.alerta(e.toString());
        }
    }

    
}
