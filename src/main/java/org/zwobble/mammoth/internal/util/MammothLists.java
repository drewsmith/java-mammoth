package org.zwobble.mammoth.internal.util;

import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.zwobble.mammoth.internal.util.MammothIterables.stream;

public class MammothLists {
    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    public static <T> List<T> list(T value1) {
        return Collections.singletonList(value1);
    }

    public static <T> List<T> list(T value1, T value2) {
        return asList(value1, value2);
    }

    public static <T> List<T> list(T value1, T value2, T value3) {
        return asList(value1, value2, value3);
    }

    @SafeVarargs
    public static <T> List<T> list(T... values) {
        return asList(values);
    }

    public static <T> List<T> cons(T head, Iterable<T> tail) {
        return eagerConcat(list(head), tail);
    }

    public static <T> List<T> eagerConcat(Iterable<T> first, Iterable<T> second) {
        return Stream.concat(stream(first), stream(second)).collect(Collectors.toList());
    }

    public static <T> List<T> eagerFilter(Iterable<T> iterable, Predicate<T> predicate) {
        return stream(iterable).filter(predicate).collect(Collectors.toList());
    }

    public static <T, R> List<R> eagerMap(Iterable<T> iterable, Function<T, R> function) {
        return stream(iterable).map(function).collect(Collectors.toList());
    }

    public static <T, R> List<R> eagerFlatMap(Iterable<T> iterable, Function<T, Iterable<R>> function) {
        return stream(iterable)
            .flatMap(element -> stream(function.apply(element)))
            .collect(Collectors.toList());
    }

    public static <T, R extends Comparable<R>> List<T> orderedBy(Iterable<T> iterable, Function<T, R> getKey) {
        return orderBy(getKey).sortedCopy(iterable);
    }

    private static <T, R extends Comparable<R>> Ordering<T> orderBy(Function<T, R> getKey) {
        return Ordering.from((first, second) -> getKey.apply(first).compareTo(getKey.apply(second)));
    }

    public static <T> List<T> toList(Iterable<T> iterable) {
        return stream(iterable).collect(Collectors.toList());
    }

    public static <T> Optional<T> tryGetLast(List<T> list) {
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(list.get(list.size() - 1));
        }
    }

    public static <T> List<T> skip(List<T> list, int count) {
        return list.subList(Math.min(list.size(), count), list.size());
    }
}
