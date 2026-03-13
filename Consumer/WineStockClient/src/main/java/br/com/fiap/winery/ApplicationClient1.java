package br.com.fiap.winery;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

// Esta é a classe mágica que o Maven criou para você!
import br.com.fiap.winery.stub.WineStockService;

public class ApplicationClient1 {
    public static void main(String[] args) throws Exception {

        // 1. Aponta para o endereço do WSDL do servidor
        URL url = new URL("http://localhost:8085/WineStockService?wsdl");

        // 2. Aponta para o nome do serviço (Namespace e Nome da Implementação)
        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");

        // 3. Cria a ponte de conexão
        Service service = Service.create(url, qName);

        // 4. Conecta na porta específica do nosso serviço
        WineStockService wineStockService = service.getPort(WineStockService.class);

        // 5. Chama o método do servidor e guarda o resultado na variável 'menu'
        String menu = wineStockService.getMenu();

        // 6. Imprime na tela!
        System.out.println("=========================================");
        System.out.println("Resposta recebida do Servidor:");
        System.out.println(menu);
        System.out.println("=========================================");
    }
}