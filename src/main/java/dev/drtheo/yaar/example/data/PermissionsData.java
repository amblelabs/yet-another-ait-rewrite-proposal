package dev.drtheo.yaar.example.data;

import dev.drtheo.yaar.data.TData;
import mock.Identifier;
import mock.Loyalty;

public class PermissionsData implements TData<PermissionsData> {

    public static final Holder<PermissionsData> ID = new GsonBacked<>(
            new Identifier("ait", "permissions"), PermissionsData.class);

    private Loyalty.Type p19Loyalty;

    @Override
    public Holder<PermissionsData> holder() {
        return ID;
    }
}
