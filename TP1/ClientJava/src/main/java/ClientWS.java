import jakarta.xml.ws.Endpoint;
import proxy.BanqueService;
import proxy.BanqueWS;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stub = new BanqueWS().getBanqueServicePort();
        System.out.println(stub.convert(7600));
        System.out.println("Client connected");
    }
}
