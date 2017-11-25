import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

public class IntegrationImpl implements Integration {

    public static final String API_ENDPOINT = "http://sandbox.flexionmobile.com/javachallenge/rest/developer/";
    private Client client;
    private WebTarget baseTarget;

    public IntegrationImpl(String developerName) {
        this.client = ClientBuilder.newClient();
        this.baseTarget = client.target(API_ENDPOINT + developerName);
    }

    public void changeDeveloperName(String developerName) {
        setBaseTarget(client.target(API_ENDPOINT + developerName));
    }

    public void setBaseTarget(WebTarget baseTarget) {
        this.baseTarget = baseTarget;
    }

    public Purchase buy(String s) {
        WebTarget buyPurchaseTarget = baseTarget.path("buy/{itemId}");
        Response getResponse = buyPurchaseTarget.resolveTemplate("itemId", s).request(MediaType.APPLICATION_JSON).post(Entity.json(s));
        if(getResponse.getStatus() != 200){
            //throw exception, maybe RuntimeException since the interface doesn't throw exceptions
        }
        return getResponse.readEntity(Purchase.class);
    }

    public List<Purchase> getPurchases() {
        WebTarget getAllPurchasesTarget = baseTarget.path("all");

        Response postResponse = getAllPurchasesTarget.request(MediaType.APPLICATION_JSON).get();
        if(postResponse.getStatus() != 200){
            //throw exception, maybe RuntimeException since the interface doesn't throw exceptions
        }
        return postResponse.readEntity(new GenericType<List<Purchase>>() {});
    }

    public void consume(Purchase purchase){
        WebTarget consumePurchaseTarget = baseTarget.path("consume/{purchaseId}");
        Response postResponse = consumePurchaseTarget.resolveTemplate("itemId", purchase.getItemId()).request(MediaType.APPLICATION_JSON).post(Entity.json(purchase.getItemId()));
        if(postResponse.getStatus() != 200){
            //throw exception, maybe RuntimeException since the interface doesn't throw exceptions
        }
}
}
