package br.com.fiap.winery;

import jakarta.xml.ws.Endpoint;

public class Loader {
    public static void main(String[] args) {

        // 1. Serviço Antigo (Estoque - 8085)
        WineStockServiceImplementation wineStock = new WineStockServiceImplementation();
        Endpoint.publish("http://localhost:8085/WineStockService", wineStock);

        // 2. SERVIÇO NOVO (Aviso - 8086) - Passo 53 do Roteiro
        WineWarningServiceImplementation wineWarning = new WineWarningServiceImplementation();
        Endpoint.publish("http://localhost:8086/WineWarningService", wineWarning);

        System.out.println("Servidor Ligado! Os dois serviços estão rodando.");
    }
}