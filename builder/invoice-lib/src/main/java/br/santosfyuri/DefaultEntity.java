package br.santosfyuri;

import java.util.Objects;

public abstract class DefaultEntity implements IEntity {

    public boolean isNew() {
        return Objects.isNull(this.getIdentifier());
    }
}
