package br.santosfyuri;

import java.util.Objects;

public abstract class EntityBuilder<E extends IEntity> implements IBuilder<E> {

    protected E entity;

    protected EntityBuilder(E entity) {
        Objects.requireNonNull(entity);
        this.entity = entity;
    }

    public E build() {
        Objects.requireNonNull(this.entity);
        E buildEntity;
        try {
            buildEntity = this.entity;
        } finally {
            this.entity = null;
        }
        return buildEntity;
    }
}
