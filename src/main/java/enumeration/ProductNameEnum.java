package enumeration;

public enum ProductNameEnum {

    SAUCE_LABS_BACKPACK("Sauce Labs Backpack"),
    SAUCE_LABS_BIKE_LIGHT("Sauce Labs Bike Light"),
    SAUCE_LABS_BOLT_TSHIRT("Sauce Labs Bolt T-Shirt"),
    SAUCE_LABS_FLEECE_JACKET("Sauce Labs Fleece Jacket"),
    SAUCE_LABS_ONESIE("Sauce Labs Onesie"),
    TEST_ALL_THE_THINGS_TSHIRT_RED("Test.allTheThings() T-Shirt (Red)"),
    ;

    public final String product;

    ProductNameEnum(String product) {
        this.product=product;
    }
}
