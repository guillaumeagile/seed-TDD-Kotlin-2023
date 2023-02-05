package draft;

public class Exemple implements IExemple {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void augmenter(int i)  {
        price += i;
    }
}
