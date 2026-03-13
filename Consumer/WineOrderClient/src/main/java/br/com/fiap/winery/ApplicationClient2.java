package br.com.fiap.winery;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

// Importando as classes mágicas geradas pelo Maven
import br.com.fiap.winery.stub.WineStockService;
import br.com.fiap.winery.stub.WineWarningService;

public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {

        System.out.println("Iniciando comunicação com os servidores...\n");

        // ==========================================
        // 1. CONSUMINDO O SERVIÇO DE ESTOQUE (Pedido)
        // ==========================================
        URL urlEstoque = new URL("http://localhost:8085/WineStockService?wsdl");
        QName qNameEstoque = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");

        Service serviceEstoque = Service.create(urlEstoque, qNameEstoque);
        WineStockService wineStockService = serviceEstoque.getPort(WineStockService.class);

        // Fazendo o pedido de 5 garrafas de Merlot
        String respostaPedido = wineStockService.placeOrder("Merlot", 5);
        System.out.println("Resposta do Estoque: " + respostaPedido);


        // ==========================================
        // 2. CONSUMINDO O SERVIÇO DE AVISO
        // ==========================================
        URL urlAviso = new URL("http://localhost:8086/WineWarningService?wsdl");
        QName qNameAviso = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");

        Service serviceAviso = Service.create(urlAviso, qNameAviso);
        WineWarningService wineWarningService = serviceAviso.getPort(WineWarningService.class);

        // Recebendo o aviso do sistema
        String respostaAviso = wineWarningService.sendWarn();
        System.out.println("Aviso do Sistema: " + respostaAviso);

        System.out.println("\nComunicação finalizada com sucesso!");
    }
}