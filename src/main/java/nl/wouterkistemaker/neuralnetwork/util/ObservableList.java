package nl.wouterkistemaker.neuralnetwork.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public final class ObservableList<T> extends ArrayList<T> implements Observable<Collection<? extends T>> {

    private Collection<? extends T> value;
    private final Set<ChangeListener<Collection<? extends T>>> listeners;

    @SafeVarargs
    public ObservableList(Collection<? extends T> value, ChangeListener<Collection<? extends T>>... listeners) {
        super(value);

        this.value = value;
        this.listeners = new LinkedHashSet<>(Arrays.asList(listeners));
    }

    @Deprecated
    @Override
    public void setValue(Collection<? extends T> value) {
        Collection<? extends T> oldValue = this.value;
        this.value = value;
        this.emit(oldValue, value);
    }

    @Deprecated
    @Override
    public Collection<? extends T> getValue() {
        return value;
    }

    @Override
    public Collection<ChangeListener<Collection<? extends T>>> getListeners() {
        return listeners;
    }

    private void emit(Collection<? extends T> oldValue, Collection<? extends T> value) {
        this.listeners.forEach(l -> l.handle(oldValue, value));
    }
}
