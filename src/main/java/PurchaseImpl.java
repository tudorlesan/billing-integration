import com.flexionmobile.codingchallenge.integration.Purchase;

public class PurchaseImpl implements Purchase{
    private String id;
    private boolean isConsumed;
    private String itemId;

    public PurchaseImpl(String id, boolean isConsumed, String itemId) {
        this.id = id;
        this.isConsumed = isConsumed;
        this.itemId = itemId;
    }

    public String getId() {
        return this.id;
    }

    public boolean getConsumed() {
        return this.isConsumed;
    }

    public String getItemId() {
        return this.itemId;
    }
}
