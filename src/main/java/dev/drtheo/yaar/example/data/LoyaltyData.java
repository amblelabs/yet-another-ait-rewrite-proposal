package dev.drtheo.yaar.example.data;

import dev.drtheo.yaar.data.TData;
import mock.Identifier;
import mock.Loyalty;

public class LoyaltyData implements TData<LoyaltyData> {

    public static final Holder<LoyaltyData> ID = new GsonBacked<>(
            new Identifier("ait", "loyalty"), LoyaltyData.class);

    private Loyalty.Type p19Loyalty;

    @Override
    public Holder<LoyaltyData> holder() {
        return ID;
    }
}
